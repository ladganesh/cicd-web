package com.prodezy.supplier;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.webservices.WebAPITester;

/**
 * Servlet implementation class SupplierAdd
 */
@WebServlet("/SupplierAdd")
public class SupplierAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAdd() {
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
		RequestDispatcher rd;
		String supp_id,supp_name,  supp_add, supp_cnt_ll,  supp_cnt_brd,  week_off,  gst_no, vendor_code, category, city, authorised,segment;
		supp_id=request.getParameter("id");
		supp_name=request.getParameter("name1");
		supp_add=request.getParameter("addr");
		supp_cnt_ll=request.getParameter("contll");
		week_off=request.getParameter("weeklyoff");
		gst_no=request.getParameter("gstno");
		vendor_code=request.getParameter("vender_code");
		category=request.getParameter("category");
		city=request.getParameter("city");
		segment=request.getParameter("segment");
	//	authorised=request.getParameter("plt_id");
				
		String value=request.getParameter("Add_To_Master");
		System.out.println("value of button is = "+value);
		if(!(supp_name=="" || supp_add=="" ||week_off==""|| gst_no=="" || vendor_code=="" || city=="" || category=="")) {
				if(value.contains("Add_To_Master")) 
					{
					System.out.println("SUPP_NAME="+supp_name+"&SUPP_ADD="+supp_add+"&SUPP_CNT_LL="+supp_cnt_ll+"&SUPP_CNT_BRD="+"&WEEK_OFF="+week_off+"&GST_NO="+gst_no+"&VENDOR_CODE="+vendor_code+"&CATEGORY="+category+"&PAY_TERMS="+"&CITY="+city+"&INDUSTRY="+"&SEGMENT="+segment+"&AUTHORIZED_RM=");
					
						String apinamecall="suppliersadd?SUPP_NAME="+URLEncoder.encode(supp_name, "UTF-8")+"&SUPP_ADD="+URLEncoder.encode(supp_add, "UTF-8")+"&SUPP_CNT_LL="+URLEncoder.encode(supp_cnt_ll, "UTF-8")+"&SUPP_CNT_BRD="+URLEncoder.encode("null", "UTF-8")+"&WEEK_OFF="+URLEncoder.encode(week_off, "UTF-8")+
								"&GST_NO="+URLEncoder.encode(gst_no, "UTF-8")+"&VENDOR_CODE="+URLEncoder.encode(vendor_code, "UTF-8")+"&CATEGORY="+URLEncoder.encode(category, "UTF-8")+"&PAY_TERMS="+URLEncoder.encode("null", "UTF-8")+"&CITY="+URLEncoder.encode(city, "UTF-8")+"&INDUSTRY="+URLEncoder.encode("null", "UTF-8")+"&SEGMENT="+URLEncoder.encode(segment, "UTF-8")+"&AUTHORIZED_+RM="+URLEncoder.encode("null", "UTF-8");
						//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully save..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Supplier.do");
						 rd.forward(request, response);	
					}
					
				else if(value.contentEquals("Edit_record"))
					{
						

					String apinamecall="supplierssupdate?SUPP_ID="+URLEncoder.encode(supp_id, "UTF-8")+"&SUPP_NAME="+URLEncoder.encode(supp_name, "UTF-8")+"&SUPP_ADD="+URLEncoder.encode(supp_add, "UTF-8")+"&SUPP_CNT_LL="+URLEncoder.encode(supp_cnt_ll, "UTF-8")+"&SUPP_CNT_BRD="+URLEncoder.encode("null", "UTF-8")+"&WEEK_OFF="+URLEncoder.encode(week_off, "UTF-8")+
							"&GST_NO="+URLEncoder.encode(gst_no, "UTF-8")+"&VENDOR_CODE="+URLEncoder.encode(vendor_code, "UTF-8")+"&CATEGORY="+URLEncoder.encode(category, "UTF-8")+"&PAY_TERMS="+URLEncoder.encode("null", "UTF-8")+"&CITY="+URLEncoder.encode(city, "UTF-8")+"&INDUSTRY="+URLEncoder.encode("null", "UTF-8")+"&SEGMENT="+URLEncoder.encode(segment, "UTF-8")+"&AUTHORIZED_+RM="+URLEncoder.encode("null", "UTF-8");
					
					//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully updated..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Supplier.do");
						 rd.forward(request, response);		
						 }
					else
					{/*
						 String message="Your record is not save..Please try later";
						 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
				        String message="Please fill all Fields!!";
				       // System.out.println("else part of validation");
						 request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Supplier.do");
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
			 rd =request.getRequestDispatcher("/Supplier.do");
			 rd.forward(request, response);
		}
		
		
		

	
		
		
	}

}
