package com.prodezy.diemaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.plantmaster.PlantDR;
import com.prodezy.plantmaster.PlantData;
import com.prodezy.plantmaster.ShiftDR;

/**
 * Servlet implementation class Dietable
 */
@WebServlet("/Dietable")
public class Dietable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dietable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		
		
		
		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in planttable is "+errormessage+ " ");
		
		//System.out.println("do get call");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        DieMaster dao = new DieMaster();
      
        List<DieDR> list = dao.list((page-1)*recordsPerPage, recordsPerPage);

      //  System.out.println("List Size "+list.size());
        
//        int noOfRecords = dao.getNoOfRecords();
      //  System.out.println("List Size "+list.size());
        int noOfRecords = dao.getNoOfRecords();
     //   System.out.println(noOfRecords);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      
        List<DieDR> list1=new ArrayList<DieDR>();
        
        int counter=((page-1)*recordsPerPage)+recordsPerPage;
     //   System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
 
       if(indexFrom<list.size()-recordsPerPage)
        {
        	
        	for(int i = indexFrom; i < counter; i++)
        	{
        	//	System.out.println("forLoop index no"+i);
        		list1.add(list.get(i));
        	}	
        }else {
        	
//        	System.out.println((page-1)*recordsPerPage);
//        	System.out.println(list.size());

        	for(int i = indexFrom; i < list.size(); i++)
        	{
        		//System.out.println("for loop else in plant "+i);
        		list1.add(list.get(i));
//        		System.out.println("list1["+i+"]=  " +list.get(i));
        	}
       }
       
       
    
        
       System.out.printf("errormessage in die do "+errormessage);
         request.setAttribute("dielist", list1);

        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("errormessage", errormessage);

        
        
        RequestDispatcher view = request.getRequestDispatcher("/DieMaster.jsp");
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
