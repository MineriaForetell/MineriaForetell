import Model.ProjectDetails;
import Model.TaskDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raxton
 */
public class UploadFile extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String path = "";        
        try {
        
            int taskId = Integer.parseInt(request.getParameter("taskId"));           
            
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            Transaction tr = ss.beginTransaction();
            
            Criteria cr = ss.createCriteria(TaskDetails.class);
            cr.add(Restrictions.eq("taskId",taskId));
            ArrayList<TaskDetails> td = (ArrayList<TaskDetails>) cr.list();
            int mineId = Integer.parseInt(td.get(0).getMineId().toString());
            //        -----------------
            File file = new File("/home/raxton/uploads/" + mineId);

            if (file.mkdir()) {
//                if (!file.exists()) {

                    MultipartRequest m = new MultipartRequest(request, "/home/raxton/uploads/" + mineId);
                    String msg = "File Uploaded Successfully!";
                    request.setAttribute("msg1", msg);
                }            

                path = "uploadFile.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);
            
        
        } catch (Exception e) {
            String msg = "File Upload Failed , Please Try Again !";
            request.setAttribute("msg1", msg);
            path = "uploadFile.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }

    }

}