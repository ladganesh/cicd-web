package com.prodezy.machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class MachineTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineTable() {
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
        MachineData dao = new MachineData();
      
        List<MachineDR> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
        
        System.out.println("List Size "+list.size());
        int noOfRecords = dao.getNoOfRecords();
        System.out.println(noOfRecords);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      
        List<MachineDR> list1=new ArrayList<MachineDR>();

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
        System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
        System.out.println("index From "+indexFrom);
        
//        if(indexFrom<list.size()-recordsPerPage)
//        {
        	
        	for(int i = 0; i < list.size(); i++)
        	{
        		System.out.println("forLoop index no"+i);
        		list1.add(list.get(i));
        	}	
//        }else {
//        	
//        	System.out.println((page-1)*recordsPerPage);
//        	System.out.println(list.size());
//
//        	for(int i = indexFrom; i < list.size(); i++)
//        	{
//        		System.out.println("for loop else "+i);
//        		list1.add(list.get(i));
//        	}
//        }
        
        request.setAttribute("machineList", list1);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/Machines.jsp");
		System.out.println("do get call");
        view.forward(request, response);
	}

}
