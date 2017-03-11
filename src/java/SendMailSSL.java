import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.LoginInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class SendMailSSL extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "";
        RequestDispatcher rd;
        try {
            String contact = request.getParameter("user_contact_number");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String subject = "We Want Use Mineria Foretell Web Application for ";
            String content = "Hey There !!! " + "I am " + fullname +", my contact number is "+ contact +", and my Email id is " + email + " and " + subject + "..." + request.getParameter("content");
            String mail = "mineriaforetell@gmail.com";
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session s = sf.openSession();
            Transaction tr = s.beginTransaction();

           
            tr.commit();
            String name = null;
            if (true) {
                String[] recipients = new String[]{mail};
                //String[] bccRecipients = new String[]{"rakshit.geo@gmail.com"};  

                if (new MailUtil().sendMail(recipients, subject, content)) {
                    String msg = "Mail Sent! You will be get detailed Email soon !";
                    request.setAttribute("msg1", msg);
                }
            } else {
                String msg = "Please try again after few minuites!";
                request.setAttribute("msg1", msg);
                System.out.println(msg);
            }
            path = "index.jsp";
        } catch (Exception e) {
            out.println(e.getMessage());
            path = "index.jsp";
        }

        rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

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
