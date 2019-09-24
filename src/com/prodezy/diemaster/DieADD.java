package com.prodezy.diemaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.webservices.WebAPITester;

@WebServlet("/dieadd")
public class DieADD extends HttpServlet{

	private static final long serialVersionUID = 1L;
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	PrintWriter out = resp.getWriter();
	RequestDispatcher rd;

	 System.out.println("servlet call");
	 String die_tool="";
     String die_name="";
     String total_strokes="";
     String maintenance_strokes="";
     String reminder_count="";
     String cost_maintenance="";
     String Datepicker="";
     String prev_main_date="";
     String date_purchase="";
     String cost_purchase="";
     String owned_by="";
     String tonnage="";
     String dimensions="";
     String shut_height="";
     String die_id="";
	 try {
	die_id=req.getParameter("die_id");
	 die_tool=req.getParameter("die_tool");
     die_name=req.getParameter("die_tool_name");
     total_strokes=req.getParameter("total_strokes");
     maintenance_strokes=req.getParameter("main_freq");
     reminder_count=req.getParameter("rem_count");
     cost_maintenance=req.getParameter("cost_maintenance");
     Datepicker=req.getParameter("Datepicker");
     prev_main_date=req.getParameter("prev_main_date");
     date_purchase=req.getParameter("date_purchase");
     cost_purchase=req.getParameter("cost_purchase");
     owned_by=req.getParameter("owned_by");
     shut_height=req.getParameter("shut_height");
     tonnage=req.getParameter("tonnage");
     dimensions=req.getParameter("dimensions");
   
	 }catch(Exception e)
	 {
		 //System.out.println("catch call");
		 resp.sendRedirect("DieMaster.do?message=" + URLEncoder.encode("please fill data", "UTF-8"));
	 }

     //HttpSession session = request.getSession(false);
     
     String addEmpAPICall = null;
     String result2 =null;
     //System.out.println("check empty");
     String value=req.getParameter("Add_to_Die_Master");
		//System.out.println("value of button is = "+value);
		
     if (!die_tool.isEmpty() && !die_name.isEmpty() && !(prev_main_date=="") && !total_strokes.isEmpty() && !maintenance_strokes.isEmpty() && !reminder_count.isEmpty() && !cost_purchase.isEmpty() && !owned_by.isEmpty()) {
        if(value.contentEquals("Add_to_Die_Master")) { 
    	 try {
    		 
    		   addEmpAPICall = "die_tool_add?die_tool_no=" + URLEncoder.encode(die_tool, "UTF-8") + 
        		 "&die_name=" + URLEncoder.encode(die_name, "UTF-8") + 
        		 "&total_strokes=" + URLEncoder.encode(total_strokes, "UTF-8") + 
        		 "&cost_maintenance=" + URLEncoder.encode(cost_maintenance, "UTF-8") + 
        		 "&maintenance_strokes=" + URLEncoder.encode(maintenance_strokes, "UTF-8") +
        		 "&reminder_count=" + URLEncoder.encode(reminder_count, "UTF-8") + 
        		 "&date_maintenance=" + URLEncoder.encode(Datepicker, "UTF-8") +
        		 "&owner_id=" + URLEncoder.encode(owned_by, "UTF-8") + 
        		 "&reminder_date=" + URLEncoder.encode(prev_main_date, "UTF-8") +
        		 "&date_purchase=" + URLEncoder.encode(date_purchase, "UTF-8") +
        		 "&cost_purchase=" + URLEncoder.encode(cost_purchase, "UTF-8") + 
        		 "&machine_id=" + URLEncoder.encode( "1", "UTF-8") +
        		 "&shut_height=" + URLEncoder.encode(shut_height, "UTF-8") + 
        		 "&tonnage=" + URLEncoder.encode(tonnage, "UTF-8") + 
        		 "&dimension=" + URLEncoder.encode(dimensions, "UTF-8");
    	 
         result2 = WebAPITester.prepareWebCall(addEmpAPICall);
         System.out.println(result2);
    	 }catch(UnsupportedEncodingException e)
    	 {
    		 e.getMessage();
    	 }
         
    	   String message="Records are added successfully..";
	       // System.out.printf("\n value of result "+result);	
	        req.setAttribute("errorMessage",message );
			 rd =req.getRequestDispatcher("/DieMaster.do");
			 rd.forward(req, resp);         
     }
     else if(value.contentEquals("Edit_record"))	{
	    // System.out.printf("\n edit record Id"+die_tool+"\n");	

    	 addEmpAPICall = "die_tool_update?DT_ID=" + URLEncoder.encode(die_id, "UTF-8") 
    	 		+ "&die_tool_no=" + URLEncoder.encode(die_tool, "UTF-8") + 
        		 "&die_name=" + URLEncoder.encode(die_name, "UTF-8") + 
        		 "&total_strokes=" + URLEncoder.encode(total_strokes, "UTF-8") + 
        		 "&cost_maintenance=" + URLEncoder.encode(cost_maintenance, "UTF-8") + 
        		 "&maintenance_strokes=" + URLEncoder.encode(maintenance_strokes, "UTF-8") +
        		 "&reminder_count=" + URLEncoder.encode(reminder_count, "UTF-8") + 
        		 "&date_maintenance=" + URLEncoder.encode(Datepicker, "UTF-8") +
        		 "&owner_id=" + URLEncoder.encode(owned_by, "UTF-8") + 
        		 "&reminder_date=" + URLEncoder.encode(prev_main_date, "UTF-8") +
        		 "&date_purchase=" + URLEncoder.encode(date_purchase, "UTF-8") +
        		 "&cost_purchase=" + URLEncoder.encode(cost_purchase, "UTF-8") + 
        		 "&machine_id=" + URLEncoder.encode( "1", "UTF-8") +
        		 "&shut_height=" + URLEncoder.encode(shut_height, "UTF-8") + 
        		 "&tonnage=" + URLEncoder.encode(tonnage, "UTF-8") + 
        		 "&dimension=" + URLEncoder.encode(dimensions, "UTF-8");	
			String result= WebAPITester.prepareWebCall ( addEmpAPICall);
		    // System.out.printf("\n edit record in die"+result+"\n");	
		     

		        String message="Record updated successfully...";
		       // System.out.println("else part of validation");
				 req.setAttribute("errorMessage",message );
				 rd =req.getRequestDispatcher("/DieMaster.do");
				 rd.forward(req, resp);
     }
			
     else
     {
	        String message="Please fill all Fields!!";
	       // System.out.println("else part of validation");
			 req.setAttribute("errorMessage",message );
			 rd =req.getRequestDispatcher("/DieMaster.do");
			 rd.forward(req, resp);
     }
	}	
}
}
