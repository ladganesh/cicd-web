package com.prodezy.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

import com.prodezy.machine.MachineDR;
import com.prodezy.machine.MachineData;
*/
/**
 * Servlet implementation class CustomerTable
 */
@WebServlet("/CustomerTable")
public class CustomerTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in planttable is "+errormessage+ " ");
		
		int page = 1;
		int recordsPerPage = 5;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		CustomerData dao = new CustomerData();

		List<customerDR> list = dao.tablelist((page - 1) * recordsPerPage, recordsPerPage);
		
		System.out.println("List Size " + list.size());
		
		
		
		int noOfRecords = dao.getNoOfRecords();
		System.out.println(noOfRecords);
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		

		List<customerDR> list1 = new ArrayList<customerDR>();
		List<ContactDR> list2=dao.contact((page - 1) * recordsPerPage, recordsPerPage);
		List<ContactDR> list3 = new ArrayList<ContactDR>();


		int counter = ((page - 1) * recordsPerPage) + recordsPerPage;
		System.out.println("counter " + counter);
		int indexFrom = (page - 1) * recordsPerPage;
		System.out.println("index From " + indexFrom);

		if (indexFrom < list.size() - recordsPerPage) {

			for (int i = indexFrom; i < counter; i++) {
				System.out.println("forLoop index no" + i);
				list1.add(list.get(i));
			}
		} else {

			System.out.println((page - 1) * recordsPerPage);
			System.out.println(list.size());

			for (int i = indexFrom; i < list.size(); i++) {
				System.out.println("for loop else " + i);
				list1.add(list.get(i));
			}
		}
		
		
		//for contact_details
		if (indexFrom < list2.size() - recordsPerPage) {

			for (int i = indexFrom; i < counter; i++) {
				System.out.println("forLoop index no" + i);
				list3.add(list2.get(i));
			}
		} else {

			System.out.println((page - 1) * recordsPerPage);
			System.out.println(list2.size());

			for (int i = indexFrom; i < list2.size(); i++) {
				System.out.println("for loop else " + i);
				list3.add(list2.get(i));
			}
		}
		
		

		request.setAttribute("customerList", list1);
		request.setAttribute("contactlist", list3);

		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
        request.setAttribute("errormessage", errormessage);

		RequestDispatcher view = request.getRequestDispatcher("/Customer.jsp");
		System.out.println("do get call");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
