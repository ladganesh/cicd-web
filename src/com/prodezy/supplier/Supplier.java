	package com.prodezy.supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.customer.ContactDR;
import com.prodezy.supplier.*;

/**
 * Servlet implementation class Supllier
 */
@WebServlet("/Supplier")
public class Supplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		
		
		//System.out.println("do get call");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        SupplierMaster dao = new SupplierMaster();
        String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in planttable is "+errormessage+ " ");
        List<SupplierDr> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
      //  System.out.println("List Size "+list.size());
        
//        int noOfRecords = dao.getNoOfRecords();
      //  System.out.println("List Size "+list.size());
        int noOfRecords = dao.getNoOfRecords();
     //   System.out.println(noOfRecords);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      
        List<SupplierDr> list1=new ArrayList<SupplierDr>();

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
        System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
        System.out.println("index From "+indexFrom);
//
//        int counter=((page-1)*recordsPerPage)+recordsPerPage;
//        System.out.println("counter "+counter);
//        int indexFrom=(page-1)*recordsPerPage;
//        System.out.println("index From "+indexFrom);
        
        
    	List<ContactDR> list2=dao.contact((page - 1) * recordsPerPage, recordsPerPage);
		List<ContactDR> list3 = new ArrayList<ContactDR>();

        
        
       if(indexFrom<list.size()-recordsPerPage)
        {
        	
        	for(int i = indexFrom; i < counter; i++)
        	{
        		System.out.println("forLoop index no"+i);
        		list1.add(list.get(i));
        	}	
        }else {
        	
        	System.out.println((page-1)*recordsPerPage);
        	System.out.println(list.size());

        	for(int i = indexFrom; i < list.size(); i++)
        	{
        		//System.out.println("for loop else in plant "+i);
        		list1.add(list.get(i));
        	//	System.out.println("list1["+i+"]=  " +list.get(i));
        	}
       }

		//for contact_details
		if (indexFrom < list2.size() - recordsPerPage) {

			for (int i = indexFrom; i < counter; i++) {
				//System.out.println("forLoop index no" + i);
				list3.add(list2.get(i));
			}
		} else {

			System.out.println((page - 1) * recordsPerPage);
			System.out.println(list2.size());

			for (int i = indexFrom; i < list2.size(); i++) {
				//System.out.println("for loop else " + i);
				list3.add(list2.get(i));
			}
		}
		
       System.out.printf("errormessage in supplier do "+errormessage);
		request.setAttribute("contactlist", list3);

         request.setAttribute("supplierlist", list1);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("errormessage", errormessage);

        
        
        RequestDispatcher view = request.getRequestDispatcher("/Supplier.jsp");
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
