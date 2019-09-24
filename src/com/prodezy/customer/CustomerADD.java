package com.prodezy.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

@WebServlet("/CustomerADD")
public class CustomerADD extends HttpServlet {

	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    
		 RequestDispatcher rd;
		 	//String selectedID="";
	        String name1=request.getParameter("name1");
	        String addr=request.getParameter("addr");
	        String city=request.getParameter("city");
	        String cust_code=request.getParameter("cust_code");
	        String plant_code=request.getParameter("plant_code");
	        String contll=request.getParameter("contll");
	        String contboard=request.getParameter("contboard");
	        String weeklyoff=request.getParameter("weeklyoff");
	        String gstno=request.getParameter("gstno");
	        String vender_code=request.getParameter("vender_code");
	        String credit_period=request.getParameter("credit_period");
	        
	        
	        String selectedID=request.getParameter("id");
	        
	    	String value=request.getParameter("Add_to_Master");
	    	String addEmpAPICall="",result="",message="";
	        System.out.println("value of button is = "+value);
			if(!(name1=="" || addr=="" ||gstno==""|| city=="" || cust_code=="" || plant_code=="" || contll==""||contboard=="" )) {
					if(value.contentEquals("Add_to_Master")) 
						{
						addEmpAPICall = "customeradd?CUSTOMER_NAME="+URLEncoder.encode(name1, "UTF-8")+"&CUST_ADDRESS="+URLEncoder.encode(addr, "UTF-8")
                           +"&CONTACT_LL="+URLEncoder.encode(contll , "UTF-8")+"&CONTACT_BRD="+URLEncoder.encode(contboard, "UTF-8")
                           +"&WEEKLY_OFF="+URLEncoder.encode( weeklyoff, "UTF-8")+"&GST_NO="+URLEncoder.encode( gstno, "UTF-8")
                           +"&OUR_VENDOR_CODE="+URLEncoder.encode( vender_code, "UTF-8")+"&PAYMENT_TERMS="+URLEncoder.encode( credit_period, "UTF-8")
                           +"&CITY="+URLEncoder.encode( city, "UTF-8")+"&SEGMENT=&INDUSTRY=&CATEGORY=&CREATED_ON="+URLEncoder.encode( "", "UTF-8")
                           +"&EDITED_ON="+URLEncoder.encode( "", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("harshal", "UTF-8")
                           +"&PLANT_CODE="+plant_code+"&CUST_CODE="+cust_code;
//                     
							result= WebAPITester.prepareWebCall ( addEmpAPICall);
					        message="Your record is successfully save..";
					        System.out.printf("\n value of result "+result);	
					        request.setAttribute("errorMessage",message );
							 rd =request.getRequestDispatcher("/customer.do");
							 rd.forward(request, response);	
						}
						
					else if(value.contentEquals("Edit_record"))
						{
							
							addEmpAPICall = "customerupdate?CUSTOMER_ID="+URLEncoder.encode(selectedID, "UTF-8")+"&CUSTOMER_NAME="+URLEncoder.encode(name1, "UTF-8")+"&CUST_ADDRESS="+URLEncoder.encode(addr, "UTF-8")
	                           +"&CONTACT_LL="+URLEncoder.encode(contll , "UTF-8")+"&CONTACT_BRD="+URLEncoder.encode(contboard, "UTF-8")
	                           +"&WEEKLY_OFF="+URLEncoder.encode( weeklyoff, "UTF-8")+"&GST_NO="+URLEncoder.encode( gstno, "UTF-8")
	                           +"&OUR_VENDOR_CODE="+URLEncoder.encode( vender_code, "UTF-8")+"&PAYMENT_TERMS="+URLEncoder.encode( credit_period, "UTF-8")
	                           +"&CITY="+URLEncoder.encode( city, "UTF-8")+"&SEGMENT=&INDUSTRY=&CATEGORY=&CREATED_ON="+URLEncoder.encode( "", "UTF-8")
	                           +"&EDITED_ON="+URLEncoder.encode( "", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("harshal", "UTF-8")
	                           +"&PLANT_CODE="+plant_code+"&CUST_CODE="+cust_code;
//	                     
							 result= WebAPITester.prepareWebCall ( addEmpAPICall);
					        message="Your record is successfully updated..";
					        System.out.printf("\n value of result "+result);	
					        request.setAttribute("errorMessage",message );
							 rd =request.getRequestDispatcher("/customer.do");
							 rd.forward(request, response);		
							 }
						else
						{/*
							 String message="Your record is not save..Please try later";
							 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
					        message="Please fill all Fields!!";
					       // System.out.println("else part of validation");
							 request.setAttribute("errorMessage",message );
							 rd =request.getRequestDispatcher("/customer.do");
							 rd.forward(request, response);
						}
			}
			else
			{/*
				 String message="Your record is not save..Please try later";
				 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
		         message="Please fill all Fields!!";
		       // System.out.println("else part of validation");
				 request.setAttribute("errorMessage",message );
				 rd =request.getRequestDispatcher("/customer.do");
				 rd.forward(request, response);

			}
	 }
}
			
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        /*
	        //HttpSession session = request.getSession(false);
	        PrintWriter out = response.getWriter();

	        if(request.getParameter("Add_to_customer_Master")!=null)
	        {
	            if( !name1.equalsIgnoreCase ( "")   &&  !plant_code.equalsIgnoreCase ( "" ) &&   !cust_code.equalsIgnoreCase ( "" )   ){

//	                result = DB_Operations.insertIntoCustomerMaster(CUSTOMER_NAME, CUST_ADDRESS, CONTACT_LL, CONTACT_BRD, WEEKLY_OFF, GST_NO, OUR_VENDOR_CODE, PAYMENT_TERMS, CITY, "null", CREATED_ON, EDITED_ON, EDITED_BY);
	                //changes starts

	            	System.out.println(" Successfully inserted customer details ! ");	                
	                
	                 try{
	                    
	                     String addEmpAPICall = "" ;
	                     
//	                     if( ! jComboBox3.getSelectedItem().toString ().equals( "Select Existing Customer" )   )   {
//	                        
//	                            addEmpAPICall = "customeradd?CUSTOMER_NAME="+URLEncoder.encode(CUSTOMER_NAME, "UTF-8")+"&CUST_ADDRESS="+URLEncoder.encode(CUST_ADDRESS, "UTF-8")
//	                            +"&CONTACT_LL="+URLEncoder.encode(CONTACT_LL , "UTF-8")+"&CONTACT_BRD="+URLEncoder.encode(CONTACT_BRD, "UTF-8")
//	                            +"&WEEKLY_OFF="+URLEncoder.encode( WEEKLY_OFF, "UTF-8")+"&GST_NO="+URLEncoder.encode( GST_NO, "UTF-8")
//	                            +"&OUR_VENDOR_CODE="+URLEncoder.encode( OUR_VENDOR_CODE, "UTF-8")+"&PAYMENT_TERMS="+URLEncoder.encode( PAYMENT_TERMS, "UTF-8")
//	                            +"&CITY="+URLEncoder.encode( CITY, "UTF-8")+"&SEGMENT=&INDUSTRY=&CATEGORY=&CREATED_ON="+URLEncoder.encode( CREATED_ON, "UTF-8")
//	                            +"&EDITED_ON="+URLEncoder.encode( EDITED_ON, "UTF-8")+"&EDITED_BY="+URLEncoder.encode(EDITED_BY, "UTF-8")
//	                            +"&PLANT_CODE="+PLANT_CODE+"&CUST_CODE="+CUST_CODE;
//	                         
//	                        
//	                            
//	                     }else{
	                         
	                            addEmpAPICall = "customeradd?CUSTOMER_NAME="+URLEncoder.encode(name1, "UTF-8")+"&CUST_ADDRESS="+URLEncoder.encode(addr, "UTF-8")
	                            +"&CONTACT_LL="+URLEncoder.encode(contll , "UTF-8")+"&CONTACT_BRD="+URLEncoder.encode(contboard, "UTF-8")
	                            +"&WEEKLY_OFF="+URLEncoder.encode( weeklyoff, "UTF-8")+"&GST_NO="+URLEncoder.encode( gstno, "UTF-8")
	                            +"&OUR_VENDOR_CODE="+URLEncoder.encode( vender_code, "UTF-8")+"&PAYMENT_TERMS="+URLEncoder.encode( credit_period, "UTF-8")
	                            +"&CITY="+URLEncoder.encode( city, "UTF-8")+"&SEGMENT=&INDUSTRY=&CATEGORY=&CREATED_ON="+URLEncoder.encode( "", "UTF-8")
	                            +"&EDITED_ON="+URLEncoder.encode( "", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("mayur", "UTF-8")
	                            +"&PLANT_CODE="+plant_code+"&CUST_CODE="+cust_code;
	                         
	                            
	                     //}
	                     
	                     
	                            
	                    String result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
	                    if(result2.contains("success"))
	    	            {
	    	         	   String message="Your record is successfully saved..";
	    	         	   response.sendRedirect("Customer.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	    	            }
	    	            else
	    	            {
	    	         	   String message="Your record is not saved..Please try later";
	    	         	   response.sendRedirect("Customer.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	    	            }
	                    result = iDFromJSON( result2 );    
	                    
	                }catch(UnsupportedEncodingException e){
	                    
	                }
	                
	                String ContactPerson1_NAME = request.getParameter("person1");
	                String ContactPerson1_CONTACT_NO = request.getParameter("contact1");
	                String ContactPerson1_EMAIL = request.getParameter("email1");

	                if (!ContactPerson1_NAME.equals("") || !ContactPerson1_CONTACT_NO.equals("") || !ContactPerson1_EMAIL.equals("")) {

	                    String CONT_EMAIL, CONT_NO, CONT_NAME;

	                    CONT_EMAIL = ContactPerson1_EMAIL;
	                    CONT_NO = ContactPerson1_CONTACT_NO;
	                    CONT_NAME = ContactPerson1_NAME;

	                    if (result != 0) {

	                        int supp_id = 0;
	                        
	                        
//	                        success = DB_Operations.insertIntoContactMaster(CONT_EMAIL, CONT_NO, result, 0, CONT_NAME, CREATED_ON, EDITED_ON, EDITED_BY);
	                         try{
	                            String addContactPersonCall = "contactadd?CONT_EMAIL="+URLEncoder.encode(ContactPerson1_EMAIL, "UTF-8")+"&CONT_NO="+URLEncoder.encode(CONT_NO, "UTF-8")+"&CUST_ID="+URLEncoder.encode(result+"", "UTF-8")+"&SUPP_ID="+URLEncoder.encode(supp_id+"", "UTF-8")+"&CONT_NAME="+URLEncoder.encode(CONT_NAME,"UTF-8")+"&CREATED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("", "UTF-8");
	                            String result2 =  WebAPITester.prepareWebCall ( addContactPersonCall);
	                            
	                        }catch(UnsupportedEncodingException  ex){
	                            
	                        }
	                        
	                        
	                        ContactPerson1_NAME = request.getParameter("person2");
	                        ContactPerson1_CONTACT_NO = request.getParameter("contact2");
	                        ContactPerson1_EMAIL = request.getParameter("email1");
	                        
	                        if (!ContactPerson1_NAME.equals("") || !ContactPerson1_CONTACT_NO.equals("") || !ContactPerson1_EMAIL.equals("")) {
//	                            success = DB_Operations.insertIntoContactMaster(ContactPerson1_EMAIL, ContactPerson1_CONTACT_NO, result, 0, ContactPerson1_NAME, CREATED_ON, EDITED_ON, EDITED_BY);

	                            try{
	                                String addContactPersonCall = "contactadd?CONT_EMAIL="+URLEncoder.encode(ContactPerson1_EMAIL, "UTF-8")+"&CONT_NO="+URLEncoder.encode(CONT_NO, "UTF-8")+"&CUST_ID="+URLEncoder.encode(result+"", "UTF-8")+"&SUPP_ID="+URLEncoder.encode(supp_id+"", "UTF-8")+"&CONT_NAME="+URLEncoder.encode(CONT_NAME,"UTF-8")+"&CREATED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("", "UTF-8");
	                                String result2 =  WebAPITester.prepareWebCall ( addContactPersonCall);
	                                
	                            }catch(UnsupportedEncodingException  ex){

	                            }
	                        }
	                        
	                        
	                        
	                        ContactPerson1_NAME = request.getParameter("person3");
	    	                ContactPerson1_CONTACT_NO = request.getParameter("contact3");
	    	                ContactPerson1_EMAIL = request.getParameter("email3");
	                        
	                        if (!ContactPerson1_NAME.equals("") || !ContactPerson1_CONTACT_NO.equals("") || !ContactPerson1_EMAIL.equals("")) {
//	                            success = DB_Operations.insertIntoContactMaster(ContactPerson1_EMAIL, ContactPerson1_CONTACT_NO, result, 0, ContactPerson1_NAME, CREATED_ON, EDITED_ON, EDITED_BY);
	                        
	                            try{
	                                String addContactPersonCall = "contactadd?CONT_EMAIL="+URLEncoder.encode(ContactPerson1_EMAIL, "UTF-8")+"&CONT_NO="+URLEncoder.encode(CONT_NO, "UTF-8")+"&CUST_ID="+URLEncoder.encode(result+"", "UTF-8")+"&SUPP_ID="+URLEncoder.encode(supp_id+"", "UTF-8")+"&CONT_NAME="+URLEncoder.encode(CONT_NAME,"UTF-8")+"&CREATED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_ON="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("", "UTF-8");
	                                String result2 =  WebAPITester.prepareWebCall ( addContactPersonCall);
	                               
	                            }catch(UnsupportedEncodingException  ex){

	                            }
	                        }
	                    }
	                } else {

	                }
	                

	            
	            //JOptionPane.showMessageDialog(null, "Machine added successfuly");

	        }else{
	            //JOptionPane.showMessageDialog(null, "Please fill mandatory fields marked with * " );
	            response.sendRedirect("Customer.jsp");
	        }
	        }
	        else if(request.getParameter("Edit_record")!=null)
	        {
	        	System.out.println("edit_record button click");
	        	if(!selectedID.isEmpty())
	        	{
	        		
	        		String addEmpAPICall = "customerupdate?CUSTOMER_ID="+selectedID+"&CUSTOMER_NAME="+URLEncoder.encode(name1, "UTF-8")
                    +"&CUST_ADDRESS="+URLEncoder.encode(addr, "UTF-8")+"&CONTACT_LL="+URLEncoder.encode(contll , "UTF-8")
                    +"&CONTACT_BRD="+URLEncoder.encode(contboard, "UTF-8")+"&WEEKLY_OFF="+URLEncoder.encode( weeklyoff, "UTF-8")
                    +"&GST_NO="+URLEncoder.encode( gstno, "UTF-8")+"&OUR_VENDOR_CODE="+URLEncoder.encode( vender_code, "UTF-8")
                    +"&PAYMENT_TERMS="+URLEncoder.encode( credit_period, "UTF-8")+"&CITY="+URLEncoder.encode( city, "UTF-8")
                    +"&SEGMENT=&INDUSTRY=&CATEGORY=&CREATED_ON=&EDITED_ON=&EDITED_BY="
                     +"&PLANT_CODE="+plant_code+"&CUST_CODE="+cust_code;  
	            String result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
	            System.out.print(result2);
	            
	            if(result2.contains("success"))
	            {
	         	   String message1="Your record is successfully updated..";
	         	   response.sendRedirect("Customer.jsp?message=" + URLEncoder.encode(message1, "UTF-8"));

	            }
	            else
	            {
	         	   String message1="Your record is not update..Please try later";
	         	   response.sendRedirect("Customer.jsp?message=" + URLEncoder.encode(message1, "UTF-8"));
	            }
	        	}
	        	//response.sendRedirect("Machines.jsp");
	        }
	       
	        
	        else
	        {
	        	System.out.println("cant be submit button click");
	        	
	        	
	        	response.sendRedirect("Customer.jsp");
	        }
	        


	    }
	 	public int iDFromJSON ( String json ) {
	        int id = 0;

	        JSONObject jObject = new JSONObject ( json );
	        Iterator<?> keys = jObject.keys ();

	        JSONObject value = ( JSONObject ) jObject.get ( "data" );

	        id = Integer.parseInt ( value.get ( "insert_id" ).toString () );
	        //    id = Integer.parseInt( st.getString ("insert_id" ));

	        return id;
	    }*/

