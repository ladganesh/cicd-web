package com.prodezy.machine;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

/**
 * Servlet implementation class Machines
 */
public class Machines extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Machines() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		listMachine(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		int machineid = Integer.parseInt(request.getParameter("mc_type"));
//        
//        request.setAttribute("selectedMCId", machineid);
//        listMachine(request, response);
	}
	public void listMachine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        MachineTypeload machine;
        machine = new MachineTypeload();
        
        try{
//            System.err.println("list machine start");
//            
//            List<MachineDR> listMachine = machine.list();
//            request.setAttribute("listMachine", listMachine);
//            
//            System.err.println("list machine mid");
//            
//            RequestDispatcher dispatcher = request.getRequestDispatcher("Machine.jsp");
//            dispatcher.forward(request, response);
//            
//            System.err.println("list machine end");
 
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
    }
}
