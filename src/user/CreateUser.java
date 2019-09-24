package user;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 String employeeName=request.getParameter("isEmployee");

		 String uname=request.getParameter("username").replace(" ", "");
	     String pass=request.getParameter("pass");
	     String pass1=request.getParameter("pass1");
	     String message="";
	     if(!uname.equals(""))
	     {	    	 
	    	 if(pass.equals(pass1))
	    	 {
	    		 message="User Create Successfully!";
//	    		 response.sendRedirect("CreateUser.jsp");
	    	 }else {	    		 
		    	 message="Please Enter Correct Password!";
//		    	 response.sendRedirect("CreateUser.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	    	 }
	     }else {
	    	 message="Please Enter User Name!";
//	    	 response.sendRedirect("CreateUser.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	     }

	     
    	 response.sendRedirect("CreateUser.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
    	 
	}
}
