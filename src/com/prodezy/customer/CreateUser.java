package com.prodezy.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
		 String employeeName=request.getParameter("isEmployee");
		 System.out.println(employeeName);

		 String uname=request.getParameter("username").replace(" ", "");
	     String pass=request.getParameter("pass").trim();
	     String pass1=request.getParameter("pass1").trim();
	     String message="";
	     if(!uname.equals(""))
	     {	    	 
	    	 if(!pass.equals("")&&!pass1.equals(""))
			 {
				 if(pass.equals(pass1))
				 {
//	                 String createUserAPICall = "useradd?username=" + URLEncoder.encode(uname, "UTF-8") + "&password=" + URLEncoder.encode(pass, "UTF-8") + "&password_confirmation=" + URLEncoder.encode(pass1, "UTF-8") + "&acc_expiry_option=n&email=example@example.com&firstname=" + URLEncoder.encode(names[0], "UTF-8") + "&lastname=" + URLEncoder.encode(names[1], "UTF-8") + "&email=example@example.com&role_id=" + URLEncoder.encode(role + "", "UTF-8") + "&user_type=operator&contactno=&theme=&profile_photo=&department_id=4,3&designation_id=" + URLEncoder.encode(department_id + "", "UTF-8") + "&acc_expiry_option=&expiry_date=&ref_emp_id=" + URLEncoder.encode("" + employeeName, "UTF-8");	    		 	    		 
					 message="User Create Successfully!";
				 }else {	    		 
					 message="Please Enter Correct Password!";
				 }
			 }else {
				 message="Please Enter Password!";				 
			 }
	     }else {
	    	 message="Please Enter User Name!";
	     }	     
     	 response.sendRedirect("buttons.jsp?message=" + URLEncoder.encode(message, "UTF-8"));    	 
	}
}
