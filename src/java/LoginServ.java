import Model.LoginInfo;
import Model.ProjectDetails;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raxton
 */
public class LoginServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "", role = "";
        try {

            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            Transaction tr = ss.beginTransaction();

            Criteria cr = ss.createCriteria(LoginInfo.class);
            cr.add(Restrictions.eq("username", request.getParameter("username")));
            cr.add(Restrictions.eq("password", request.getParameter("password")));
            ArrayList<LoginInfo> loginlist = (ArrayList<LoginInfo>) cr.list();
            LoginInfo lif = loginlist.get(0);
//            int uname = lif.getUserId();

//         -----------------userinfo----------  
            Criteria UIcr1 = ss.createCriteria(UserInfo.class);
            UIcr1.add(Restrictions.eq("userId", lif));
            ArrayList<UserInfo> UIlist = (ArrayList<UserInfo>) UIcr1.list();

            UserInfo ui = UIlist.get(0);
            String fname = ui.getUserFirstName();
            int userId = lif.getUserId();
            role = lif.getRole();

            HttpSession hs = request.getSession();
            hs.setAttribute("fname", ui);
            hs.setAttribute("userId", userId);
            hs.setAttribute("loginInfo", lif);
            hs.setAttribute("role", role);
            switch (role) {
                case "G":
                    path = "IndexGeologist.jsp";
                    Criteria UIcr2 = ss.createCriteria(UserInfo.class);
                    UIcr2.add(Restrictions.eq("userAddedBy", userId));
                    ArrayList<UserInfo> MEList = (ArrayList<UserInfo>) UIcr2.list();
                    hs.setAttribute("MEList", MEList);
                    break;
                case "M":
                    path = "IndexMiningEngineer.jsp";
                    Criteria UIcr3 = ss.createCriteria(UserInfo.class);
                    UIcr3.add(Restrictions.eq("userAddedBy", userId));
                    ArrayList<UserInfo> DROList = (ArrayList<UserInfo>) UIcr3.list();
                    hs.setAttribute("DROList", DROList);
                    break;
                case "D":
                    path = "IndexDrillRig.jsp";

                    break;
                default:
                    path = "Login.jsp";
                    break;
            }
            tr.commit();
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (Exception e) {
//            response.sendRedirect(request.getContextPath() + "/Login.jsp");
            path = "Login.jsp";
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
