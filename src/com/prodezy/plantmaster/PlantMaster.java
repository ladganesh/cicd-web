package com.prodezy.plantmaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlantMaster
 */
@WebServlet("/PlantMaster")
public class PlantMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantMaster() {
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
		 	String selectedID="";
			String company_name=request.getParameter("company_name");
	        String plant_code=request.getParameter("plant_code");
	        String gst_no=request.getParameter("gst_no");
	        String plt_cont_no=request.getParameter("plt_cont_no");
	        String plt_email_addr=request.getParameter("plt_email_addr");
	        String weekly_off=request.getParameter("weekly_off");
	        String plt_name=request.getParameter("plt_name");
	        String cont_person_nm=request.getParameter("cont_person_nm");
	        String cont_no=request.getParameter("cont_no");
	        String email_addr=request.getParameter("email_addr");
	        String plt_addr=request.getParameter("plt_addr");
	        String shift1=request.getParameter("shift1");
	        String shift2=request.getParameter("shift2");
	        String shift3=request.getParameter("shift3");
	        String shift4=request.getParameter("shift4");
	        String frmhrtime1=request.getParameter("frmhrtime1");
	        String frmhrtime2=request.getParameter("frmhrtime2");
	        String frmhrtime3=request.getParameter("frmhrtime3");
	        String frmhrtime4=request.getParameter("frmhrtime4");
	        String frmmintime1=request.getParameter("frmmintime1");
	        String frmmintime2=request.getParameter("frmmintime2");
	        String frmmintime3=request.getParameter("frmmintime3");
	        String frmmintime4=request.getParameter("frmmintime4");
	        String frm_ampm1=request.getParameter("frm_ampm1");
	        String frm_ampm2=request.getParameter("frm_ampm2");
	        String frm_ampm3=request.getParameter("frm_ampm3");
	        String frm_ampm4=request.getParameter("frm_ampm4");
	        String tohrtime1=request.getParameter("tohrtime1");
	        String tohrtime2=request.getParameter("tohrtime2");
	        String tohrtime3=request.getParameter("tohrtime3");
	        String tohrtime4=request.getParameter("tohrtime4");
	        String tomintime1=request.getParameter("tomintime1");
	        String tomintime2=request.getParameter("tomintime2");
	        String tomintime3=request.getParameter("tomintime3");
	        String tomintime4=request.getParameter("tomintime4");
	        String to_ampm1=request.getParameter("to_ampm1");
	        String to_ampm2=request.getParameter("to_ampm2");
	        String to_ampm3=request.getParameter("to_ampm3");
	        String to_ampm4=request.getParameter("to_ampm4");
	        String brk_time1=request.getParameter("brk_time1");
	        String brk_time2=request.getParameter("brk_time2");
	        String brk_time3=request.getParameter("brk_time3");
	        String brk_time4=request.getParameter("brk_time4");
	            
	        selectedID=request.getParameter("thisFieldID");
	        
	        if(request.getParameter("Add_to_Machine_Master")!=null)
	        {
	        	
	        }
	}

}
