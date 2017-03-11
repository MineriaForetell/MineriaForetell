import java.io.IOException;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
public class SendMailwithSSL extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = "We Want Use Mineria Foretell Web Application";
		String content = "Hey There !!! "+"I am "+fullname+", and my Email id is "+email+" and "+subject+":"+request.getParameter("content");
		
		if(!content.equals(null)){
			Properties props = new Properties();
	        	Session session = Session.getDefaultInstance(props, null);
			
		try {
	                Message m = new MimeMessage(session);
	                m.setFrom(new InternetAddress(email, "user"));
	                m.addRecipient(Message.RecipientType.TO, new InternetAddress("mineriaforetell@gmail.com", "mineriaonly"));
	                m.setSubject(subject);
	                m.setText(content);
	                Transport.send(m);
	        } catch (AddressException e) {
	        	e.printStackTrace();
	        } catch (javax.mail.MessagingException e) {
		        e.printStackTrace();
		}
	        
		RequestDispatcher view = request.getRequestDispatcher("Success.jsp");
			
		view.forward(request, response);
		}
	}
}