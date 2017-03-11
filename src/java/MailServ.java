
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class MailServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "";
        RequestDispatcher rd;
        try {
            String mail = request.getParameter("mail");
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session s = sf.openSession();
            Transaction tr = s.beginTransaction();

            Criteria c = s.createCriteria(LoginInfo.class);
            c.add(Restrictions.eq("username", mail));

            ArrayList<LoginInfo> al = (ArrayList<LoginInfo>) c.list();
            tr.commit();
            String name = null;
            if (al.size() > 0) {
                LoginInfo l = al.get(0);
                name = l.getPassword();
                System.out.println(name);
                String subject = "Forgot Password - Mineria Foretell";
                String content = "Your username : "+mail+" and " +"Your password : " + name;
//                System.out.println("content pswd : " + content);
                String[] recipients = new String[]{mail};
                //String[] bccRecipients = new String[]{"rakshit.geo@gmail.com"};  

                if (new MailUtil().sendMail(recipients, subject, content)) {
                    String msg = "Password is sent to your registered email id!";
                    request.setAttribute("msg1", msg);
                }
            } else {
                String msg = "Please enter an existing email!";
                request.setAttribute("msg1", msg);
                System.out.println(msg);
            }
            path = "reset.jsp";
        } catch (Exception e) {
            out.println(e.getMessage());
            path = "reset.jsp";
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
