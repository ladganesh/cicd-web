package com.prodezy.finishedgoods;

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
 * Servlet implementation class FinishedgoodsAdd
 */
@WebServlet("/FinishedgoodsAdd")
public class FinishedgoodsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishedgoodsAdd() {
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
		String fgid,fgpartuniqueid,fgpartno,partname,salesrate,ntweight,grsweight,notes,prdcost,fguomid;
		fgid=request.getParameter("id");
		fgpartuniqueid=request.getParameter("partid");
		fgpartno=request.getParameter("partcode");
		partname=request.getParameter("partname");
		//salesrate=request.getParameter("id");
		ntweight=request.getParameter("netweight");
		grsweight=request.getParameter("grossweight");
		notes=request.getParameter("productnote");
		prdcost=request.getParameter("productioncost");
		//fguomid=request.getParameter("id");
		
		
        System.out.println("testing="+fgid+"and"+fgpartuniqueid+"and"+fgpartno+"and"+partname+"and"+ntweight+"and"+grsweight+"and"+notes+"and"+prdcost);

		String value=request.getParameter("Add_to_Master");
		if(!(fgpartuniqueid=="" || fgpartno=="" ||partname==""|| ntweight=="" || grsweight=="" || notes=="" || prdcost=="")) {
			if(value.contentEquals("Add_to_Master")) 
				{
					
					String apinamecall="finishedgoodsadd?FG_PART_UNIQUE_ID="+URLEncoder.encode(fgpartuniqueid, "UTF-8")+"&FG_PART_NO="+URLEncoder.encode(fgpartno, "UTF-8")+"&PART_NAME="+URLEncoder.encode(partname, "UTF-8")+"&NT_WGHT="+URLEncoder.encode(ntweight, "UTF-8")+"&GRS_WGHT="+URLEncoder.encode(grsweight, "UTF-8")+
							"&NOTES="+URLEncoder.encode(notes, "UTF-8")+"&PROD_COST="+URLEncoder.encode(prdcost, "UTF-8");
					//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
					String result= WebAPITester.prepareWebCall ( apinamecall);
			        String message="Your record is successfully save..";
			        System.out.printf("\n value of result "+result);	
			        request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/finish.do");
					 rd.forward(request, response);	
					 
									 
				}
				
			else if(value.contentEquals("Edit_record"))
				{
					
				String apinamecall="finishedgoodsupdate?FG_ID="+URLEncoder.encode(fgid, "UTF-8")+"&FG_PART_UNIQUE_ID="+URLEncoder.encode(fgpartuniqueid, "UTF-8")+"&FG_PART_NO="+URLEncoder.encode(fgpartno, "UTF-8")+"&PART_NAME="+URLEncoder.encode(partname, "UTF-8")+"&NT_WGHT="+URLEncoder.encode(ntweight, "UTF-8")+"&GRS_WGHT="+URLEncoder.encode(grsweight, "UTF-8")+
						"&NOTES="+URLEncoder.encode(notes, "UTF-8")+"&PROD_COST="+URLEncoder.encode(prdcost, "UTF-8");
					String result= WebAPITester.prepareWebCall ( apinamecall);
			        String message="Your record is successfully updated..";
			        System.out.printf("\n value of result "+result);	
			        request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/finish.do");
					 rd.forward(request, response);		
					 }
				else
				{/*
					 String message="Your record is not save..Please try later";
					 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
			        String message="Please fill all Fields!!";
			       // System.out.println("else part of validation");
					 request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/finish.do");
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
		 rd =request.getRequestDispatcher("/finish.do");
		 rd.forward(request, response);
	}
	
	
    
		
		
		
		
		
		

		
		
		
		
		
		
	}

}
