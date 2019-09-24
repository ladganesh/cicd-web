package com.prodezy.product_customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webcall.SpinnerList;

/**
 * Servlet implementation class ProductCustomer
 */
@WebServlet("/ProductCustomer")
public class ProductCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		String message=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in planttable is "+message+ " ");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
      //  SpinnerList dao = new SpinnerList().getProduct_customer();
      
        ArrayList<ProductDr> list = new SpinnerList().getProduct_customer();
        
        System.out.println("\nproduct customer List Size "+list.size());
    //    System.out.println(noOfRecords);
      
        ArrayList<ProductDr> list1=new ArrayList<ProductDr>();

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
        System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
        System.out.println("index From "+indexFrom);
        
//        if(indexFrom<list.size()-recordsPerPage)
//        {
        	
        	for(int i = 0; i < list.size(); i++)
        	{
        //		System.out.println("forLoop index no"+i);
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
   		 request.setAttribute("errorMessage",message);
        request.setAttribute("product_customer_list", list);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/product_customer_map.jsp");
		System.out.println("do get call");
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
