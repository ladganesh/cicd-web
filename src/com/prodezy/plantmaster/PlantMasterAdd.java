package com.prodezy.plantmaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.io.File;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

/**
 * Servlet implementation class PlantMasterAdd
 */
@WebServlet("/PlantMasterAdd")
public class PlantMasterAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int newRecordForAPI = 0 ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantMasterAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//PrintWriter out = response.getWriter(); 
		
		RequestDispatcher rd;
		String plantid,plantname,plantcode,gstno,plantaddress,plantweekoff,plantcpname,plantcpno,
		plantcpemail,companyname,complogo,plantcontactno,plantemail;
		   String shiftid1=request.getParameter("shiftid1");
		   String shiftid2=request.getParameter("shiftid2");
		   String shiftid3=request.getParameter("shiftid3");
		   String shiftid4=request.getParameter("shiftid4");

		   String shift1=request.getParameter("shift1");
	        String shift2=request.getParameter("shift2");
	        String shift3=request.getParameter("shift3");
	        String shift4=request.getParameter("shift4");
	        String frmhrtime1=request.getParameter("frmhrtime1");
	        String frmhrtime2=request.getParameter("frmhrtime2");
	        String frmhrtime3=request.getParameter("frmhrtime3");		
	        String frmhrtime4=request.getParameter("frmhrtime4");
	        String frm_ampm1=request.getParameter("frm_ampm1");
	        String frm_ampm2=request.getParameter("frm_ampm2");
	        String frm_ampm3=request.getParameter("frm_ampm3");
	        String frm_ampm4=request.getParameter("frm_ampm4");
	        String tohrtime1=request.getParameter("tohrtime1");
	        String tohrtime2=request.getParameter("tohrtime2");
	        String tohrtime3=request.getParameter("tohrtime3");
	        String tohrtime4=request.getParameter("tohrtime4");
	        String brk_time1=request.getParameter("brk_time1");
	        String brk_time2=request.getParameter("brk_time2");
	        String brk_time3=request.getParameter("brk_time3");
	        String brk_time4=request.getParameter("brk_time4");
	            
	    
		plantid=request.getParameter("plt_id");
		plantname=request.getParameter("plt_name");
		plantcode=request.getParameter("plant_code");
		gstno=request.getParameter("gst_no");
		plantaddress=request.getParameter("plt_addr");
		plantweekoff=request.getParameter("weekly_off");
		plantcpname=request.getParameter("cont_person_nm");
		plantcpno=request.getParameter("cont_no");
		plantcpemail=request.getParameter("email_addr");
		companyname=request.getParameter("company_name");
		//complogo=request.getParameter();
		plantcontactno=request.getParameter("plt_cont_no");
		plantemail=request.getParameter("plt_email_addr");
		String value=request.getParameter("Add_to_Plant_Master");
		System.out.println("value of button is = "+value);
		if(!(plantname=="" || plantcode=="" ||gstno==""|| plantaddress=="" || plantweekoff=="" || plantcpname=="" || plantcpno==""||plantcontactno==""  || plantemail=="")) {
				if(value.contentEquals("Add_to_Plant_Master")) 
					{
						
						String apinamecall="plantadd?plantname="+URLEncoder.encode(plantname, "UTF-8")+"&plantcode="+URLEncoder.encode(plantcode, "UTF-8")+"&gstno="+URLEncoder.encode(gstno, "UTF-8")+"&plantmailaddress="+URLEncoder.encode(plantemail, "UTF-8")+"&plantweekoff="+URLEncoder.encode(plantweekoff, "UTF-8")+
								"&plantcpname="+URLEncoder.encode(plantcpname, "UTF-8")+"&plantcpno="+URLEncoder.encode(plantcpno, "UTF-8")+"&plantcpemail="+URLEncoder.encode(plantcpemail, "UTF-8")+"&companyname="+URLEncoder.encode(companyname, "UTF-8")+"&plantcontactno="+URLEncoder.encode(plantcontactno, "UTF-8");
//						String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
						String result= WebAPITester.prepareWebCall ( apinamecall);
						 newRecordForAPI = iDFromJSON ( result ) ;
					     System.out.printf("\n value of newRecordForAPI "+newRecordForAPI+"\n");	
					      
//putting shift data in arraylist
					      
					      ArrayList<String[]> shifts = new ArrayList<String[]> ();
                          
                          if(!shift1.equals(""))
                          {
                          	frmhrtime1= "0000-00-00 "+frmhrtime1+":00";
                          	tohrtime1= "0000-00-00 "+tohrtime1+":00";
                          	
                          	shifts.add ( new String[] { shift1 , frmhrtime1 , tohrtime1 , brk_time1 } );
                          }
                          if(!shift2.equals(""))
                          {
                          	frmhrtime2= "0000-00-00 "+frmhrtime2+":00";
                          	tohrtime2= "0000-00-00 "+tohrtime2+":00";
                          	
                          	shifts.add ( new String[] { shift2 , frmhrtime2 , tohrtime2 , brk_time2 } );
                          }
                          if(!shift3.equals(""))
                          {
                          	frmhrtime3= "0000-00-00 "+frmhrtime3+":00";
                          	tohrtime3= "0000-00-00 "+tohrtime3+":00";
                          	
                          	shifts.add ( new String[] { shift3 , frmhrtime3 , tohrtime3 , brk_time3 } );
                          }
                          if(!shift4.equals(""))
                          {
                          	frmhrtime4= "0000-00-00 "+frmhrtime4+":00";
                          	tohrtime4= "0000-00-00 "+tohrtime4+":00";
                          	
                          	shifts.add ( new String[] { shift4 , frmhrtime4 , tohrtime4 , brk_time4 } );
                          }
                          else
                          {
                          	System.out.println("shift data no available");
                          }
                         	System.out.println("\nshift data is reading \n ");

                          for ( int i = 0 ; i < shifts.size () ; i ++ ) {	                              

                              try {
                            	  
                            	  //calling shiftadd api
                            	  
                                  String addEmpAPICall1 = "shiftadd?shiftno=" + URLEncoder.encode ( ( i + 1 ) + "" , "UTF-8" ) + "&shifttitle=" + URLEncoder.encode ( shifts.get ( i )[ 0 ] + "" , "UTF-8" ) + "&shiftfromtime=" + URLEncoder.encode ( shifts.get ( i )[ 1 ] + "" , "UTF-8" ) + "&shifttotime=" + URLEncoder.encode ( shifts.get ( i )[ 2 ] + "" , "UTF-8" ) + "&breakduration=" + URLEncoder.encode ( Integer.parseInt ( shifts.get ( i )[ 3 ] ) + "" , "UTF-8" ) + "&refplantid=" + URLEncoder.encode ( newRecordForAPI + "" , "UTF-8" );
                                  String result21 = WebAPITester.prepareWebCall ( addEmpAPICall1 );
                                  if(result21.contains("success"))
                                  		System.out.println("shift data saved successfully ");
                                  else
                                  	System.out.println("shift data not saved ");
                            	  

                            	  System.out.println("\n shiftno=" + URLEncoder.encode ( ( i + 1 ) + "" , "UTF-8" ) + "&shifttitle=" + URLEncoder.encode ( shifts.get ( i )[ 0 ] + "" , "UTF-8" ) + "&shiftfromtime=" + URLEncoder.encode ( shifts.get ( i )[ 1 ] + "" , "UTF-8" ) + "&shifttotime=" + URLEncoder.encode ( shifts.get ( i )[ 2 ] + "" , "UTF-8" ) + "&breakduration=" + URLEncoder.encode ( Integer.parseInt ( shifts.get ( i )[ 3 ] ) + "" , "UTF-8" ) + "&refplantid=" + URLEncoder.encode ( newRecordForAPI + "" , "UTF-8" ));
						
						 		
                              } catch ( UnsupportedEncodingException e ) {

                              }

                          }
					      
					      
				        String message="Your record saved successfully ..";
				        System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Plant.do");
						 rd.forward(request, response);	
					}
					
				else if(value.contentEquals("Edit_record"))
					{
						
						String apinamecall="plantupdate?plantid="+URLEncoder.encode(plantid, "UTF-8")+"&plantname="+URLEncoder.encode(plantname, "UTF-8")+"&plantcode="+URLEncoder.encode(plantcode, "UTF-8")+"&gstno="+URLEncoder.encode(gstno, "UTF-8")+"&plantmailaddress="+URLEncoder.encode(plantemail, "UTF-8")+"&plantweekoff="+URLEncoder.encode(plantweekoff, "UTF-8")+
								"&plantcpname="+URLEncoder.encode(plantcpname, "UTF-8")+"&plantcpno="+URLEncoder.encode(plantcpno, "UTF-8")+"&plantcpemail="+URLEncoder.encode(plantcpemail, "UTF-8")+"&companyname="+URLEncoder.encode(companyname, "UTF-8")+"&plantcontactno="+URLEncoder.encode(plantcontactno, "UTF-8");
						//String apinamecall2=URLEncoder.encode(apinamecall, "UTF-8");
						String result= WebAPITester.prepareWebCall ( apinamecall);
					     System.out.printf("\n shifts in edit record "+result+"\n");	

						
						
						
						
//						 newRecordForAPI = iDFromJSON ( result ) ;
//					     System.out.printf("\n value of newRecordForAPI "+newRecordForAPI+"\n");	
//					      
//putting shift data in arraylist
					      
					      ArrayList<String[]> shifts = new ArrayList<String[]> ();
                          
                          if(!shift1.equals(""))
                          {
                          	frmhrtime1= "0000-00-00 "+frmhrtime1+":00";
                          	tohrtime1= "0000-00-00 "+tohrtime1+":00";
                          	
                          	shifts.add ( new String[] {shiftid1, shift1 , frmhrtime1 , tohrtime1 , brk_time1 } );
                          }
                          if(!shift2.equals(""))
                          {
                          	frmhrtime2= "0000-00-00 "+frmhrtime2+":00";
                          	tohrtime2= "0000-00-00 "+tohrtime2+":00";
                          	
                          	shifts.add ( new String[] {shiftid2, shift2 , frmhrtime2 , tohrtime2 , brk_time2 } );
                          }
                          if(!shift3.equals(""))
                          {
                          	frmhrtime3= "0000-00-00 "+frmhrtime3+":00";
                          	tohrtime3= "0000-00-00 "+tohrtime3+":00";
                          	
                          	shifts.add ( new String[] {shiftid3, shift3 , frmhrtime3 , tohrtime3 , brk_time3 } );
                          }
                          if(!shift4.equals(""))
                          {
                          	frmhrtime4= "0000-00-00 "+frmhrtime4+":00";
                          	tohrtime4= "0000-00-00 "+tohrtime4+":00";
                          	
                          	shifts.add ( new String[] { shiftid4,shift4 , frmhrtime4 , tohrtime4 , brk_time4 } );
                          }
                          else
                          {
                          	System.out.println("shift data no available");
                          }
                         	System.out.println("\nshift data is reading \n ");

                          for ( int i = 0 ; i < shifts.size () ; i ++ ) {	                              

                              try {
                            	  
                            	  //calling shiftupdate api
                            	  
                                  String addEmpAPICall1 = "shiftupdate?shiftid="+URLEncoder.encode ( shifts.get ( i )[ 0 ] + "" , "UTF-8" )+"&shiftno=" + URLEncoder.encode ( ( i + 1 ) + "" , "UTF-8" ) + "&shifttitle=" + URLEncoder.encode ( shifts.get ( i )[ 1 ] + "" , "UTF-8" ) + "&shiftfromtime=" + URLEncoder.encode ( shifts.get ( i )[ 2 ] + "" , "UTF-8" ) + "&shifttotime=" + URLEncoder.encode ( shifts.get ( i )[ 3 ] + "" , "UTF-8" ) + "&breakduration=" + URLEncoder.encode ( Integer.parseInt ( shifts.get ( i )[ 4 ] ) + "" , "UTF-8" ) + "&refplantid=" + URLEncoder.encode ( plantid + "" , "UTF-8" );
                                  String result21 = WebAPITester.prepareWebCall ( addEmpAPICall1 );
                                  System.out.println("calling shiftupdate id ="+ shifts.get ( i )[ 0 ]  );
                                  if(result21.contains("success"))
                                  		System.out.println("shift data saved successfully ");
                                  else
                                  	System.out.println("shift data not saved ");
                            	  

                            	 // System.out.println("\n shiftno=" + URLEncoder.encode ( ( i + 1 ) + "" , "UTF-8" ) + "&shifttitle=" + URLEncoder.encode ( shifts.get ( i )[ 0 ] + "" , "UTF-8" ) + "&shiftfromtime=" + URLEncoder.encode ( shifts.get ( i )[ 1 ] + "" , "UTF-8" ) + "&shifttotime=" + URLEncoder.encode ( shifts.get ( i )[ 2 ] + "" , "UTF-8" ) + "&breakduration=" + URLEncoder.encode ( Integer.parseInt ( shifts.get ( i )[ 3 ] ) + "" , "UTF-8" ) + "&refplantid=" + URLEncoder.encode ( newRecordForAPI + "" , "UTF-8" ));
						
						 		
                              } catch ( UnsupportedEncodingException e ) {

                              }

                          }
						
						
				        String message="Your record is successfully updated..";
				       // System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Plant.do");
						 rd.forward(request, response);		
						 }
				else if(value.contentEquals("Delete_record"))
				{
					String message=" ";
					String apinamecall="plantdelete?plantid="+URLEncoder.encode(plantid, "UTF-8");
					   String result21 = WebAPITester.prepareWebCall ( apinamecall );
					   System.out.println("deleting plant "+result21);
                   //    System.out.println("calling shiftupdate id ="+ shifts.get ( i )[ 0 ]  );
					   
					  
					   
					   String api="shifts?plant_id="+URLEncoder.encode(plantid, "UTF-8");
					   String result = WebAPITester.prepareWebCall ( api );
					   HashMap<String , Object> map = new HashMap<String , Object> ();
					   
			            JSONObject jObject = new JSONObject ( result );
			            Iterator<?> keys = jObject.keys ();
			            while ( keys.hasNext () ) {
			                String key = ( String ) keys.next ();
			                Object value1 = jObject.get ( key );
			                map.put ( key , value1 );
			            }
			            JSONObject st = ( JSONObject ) map.get ( "data" );
			            JSONArray records = st.getJSONArray ( "records" );
			            JSONObject emp = null;

			            int count =0 ;
			            for ( int i = 0 ; i < records.length () ; i ++ ) {
			                emp = records.getJSONObject ( i );
			                String shiftresult= WebAPITester.prepareWebCall ( "shiftdelete?shiftid="+emp.get("shiftid"));  
			                count++ ;
			            }
					   
			       
			                
					   
					   
					   
                       if(count>0)
                       {
    					    message="Your record is successfully deleted..";
                       }
                       		
                       else
                       {
                    	   message="unable to delete this record..";

                       	System.out.println("shift data not delete ");
                       }
                     
				       // System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Plant.do");
						 rd.forward(request, response);		
					
				}
					else
					{/*
						 String message="Your record is not save..Please try later";
						 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
				        String message="Please fill all Fields!!";
				       // System.out.println("else part of validation");
						 request.setAttribute("errorMessage",message );
						 rd =request.getRequestDispatcher("/Plant.do");
						 rd.forward(request, response);
					}
		}
		else if(value.contentEquals("Import_to_Excel") )
		{
			/*
			try {
				File file=new File("D:\\plant_master.xls");
			//	String file=request.getParameter("input-excel");
				if(file.exists())
				{
		            System.out.println("file exists\n");

				}
				else
		            System.out.println("sorry file not exists\n");

			     System.out.println("value of selected file = "+ file);

			FileInputStream ExcelFileToRead = new FileInputStream(file);
            System.out.println("value of selected file = "+ ExcelFileToRead);

			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
			
			
//			String excelFilePath = "Books.xlsx";
//	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//	         
//	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = wb.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();
	        }
	         
	        wb.close();
	        ExcelFileToRead.close();
			}
			catch(Exception e)
			{
	            System.out.println(e);

			}
			
			*/
            FileInputStream fis;
            ArrayList<String[]>     uploadData = new ArrayList<String[]>();
            int uploadedcount=0;
            File selectedFile = null;

//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileFilter(new MyCustomFilter("excel 97-2003"));
//            fileChooser.setCurrentDirectory(new File(System.getProperty(
//                    "user.home")));
//            int result = fileChooser.showOpenDialog(this);
//            if (result == JFileChooser.APPROVE_OPTION) {
//
//                selectedFile = fileChooser.getSelectedFile();
//            }

            FileChannel inputChannel = null;
            FileChannel outputChannel = null;

            File dir = new File("dataupload\\");
            dir.mkdirs();

//            try {
//                inputChannel = new FileInputStream("C:\\Users\\WIN7\\Downloads\\machine_data1.xlsx").getChannel();
//                outputChannel = new FileOutputStream(new File(dir, selectedFile.getName())).getChannel();
//
//                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
//
//                inputChannel.close();
//                outputChannel.close();
//
//            } catch (FileNotFoundException fnfe) {
//            } catch (IOException ioe) {
//            }

            String url;
            try {

//                url = "jdbc:sqlite:" + StaticValues.dbName;
//                Connection con = DriverManager.getConnection(url);
//                Statement stm = con.createStatement();
//                PreparedStatement pst;

                //String query = "INSERT INTO xl_import_test ( ID, name, address, phone, email) VALUES ( ?,?,?,?,?)";
                String query = "INSERT INTO finished_goods ( FG_PART_UNIQUE_ID,  FG_PART_NO, PART_NAME ) VALUES ( ?,?,?  )";

                // pst = con.prepareStatement ( query );
                fis = new FileInputStream(new File("C:\\Users\\WIN7\\Downloads\\machine_data.xls"));

                HSSFWorkbook my_xls_workbook = new HSSFWorkbook(fis);
                HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

                Iterator<Row> rowIterator = my_worksheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    String[] dataRow = new String[8];

                    try {
                        //  pst.setString ( 1 , row.getCell ( 0 ).getStringCellValue () );
                        dataRow[0] = row.getCell(0).getStringCellValue();
                    } catch (Exception e2) {
                        try {
                            //      pst.setInt ( 1 , ( int ) row.getCell ( 0 ).getNumericCellValue () );
                            dataRow[0] = row.getCell(0).getNumericCellValue() + "";

                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 2 , row.getCell ( 1 ).getStringCellValue () );
                        dataRow[1] = row.getCell(1).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt ( 2 , ( int ) row.getCell ( 1 ).getNumericCellValue () );
                            dataRow[1] = row.getCell(1).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 3 , row.getCell ( 2 ).getStringCellValue () );
                        dataRow[2] = row.getCell(2).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt ( 3 , ( int ) row.getCell ( 2 ).getNumericCellValue () );
                            dataRow[2] = row.getCell(2).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 3 , row.getCell ( 2 ).getStringCellValue () );
                        dataRow[3] = row.getCell(3).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt ( 3 , ( int ) row.getCell ( 2 ).getNumericCellValue () );
                            dataRow[3] = row.getCell(3).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 4 , row.getCell ( 3 ).getStringCellValue () );
                        dataRow[4] = row.getCell(4).getStringCellValue();
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt ( 4 , ( int ) row.getCell ( 3 ).getNumericCellValue () );
                            dataRow[4] = row.getCell(4).getNumericCellValue() + "";

                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
                        dataRow[5] = row.getCell(5).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
                            dataRow[5] = row.getCell(5).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
                        dataRow[6] = row.getCell(6).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
                            dataRow[6] = row.getCell(6).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    try {
                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
                        dataRow[7] = row.getCell(7).getStringCellValue() + "";
                    } catch (Exception e2) {
                        try {
                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
                            dataRow[7] = row.getCell(7).getNumericCellValue() + "";
                        } catch (Exception e1) {
                        }
                    }

                    uploadData.add(dataRow);
                    System.out.println(dataRow[0]+"\t"+dataRow[1]+"\t"+dataRow[2]+"\t"+dataRow[3]+"\t"+dataRow[4]+"\t"+dataRow[5]+"\t"+dataRow[6]+"\t"+dataRow[7]+"\t");
                    
                    

                    try {
                     String   addEmpAPICall = "machineadd?MACHINE_NO="+URLEncoder.encode(dataRow[1], "UTF-8")+
                    		 "&MAKE="+URLEncoder.encode(dataRow[2], "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+
                    		 "&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+
                    		 "&CR_MAINT_RTG="+URLEncoder.encode("", "UTF-8")+
                    		 "&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+
                    		 "&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+
                    		 "&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+
                    		 "&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+
                    		 "&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+
                    		 "&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(dataRow[3], "UTF-8")+
                    		 "&AVL_HRS="+URLEncoder.encode(dataRow[5], "UTF-8")
                    		 +"&DAVLHRS="+URLEncoder.encode("", "UTF-8")+
                    		 "&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("harshal", "UTF-8")+
                    		 "&TYPE="+URLEncoder.encode(dataRow[3], "UTF-8"); 
                  String   result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
                  if(result2.contains("success"))
                  {
               	   	String message="\nYour record is successfully save..\n";
               	   	System.out.println(message);
                        uploadedcount++;
                  }
                  else
                 	   	System.out.println("Sorry your data not uploaded");


                    } catch (UnsupportedEncodingException e) {

                    }
                }
                    //  pst.addBatch ();
                    
//                String addEmpAPICall = "finishedgoods";
//                String result2 = WebAPITester.prepareWebCall(addEmpAPICall, StaticValues.getHeader(), "");
//
//                if (!result2.contains("not found")) {
//
//                    if (result2 != null) {
//                        jTable1.setModel(buildTableModelfromJSON(result2));
//                        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
//                        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
//                    }
//                }
			
			
			
                
			
            } catch (IOException ex) {
                System.out.println("IO  " + ex.getMessage());
            }
			
	        rd =request.getRequestDispatcher("/Plant.do");
			 rd.forward(request, response);
           
		}
			
                
                
            
            
		else
		{/*
			 String message="Your record is not save..Please try later";
			 response.sendRedirect("PlantTable?message=" + URLEncoder.encode(message, "UTF-8"));	*/
	        String message="Please fill all Fields!!";
	       // System.out.println("else part of validation");
			 request.setAttribute("errorMessage",message );
			 rd =request.getRequestDispatcher("/Plant.do");
			 rd.forward(request, response);
		}
	}
	public static Vector readExcelFile(String fileName)
	{
	    /** --Define a Vector
	        --Holds Vectors Of Cells
	     */
	    Vector cellVectorHolder = new Vector();

	    try{
	    /** Creating Input Stream**/
	    //InputStream myInput= ReadExcelFile.class.getResourceAsStream( fileName );
	    FileInputStream myInput = new FileInputStream(fileName);

	    /** Create a POIFSFileSystem object**/
	    POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

	    /** Create a workbook using the File System**/
	     HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

	     /** Get the first sheet from workbook**/
	    HSSFSheet mySheet = myWorkBook.getSheetAt(0);

	    /** We now need something to iterate through the cells.**/
	      Iterator rowIter = mySheet.rowIterator();

	      while(rowIter.hasNext()){
	          HSSFRow myRow = (HSSFRow) rowIter.next();
	          Iterator cellIter = myRow.cellIterator();
	          Vector cellStoreVector=new Vector();
	          while(cellIter.hasNext()){
	              HSSFCell myCell = (HSSFCell) cellIter.next();
	              cellStoreVector.addElement(myCell);
	          }
	          cellVectorHolder.addElement(cellStoreVector);
	      }
	    }catch (Exception e){e.printStackTrace(); }
	    return cellVectorHolder;
	}
	
	

private static void printCellDataToConsole(Vector dataHolder) {

 
	
	try {  
    for (int i=0;i<400; i++){
    	 
     
    	
               Vector cellStoreVector=(Vector)dataHolder.elementAt(i);
               
               
               
                      
        for (int j=0; j < cellStoreVector.size();j++){
            HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);
            String stringCellValue = myCell.toString();
            System.out.print(j+" "+stringCellValue+"\t");
            
            
            
        }
        
        System.out.println();
        
       
       
    }
    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public int iDFromJSON( String json){
        int id = 0;
       
        JSONObject jObject = new JSONObject ( json );
        JSONObject value = (JSONObject) jObject.get ( "data" );
        id = Integer.parseInt(value.get ("insert_id" ).toString());
//        id = Integer.parseInt( st.getString ("insert_id" ));
        
        return id ;
    }
	
}
