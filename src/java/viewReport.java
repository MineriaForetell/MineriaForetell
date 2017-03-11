import Model.LoginInfo;
import Model.MineriaDetails;
import Model.MiningDrillDataToExport;
import Model.ProjectDetails;
import Model.TaskDetails;
import Model.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raxton
 */
public class viewReport extends HttpServlet {

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
        String path="viewReport.jsp";
        try{
            int mine = Integer.parseInt(request.getParameter("mineId").toString());
            ProjectDetails mineId = new ProjectDetails(mine);
            
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            Transaction tr = ss.beginTransaction();
            
            Criteria cr = ss.createCriteria(MineriaDetails.class);
            cr.add(Restrictions.eq("mineId",mineId));
            ArrayList<MineriaDetails> mineria_details = (ArrayList<MineriaDetails>) cr.list();
            System.out.println(mineria_details.size());
            request.setAttribute("mineria_details", mineria_details); 
            
            Criteria cr1 = ss.createCriteria(ProjectDetails.class);
            cr1.add(Restrictions.eq("mineId",mine));
            ArrayList<ProjectDetails> pd = (ArrayList<ProjectDetails>) cr1.list();            
            request.setAttribute("proj_det", pd.get(0));
                        
            String hql = "SELECT count(Material) reading, Material FROM MiningProcessSchema.MiningDrillDataToExport group by Material";
            org.hibernate.Query query = ss.createQuery(hql);
            List results = query.list();
            request.setAttribute("graphData", results);
            tr.commit();
                      
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        }
        catch(Exception e)
        {
            path = "FailureDRO.jsp";
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