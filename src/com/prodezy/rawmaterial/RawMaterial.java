package com.prodezy.rawmaterial;

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
 * Servlet implementation class RawMaterial
 */
@WebServlet("/RawMaterial")
public class RawMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RawMaterial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
        String RM_ID="",RM_CTG="", RM_NAME,RM_RATE,REORDER_LEVEL, RMM_UOM_ID,RM_CODE="",Length,Width,Thickness,Density, RM_EC_NO,RM_CAS_NO, GST_NO,RM_CRIT;
       
        RM_ID=request.getParameter("id");
        RM_CODE=request.getParameter("rmcode");
        RM_CTG=request.getParameter("type");
        RM_NAME=request.getParameter("rmname");
        RM_RATE=request.getParameter("rpu");
        REORDER_LEVEL=request.getParameter("reorderlevel");
       // RMM_UOM_ID=request.getParameter("measurement");1
        Length=request.getParameter("length");
        Width=request.getParameter("width");
        Thickness=request.getParameter("thickness");
        Density=request.getParameter("density");
        System.out.println("testing="+RM_ID+RM_CODE+RM_CTG+RM_NAME+RM_RATE+REORDER_LEVEL+Length+Width+Thickness+Density);

//        RM_EC_NO=request.getParameter("rmcode");
//        RM_CAS_NO=request.getParameter("rmcode");
//        GST_NO=request.getParameter("rmcode");
//        RM_CRIT=request.getParameter("rmcode");
        String value=request.getParameter("Add_to_Master");
		System.out.println("value of button is = "+value);
		if(!(RM_CODE=="" || RM_CTG=="" ||RM_NAME==""|| RM_RATE=="" || REORDER_LEVEL==""  ||  Length==""||Width==""  || Thickness=="" ||Density=="")) {
				if(value.contains("Add_to_Master")) 
					{
					System.out.println("add data into raw material");
					String apinamecall="rawmaterialadd?RM_CODE="+URLEncoder.encode(RM_CODE, "UTF-8")+"&RM_CTG="+URLEncoder.encode(RM_CTG, "UTF-8")+"&RM_NAME="+URLEncoder.encode(RM_NAME, "UTF-8")+"&RM_RATE="+URLEncoder.encode(RM_RATE, "UTF-8")+"&REORDER_LEVEL="+URLEncoder.encode(REORDER_LEVEL, "UTF-8")+
							"&length="+URLEncoder.encode(Length, "UTF-8")+"&width="+URLEncoder.encode(Width, "UTF-8")+"&thickness="+URLEncoder.encode(Thickness, "UTF-8")+"&density="+URLEncoder.encode(Density, "UTF-8");
							//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
					System.out.println("api call for raw material"+apinamecall);
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully save..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/RmAPIData.do");
						 rd.forward(request, response);	
					}
					
				else if(value.contains("Edit_Record"))
					{
						
					String apinamecall="rawmaterialsupdate?RM_ID="+URLEncoder.encode(RM_ID, "UTF-8")+"&RM_CODE="+URLEncoder.encode(RM_CODE, "UTF-8")+"&RM_CTG="+URLEncoder.encode(RM_CTG, "UTF-8")+"&RM_NAME="+URLEncoder.encode(RM_NAME, "UTF-8")+"&RM_RATE="+URLEncoder.encode(RM_RATE, "UTF-8")+"&REORDER_LEVEL="+URLEncoder.encode(REORDER_LEVEL, "UTF-8")+
							"&length="+URLEncoder.encode(Length, "UTF-8")+"&width="+URLEncoder.encode(Width, "UTF-8")+"&thickness="+URLEncoder.encode(Thickness, "UTF-8")+"&density="+URLEncoder.encode(Density, "UTF-8");
				//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
						String result= WebAPITester.prepareWebCall ( apinamecall);
				        String message="Your record is successfully updated..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/RmAPIData.do");
						 rd.forward(request, response);		
						 }
					else
					{/*
						 String message="Your record is not save..Please try later";
						 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
				        String message="Please fill all Fields!!";
				       // System.out.println("else part of validation");
						 request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/RmAPIData.do");
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
			 rd =request.getRequestDispatcher("/RmAPIData.do");
			 rd.forward(request, response);
		}
		

		
		
	}

}
