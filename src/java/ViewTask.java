/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.LoginInfo;
import Model.TaskDetails;
import Model.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
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
public class viewTask extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String path = "";        
        try {            
           HttpSession hs = request.getSession();            
           SessionFactory sf = NewHibernateUtil.getSessionFactory();                      
           Session ss = sf.openSession();           
           Transaction tr = ss.beginTransaction();           
                                            
           int userId = Integer.parseInt(hs.getAttribute("userId").toString());
           String page= request.getParameter("page").toString();
           LoginInfo user_id_to = new LoginInfo();
           user_id_to.setUserId(userId);           
            
           Criteria cr = ss.createCriteria(TaskDetails.class);          
           cr.add(Restrictions.eq("userIdTo", user_id_to));           
           ArrayList<TaskDetails> TaskList = (ArrayList<TaskDetails>) cr.list();
            System.out.println(TaskList.size());
           
           int i=0;
           UserInfo ui=null;
           Criteria cr1 = ss.createCriteria(UserInfo.class);
           ArrayList<UserInfo> uiList = new ArrayList<UserInfo>();
           for(i=0;i<TaskList.size();i++){
                cr1.add(Restrictions.eq("userId", TaskList.get(i).getUserIdFrom()));
                System.out.println("criteria "+i);
                ui = (UserInfo) cr1.list().get(0);                
                uiList.add(ui);                
           }                  
           
           request.setAttribute("TaskList",TaskList); 
           request.setAttribute("uiList", uiList);
           request.setAttribute("page", page);           
           
           path="TaskList.jsp";
           RequestDispatcher rd = request.getRequestDispatcher(path);
           rd.forward(request, response);
           
        }
        catch(Exception e){
            path = "FailureDRO.jsp";
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
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