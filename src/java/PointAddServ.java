/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.PointModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author raxton
 */
public class PointAddServ extends HttpServlet {

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
        try {
            ArrayList<PointModel> pList = new ArrayList<>();
            PointModel p = new PointModel();
            HttpSession hs = request.getSession();
            if (request.getParameter("index") == null) {
                int pid = Integer.parseInt(request.getParameter("assign-pt"));
                String ploc = request.getParameter("location");
                p.setPoint_id(pid);
                p.setLocation(ploc);
                if (hs.getAttribute("pList") != null) {
                    pList = (ArrayList<PointModel>) hs.getAttribute("pList");
                    pList.add(p);
                } else {
                    pList.add(p);
                }
            } else {
                int i = Integer.parseInt(request.getParameter("index").toString());
                pList=(ArrayList<PointModel>)hs.getAttribute("pList");
                pList.remove(i);
            }

            hs.setAttribute("pList", pList);
            String path="assignWork.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            System.out.println("Forwarding to "+path);
            rd.forward(request, response);
        }
        catch (HibernateException e) {
            System.out.println(e.getMessage()+"Got stuck in PointAddServ.java!!");
            out.println(e.getMessage());
            String path = "FailureME.jsp";
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