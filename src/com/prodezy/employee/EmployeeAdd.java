package com.prodezy.employee;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.webservices.WebAPITester;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/EmployeeAdd")
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		

		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in employeeadd is "+errormessage+ " ");
		
		
		RequestDispatcher rd;
	
		String employeepk,emp_name,emp_no,join_dt,gender,departmentid,role,is_user,add_local,add_perm;
		

		/*//role=request.getParameter("cont_no");
		//is_user=request.getParameter("email_addr");
			//complogo=request.getParameter();
//		plantemail=request.getParameter("plt_email_addr");
*/
		employeepk=request.getParameter("employeepk");
		emp_name=request.getParameter("name");
		emp_no=request.getParameter("empno");
		join_dt=request.getParameter("isdept");
	//	photo=request.getParameter("myFile");
		gender=request.getParameter("gender");
		departmentid=request.getParameter("isdept");
		add_local=request.getParameter("laddress");
		add_perm=request.getParameter("paddress");
		String value=request.getParameter("Add_to_Employee");
		System.out.println(" value of button is = "+value);
		if (!(emp_name == "" || emp_no == "" || join_dt == "" || gender == ""||  departmentid=="" ||  add_local=="" || add_perm==""))
		{
			if(value.contains("Add_to_Employee")) 
				{
					System.out.println(" value of button is test********");
	
					String apinamecall="employeeadd?EMP_NAME="+URLEncoder.encode(emp_name, "UTF-8")+"&EMP_NO="+URLEncoder.encode(join_dt, "UTF-8")+"&DEPARTMENTID="+URLEncoder.encode(departmentid, "UTF-8")+"&GENDER="+URLEncoder.encode(gender, "UTF-8")+"&ADD_LOCAL="+URLEncoder.encode(add_local, "UTF-8");
					//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
					String result= WebAPITester.prepareWebCall (apinamecall);
			        String message="Your record is successfully save..";
			        System.out.println("\n value of result "+result);	
			        request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/Emptable.do");
					 rd.forward(request, response);	
				}
		
				else if(value.contentEquals("Edit_record")) {
			
				
				String apinamecall="employeeupdate?EmployeePK="+URLEncoder.encode(employeepk, "UTF-8")+"&EMP_NAME="+URLEncoder.encode(emp_name, "UTF-8")+"&EMP_NO="+URLEncoder.encode(join_dt, "UTF-8")+"&DEPARTMENTID="+URLEncoder.encode(departmentid, "UTF-8")+"&GENDER="+URLEncoder.encode(gender, "UTF-8")+"&ADD_LOCAL="+URLEncoder.encode(add_local, "UTF-8");
				//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
				String result= WebAPITester.prepareWebCall ( apinamecall);
		        String message="Your record is successfully updated..";
		        System.out.printf("\n value of result "+result);	
		        request.setAttribute("errorMessage",message );
				 rd =request.getRequestDispatcher("/Emptable.do");
				 rd.forward(request, response);		
				 }
				else
				{/*
					 String message="Your record is not save..Please try later";
					 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
			        String message="Please fill all Fields!!";
			        System.out.println("else part of validation");
					 request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/Emptable.do");
					 rd.forward(request, response);
				}
		}
		else
		{/*
			 String message="Your record is not save..Please try later";
			 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
	        String message="Please fill all Fields!!";
	        System.out.println("else part of validation");
			 request.setAttribute("errorMessage",message );
			 rd =request.getRequestDispatcher("/Emptable.do");
			 rd.forward(request, response);
		}
		
		

	}
}


