/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ProjectDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Model.LoginInfo;
import Model.ProjectUserDetails;
import Model.UserInfo;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raxton
 */
public class addProject extends HttpServlet {

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
        System.out.println("Welcome to addProject.java");
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            Transaction tr = ss.beginTransaction();
            HttpSession hs = request.getSession();

            String company_name = request.getParameter("company_name");
            String project_name = request.getParameter("project_name");
            String mine_location = request.getParameter("mine_location");
            String mine_area = request.getParameter("mine_area");
            
            int selectedME = Integer.parseInt(request.getParameter("userIdTo").toString());
            System.out.println(selectedME);
            int points = Integer.parseInt(request.getParameter("points"));
            int tasks = Integer.parseInt(request.getParameter("tasks"));
            int userId = (int) hs.getAttribute("userId");
            System.out.println("Got a few the parameters.");
            LoginInfo userIdFrom = new LoginInfo();
            userIdFrom.setUserId(userId);
//==============due date from table ==================
            String dayfield =request.getParameter("dayfield");
            String monthfield =request.getParameter("monthfield");
            String yearfield = request.getParameter("yearfield");
            String dt = yearfield + "-" + monthfield + "-" + dayfield;
            System.out.println("Date Before Save ::::::" + dt);

            ProjectDetails proj_det = new ProjectDetails();
            proj_det.setUserIdFrom(userIdFrom);
            proj_det.setCompanyName(company_name);
            proj_det.setProjectName(project_name);
            proj_det.setMineLocation(mine_location);
            proj_det.setMineArea(mine_area);
            proj_det.setPoints(points);
            proj_det.setTasks(tasks);
            proj_det.setTasksRemaining(tasks);            
            proj_det.setDueDate(dt);            
            ss.save(proj_det);
            System.out.println("proj_det saved.");
                                    
            LoginInfo userIdTo=new LoginInfo(selectedME);
            ProjectUserDetails pud = new ProjectUserDetails();
            pud.setMineId(proj_det);
            pud.setUserIdTo(userIdTo);
            ss.save(pud);
            System.out.println("pud saved.");

//           ======logic for user id to==========
            tr.commit();
//            RequestDispatcher rd = request.getRequestDispatcher("/Geologist/SuccessGeo.jsp");
//            rd.forward(request, response);

            path = "SuccessGeo.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (Exception e) {
            path = "FailureGeo.jsp";
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