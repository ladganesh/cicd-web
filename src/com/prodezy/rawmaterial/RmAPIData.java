package com.prodezy.rawmaterial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import com.prodezy.machine.MachineDR;
//import com.prodezy.machine.MachineData;

@WebServlet("/RmAPIData")
public class RmAPIData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     */
    public RmAPIData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        RMspinnerData dao = new RMspinnerData();
        

		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in rawmaterial is "+errormessage+ " ");
		
      
        List<RawMaterialDr> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
        
        System.out.println("List Size "+list.size());
        int noOfRecords = dao.getNoOfRecords();
        System.out.println(noOfRecords);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      
        List<RawMaterialDr> list1=new ArrayList<RawMaterialDr>();

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
     //   System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
     //   System.out.println("index From "+indexFrom);
        

        	for(int i = 0; i < list.size(); i++)
        	{
        	//	System.out.println("forLoop index no"+i);
        		list1.add(list.get(i));
        	}			

        request.setAttribute("rawmaterialdata", list1);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/RawMaterial.jsp");
		//System.out.println("do get call");
        request.setAttribute("errormessage", errormessage);

        view.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
