/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.LoginInfo;
import Model.ProjectDetails;
import Model.ProjectUserDetails;
import Model.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raxton
 */
public class ProjectList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page="null";
        PrintWriter out = response.getWriter();
        try{
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            Transaction tr = ss.beginTransaction();
            
            page = request.getParameter("page");
            request.getSession().setAttribute("page", page);            
            
            String role="", path="ProjectList.jsp";
            Criteria cr=null;
            ArrayList<ProjectDetails> ProjectList = new ArrayList<ProjectDetails>();
            ArrayList<ProjectUserDetails> ProjectUserList=null;
            
            LoginInfo loginInfo=(LoginInfo) request.getSession().getAttribute("loginInfo");
            int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
            role = request.getSession().getAttribute("role").toString();

            HttpServletRequest request1 = (HttpServletRequest) request;
            String uri = request1.getRequestURI();
            switch (role) {
                case "G":
                    ProjectDetails pd = new ProjectDetails();
                    cr = ss.createCriteria(ProjectDetails.class);
                    cr.add(Restrictions.eq("userIdFrom", loginInfo));  
                    ProjectList = (ArrayList<ProjectDetails>) cr.list();
//                    System.out.println(ProjectList.size());
                    break;
                
                default:
                    ProjectUserDetails pudDRO = new ProjectUserDetails();
                    cr = ss.createCriteria(ProjectUserDetails.class);
                    cr.add(Restrictions.eq("userIdTo", loginInfo));
                    ProjectUserList = (ArrayList<ProjectUserDetails>) cr.list();
//                    System.out.println(ProjectUserList.size());
                    
//                    ProjectDetails mineId;
//                    ProjectDetails pd1;
//                    for (int i = 1; i <= ProjectUserList.size(); i++) {
//                         mineId=(ProjectDetails) ProjectUserList.get(i).getMineId();                         
////                         pd1 = new ProjectDetails();
////                         cr = ss.createCriteria(ProjectDetails.class);
////                         cr.add(Restrictions.eq("mineId", mineId));                           
//                         ProjectList.set(i, mineId);
//                    }
                    for(ProjectUserDetails pud: ProjectUserList  ){
                       Criteria cr3 = ss.createCriteria(ProjectDetails.class);
                       cr3.add(Restrictions.eq("mineId", pud.getMineId().getMineId()));
                       ArrayList<ProjectDetails> pList = (ArrayList<ProjectDetails>)cr3.list();
                       
                       if(pList.size()!=0){
                           ProjectList.add(pList.get(0));
                       }
                    
                    }
                    break;
            }
            
            tr.commit();
            HttpSession hs = request.getSession();
            hs.setAttribute("ProjectList", ProjectList);
            RequestDispatcher rd=request.getRequestDispatcher(path);
            rd.forward(request, response);
          
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}