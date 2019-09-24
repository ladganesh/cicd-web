package com.prodezy.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodezy.rawmaterial.RMspinnerData;
import com.prodezy.rawmaterial.RawMaterialDr;

/**
 * Servlet implementation class EmpTable
 */
@WebServlet("/EmpTable")
public class EmpTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in employee is "+errormessage+ " ");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
        page = Integer.parseInt(request.getParameter("page"));
        
        

		
        
        employeeSpinnerData dao = new employeeSpinnerData();
      
        List<EmployeeDR> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
        
//        System.out.println("List Size "+list.size());
        int noOfRecords = dao.getNoOfRecords();
//        System.out.println(noOfRecords);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      
        List<EmployeeDR> list1=new ArrayList<EmployeeDR>();

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
//        System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;
//        System.out.println("index From "+indexFrom);
        

        if(indexFrom<list.size()-recordsPerPage)
         {
         	
         	for(int i = indexFrom; i < counter; i++)
         	{
         	//	System.out.println("forLoop index no"+i);
         		list1.add(list.get(i));
         	}	
         }else {
         	
//         	System.out.println((page-1)*recordsPerPage);
//         	System.out.println(list.size());

         	for(int i = indexFrom; i < list.size(); i++)
         	{
         		//System.out.println("for loop else in plant "+i);
         		list1.add(list.get(i));
//         		System.out.println("list1["+i+"]=  " +list.get(i));
         	}
        }
         
            System.out.printf("errormessage in employee do "+errormessage);

        request.setAttribute("Emplist", list1);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("errormessage", errormessage);

        RequestDispatcher view = request.getRequestDispatcher("/Employee.jsp");
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
