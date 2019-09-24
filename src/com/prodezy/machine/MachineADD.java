package com.prodezy.machine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;

@WebServlet("/machineADD")
public class MachineADD extends HttpServlet {

	public MachineADD() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("do get call");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        MachineData dao = new MachineData();
      
        List<MachineDR> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("machineList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/WebContent/Machines.jsp");
        view.forward(request, resp);
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    System.out.println("post");
    	String selectedID="";
        String machineno=request.getParameter("machineno");
        String make=request.getParameter("make");
        String mc_type=request.getParameter("ismachinetype");
        String operating=request.getParameter("operating");
        String available=request.getParameter("available");
        String desig_available=request.getParameter("desig_available");
        String maintenance_rating=request.getParameter("maintenance_rating");
        selectedID=request.getParameter("thisFieldID");
        
        
        //HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        if(request.getParameter("Add_to_Machine_Master")!=null)
        {
        	System.out.println("Add button click");
        if(  !machineno.equals( "")   ){
        
        	String addEmpAPICall="",result2="";
                try{
                    if(selectedID.isEmpty())
                    {
                    addEmpAPICall = "machineadd?MACHINE_NO="+URLEncoder.encode(machineno, "UTF-8")+"&MAKE="+URLEncoder.encode(make, "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+"&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+"&CR_MAINT_RTG="+URLEncoder.encode( maintenance_rating, "UTF-8")+"&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+"&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+"&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+"&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+"&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+"&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(operating, "UTF-8")+"&AVL_HRS="+URLEncoder.encode(available, "UTF-8")+"&DAVLHRS="+URLEncoder.encode(desig_available, "UTF-8")+"&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("mayur", "UTF-8")+"&TYPE="+URLEncoder.encode(mc_type, "UTF-8"); 
                    result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
                   
                    }
                    else
                    {
                    	//update by id
                    	System.out.println("update your code");
                    	
                    }
                   if(result2.contains("success"))
                   {
//                       request.setAttribute("status","Data submitted");
//                       request.getSession().setAttribute("message","Data submitted" );
//                       out.println("<script type=\"text/javascript\">");
//                       out.println("alert('Data submitted');");
//                       out.println("location='Machines.jsp';");
//                       out.println("</script>");
                	   String message="Your record is successfully save..";
                	   response.sendRedirect("Machines.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
                  	 

                   }
                   else
                   {
//                       request.setAttribute("status","Data not submitted");
//                       request.getSession().setAttribute("message","Data not submitted" );
//                       out.println("<script type=\"text/javascript\">");
//                       out.println("alert('Data not submitted');");
//                       out.println("location='Machines.jsp';");
//                       out.println("</script>");
                	   String message="Your record is not save..Please try later";
                	   response.sendRedirect("Machines.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
                   }
                   
                   
                   //response.sendRedirect("Machines.jsp");
//                    RequestDispatcher rd=request.getRequestDispatcher("/Machines.jsp");  
//                   rd.forward(request, response);
                }catch(UnsupportedEncodingException e){
                    
                }

            
            //JOptionPane.showMessageDialog(null, "Machine added successfuly");

        }else{
            //JOptionPane.showMessageDialog(null, "Please fill mandatory fields marked with * " );
            response.sendRedirect("Machines.jsp");
        }
        }
        else if(request.getParameter("Edit_record")!=null)
        {
        	System.out.println("edit_record button click");
        	if(!selectedID.isEmpty())
        	{
        		
        	String addEmpAPICall = "machinesupdate?MCH_ID="+URLEncoder.encode(selectedID, "UTF-8")+"&MACHINE_NO="+URLEncoder.encode(machineno, "UTF-8")+"&MAKE="+URLEncoder.encode(make, "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+"&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+"&CR_MAINT_RTG="+URLEncoder.encode( maintenance_rating, "UTF-8")+"&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+"&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+"&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+"&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+"&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+"&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(operating, "UTF-8")+"&AVL_HRS="+URLEncoder.encode(available, "UTF-8")+"&DAVLHRS="+URLEncoder.encode(desig_available, "UTF-8")+"&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("mayur", "UTF-8")+"&TYPE="+URLEncoder.encode(mc_type, "UTF-8");  
            String result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
            System.out.print(result2);
            
            if(result2.contains("success"))
            {
         	   String message="Your record is successfully updated..";
         	   response.sendRedirect("Machines.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

            }
            else
            {
         	   String message="Your record is not update..Please try later";
         	   response.sendRedirect("Machines.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
            }
        	}
        	//response.sendRedirect("Machines.jsp");
        }
        else if(request.getParameter("Export_to_Excel")!=null)
        {
        	System.out.println("Export to excel button click");
        	
        	String MCH_ID = "",MACHINE_NO="", MAKE = "", BED_SIZE = "", HEATER_QTY = "", YR_OF_COMM = "", CR_MAINT_RTG = "", CR_MCH_OWN = "", MCH_BRKD_RCD = "", PM_ELE = "", PM_MEC = "",PM_HYD="",PM_PNM="",PM_CLIT="",PRSS_GAUGE="",TIMER="",TEMP_CTRL="",OP_RATE_HR="",AVL_HRS="",DAVLHRS="";

            //int die_id;
            int l = 2;

            Map<String, Object[]> data11;
            data11 = new TreeMap<String, Object[]>();

            String[] columns = { "Machine No", "Make", "Bed Size", "Heater QTY", "Year of commission", "Maintenance Rating","Machine Owner","Electrical","Mechanical","Hydraulic","Pneumatic","Clit","Pressure Gauge","Timer","Temperature Controller","Opertaing Rate/HR","Available Hours","Design Availablity in Hours"};
            data11.put("1", new Object[]{ "Machine No", "Make", "Bed Size", "Heater QTY", "Year of commission", "Maintenance Rating","Machine Owner","Electrical","Mechanical","Hydraulic","Pneumatic","Clit","Pressure Gauge","Timer","Temperature Controller","Opertaing Rate/HR","Available Hours","Design Availablity in Hours"});
         

            String result2, addEmpAPICall;
            
            addEmpAPICall = "machines";
            
            result2 = WebAPITester.prepareWebCall(addEmpAPICall);

            if (!result2.contains("not found")) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                JSONObject jObject = new JSONObject(result2);
                Iterator<?> keys = jObject.keys();

                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Object value = jObject.get(key);
                    map.put(key, value);
                }

                JSONObject st = (JSONObject) map.get("data");
                JSONArray records = st.getJSONArray("records");
                
                JSONObject emp = null;
                for (int i = 0; i < records.length(); i++) {

                    emp = records.getJSONObject(i);
                    //jComboBox1.addItem ( emp.get ( "die_tool_no" ).toString () );

                    
                     MCH_ID = emp.get("MCH_ID").toString();
                     MACHINE_NO=emp.get("MACHINE_NO").toString();
                     MAKE = emp.get("MAKE").toString();
                     BED_SIZE = emp.get("BED_SIZE").toString();
                     HEATER_QTY =emp.get("HEATER_QTY").toString();
                     YR_OF_COMM = emp.get("YR_OF_COMM").toString();
                     CR_MAINT_RTG = emp.get("CR_MAINT_RTG").toString();
                     CR_MCH_OWN = emp.get("CR_MCH_OWN").toString();
                     //MCH_BRKD_RCD = emp.get("MCH_BRKD_RCD").toString();
                     PM_ELE = emp.get("PM_ELE").toString();
                     PM_MEC = emp.get("PM_MEC").toString();
                     PM_HYD=emp.get("PM_HYD").toString();
                     PM_PNM=emp.get("PM_PNM").toString();
                     PM_CLIT=emp.get("PM_CLIT").toString();
                     PRSS_GAUGE=emp.get("PRSS_GAUGE").toString();
                     TIMER=emp.get("TIMER").toString();
                     TEMP_CTRL=emp.get("TEMP_CTRL").toString();
                     OP_RATE_HR=emp.get("OP_RATE_HR").toString();
                     AVL_HRS=emp.get("AVL_HRS").toString();
                     DAVLHRS=emp.get("DAVLHRS").toString();

                     System.out.println(MCH_ID);
                     System.out.println(MACHINE_NO);
                     System.out.println(MAKE);
                     System.out.println(BED_SIZE);
                     System.out.println(HEATER_QTY);
                     System.out.println(YR_OF_COMM);
                     System.out.println(CR_MAINT_RTG);
                     System.out.println(CR_MCH_OWN);
                     System.out.println(PM_ELE);
                     System.out.println(PM_MEC);
                     System.out.println(PM_HYD);
                     System.out.println(PM_PNM);
                     System.out.println(PM_CLIT);
                     System.out.println(PRSS_GAUGE);
                     System.out.println(TIMER);
                     System.out.println(TEMP_CTRL);
                     System.out.println(OP_RATE_HR);
                     System.out.println(AVL_HRS);
                     System.out.println(DAVLHRS);
                     
                    data11.put("" + l, new Object[]{ MACHINE_NO, MAKE, BED_SIZE, HEATER_QTY, YR_OF_COMM, CR_MAINT_RTG,CR_MCH_OWN,PM_ELE,PM_MEC ,PM_HYD,PM_PNM,PM_CLIT,PRSS_GAUGE,TIMER,TEMP_CTRL,OP_RATE_HR,AVL_HRS,DAVLHRS});
                    
                    l = l + 1;
                }
            }
            
            try {
                String fileName = "C:\\Users\\dell\\eclipse-workspace\\Machine Master.xls";
              //Blank workbook
                Workbook workbook = new HSSFWorkbook();

                //Create a blank sheet
                HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Machine Master");

                
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font font = workbook.createFont();
                font.setColor(IndexedColors.AUTOMATIC.getIndex());
                style.setFont(font);

                //Iterate over data and write to sheet
                Set<String> keyset = data11.keySet();
                int rownum = 0;
                for (String key : keyset) {
                    Row row = sheet.createRow(rownum++);
                    Object[] objArr = data11.get(key);
                    int cellnum = 0;
                    for (Object obj : objArr) {
                        Cell cell = row.createCell(cellnum++);
                        if (obj instanceof String) {
                            cell.setCellValue((String) obj);
                        } else if (obj instanceof Integer) {
                            cell.setCellValue((Integer) obj);
                        }
                    }
                }
                // Resize all columns to fit the content size
                for (int i = 0; i < columns.length; i++) {
                    sheet.autoSizeColumn(i);
                }
                
                FileOutputStream fileOut = new FileOutputStream(fileName);
                workbook.write(fileOut);
                fileOut.close();
                System.out.println("Your excel file has been generated!");

                //Code to download
                File fileToDownload = new File(fileName);
                InputStream in = new FileInputStream(fileToDownload);

                // Gets MIME type of the file
                String mimeType = new MimetypesFileTypeMap().getContentType(fileName);

                if (mimeType == null) {
                    // Set to binary type if MIME mapping not found
                    mimeType = "application/octet-stream";
                }
                System.out.println("MIME type: " + mimeType);

                // Modifies response
                response.setContentType(mimeType);
                response.setContentLength((int) fileToDownload.length());

                // Forces download
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileToDownload.getName());
                response.setHeader(headerKey, headerValue);

                // obtains response's output stream
                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = in.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

                in.close();
                outStream.close();

                System.out.println("File downloaded at client successfully");
            	response.sendRedirect("Machines.jsp");
                
            	}catch(Exception e)
                {
                	
                }
           
        }
        else if(request.getParameter("Create_QR_code")!=null)
        {
        	System.out.println("Create QR code button click");
        	
        	
        	response.sendRedirect("Machines.jsp");
        }
        else
        {
        	System.out.println("cant be submit button click");
        	
        	
        	response.sendRedirect("Machines.jsp");
        }
        
        
        
        
//        String mc_current_owner=request.getParameter("mc_current_owner");
//        String pressure_gauge=request.getParameter("pressure_gauge");
//        String Timer=request.getParameter("Timer");
//        String Temp=request.getParameter("Temp");
//        String bed_size=request.getParameter("bed_size");
//        String heater=request.getParameter("heater");
//        String owername=request.getParameter("owername");
//        String electrical=request.getParameter("electrical");
//        String mechanical=request.getParameter("mechanical");
//        String hydraulic=request.getParameter("hydraulic");
//        String pneumatic=request.getParameter("pneumatic");
//        String clit=request.getParameter("clit");

        
        
//        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","production","12345");
//            Statement st=con.createStatement();
//            PrintWriter out = response.getWriter();
//            
//            int a=1;
//            String s="select * from machine";
//            ResultSet rs=st.executeQuery(s);
//            while(rs.next()) 
//            {
//                a++;
//            }
//            String q= "insert into machine values("+machineno+",'"+machinephoto+"','"+make+"',"+bedsize+","+no_of_heater+",'"+year_of_commission+"','"+current_maintenance+"','"+owername+"','"+mownerphoto+"','"+electrical+"','"+mechanical+"','"+hydraulic+"','"+pneumatic+"','"+clit+"',"+breakdownrecord+",'"+operating_rate+"','"+available_hr+"')";
//            int i=st.executeUpdate(q);
//            
//           out.println("<html>");
//            out.println("<body>");
//            
//            
//            if(i>0)
//            {
//            out.println("Query Executed..");
//            }
//            else
//            {
//              out.println("Query Not Execute");  
//            }
//            out.println("</body>");
//            out.println("</html>");
//            
//            response.sendRedirect("Machines.jsp");
//            
//        }
//        catch(ClassNotFoundException ce)
//        {
//            System.out.println("ClassNotFound Error : "+ce);
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Error : "+e);
//        }
       

    }
    
    public void export_to_Excel()
    {
    	 
    }
    
    
}
