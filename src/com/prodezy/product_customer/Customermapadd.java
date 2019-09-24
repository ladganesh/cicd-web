package com.prodezy.product_customer;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.webservices.WebAPITester;

import webcall.SpinnerList;

/**
 * Servlet implementation class Customermapadd
 */
@WebServlet("/Customermapadd")
public class Customermapadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customermapadd() {
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
		
		
		
		 ArrayList<ProductDr> list = new SpinnerList().getProduct_customer();
	        
		
		
		RequestDispatcher rd;
        String part_code=request.getParameter("fgc_id");
        String Customer=request.getParameter("customer");
        String fg_id=request.getParameter("isFg");
        String sales_rate=request.getParameter("sales_rate");
        
    	System.out.println("Testing= "+part_code+Customer+fg_id+sales_rate);
    	
       String value=request.getParameter("Add_to_Master");
		System.out.println("value of button is = "+value);
		if(!(part_code=="" || Customer==""|| sales_rate=="")) {
				if(value.contains("Add_to_Master")) 
					{
					System.out.println("add data into fg_customer_map");
					
					String apinamecall="customermapadd?M_FG_ID="+URLEncoder.encode(fg_id, "UTF-8")
					+"&M_CUST_ID="+URLEncoder.encode(Customer, "UTF-8")+"&SALES_RATE="+URLEncoder.encode(sales_rate, "UTF-8")
					+"&S_UOM_ID="+URLEncoder.encode("NOS", "UTF-8");
					System.out.println("api call for raw material"+apinamecall);
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully save..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/ProductCustomer.do");
						 rd.forward(request, response);	
					}
					
				else if(value.contains("edit_record"))
					{
						
					System.out.println("update data into fg_customer_map");
					
					String apinamecall="customermapupdate?FG_C_ID="+URLEncoder.encode(part_code,"UTF-8")+"&M_FG_ID="+URLEncoder.encode(fg_id, "UTF-8")
					+"&M_CUST_ID="+URLEncoder.encode(Customer, "UTF-8")+"&SALES_RATE="+URLEncoder.encode(sales_rate, "UTF-8")
					+"&S_UOM_ID="+URLEncoder.encode("NOS", "UTF-8");
						//System.out.println("api call for raw material"+apinamecall);
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully updated..";
				        System.out.printf("\n value of result "+result);
				        request.setAttribute("errorMessage",message );
				        rd =request.getRequestDispatcher("/ProductCustomer.do");
						rd.forward(request, response);	
						 }
				else if(value.contains("delete_record"))
				{
					
				System.out.println("delete data into fg_customer_map");
				
				String apinamecall="customermapdelete?FG_C_ID="+URLEncoder.encode(part_code,"UTF-8");
					//System.out.println("api call for raw material"+apinamecall);
					String result= WebAPITester.prepareWebCall ( apinamecall);
			        String message="Your record is successfully deleted..";
			        System.out.printf("\n value of result "+result);
			        request.setAttribute("errorMessage",message );
			        rd =request.getRequestDispatcher("/ProductCustomer.do");
					rd.forward(request, response);	
					 }
					else
					{/*
						 String message="Your record is not save..Please try later";
						 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
				        String message="Please fill all Fields!!";
				       // System.out.println("else part of validation");
						 request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/ProductCustomer.do");
						 rd.forward(request, response);
					}
		}
		else
		{/*
			 String message="Your record is not save..Please try later";
			 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
	        String message="Please fill all Fields!!";
	       // System.out.println("else part of validation");
			 request.setAttribute("errorMessage",message );
			 rd =request.getRequestDispatcher("/ProductCustomer.do");
			 rd.forward(request, response);
		}
	
	}

	

}
