package com.prodezy.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

import sun.security.util.Length;

public class MachineData {
	
	private int noOfRecords;
	 public List<MachineDR> list(int offset, int noOfRecords) {
	    	
	    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	    	ArrayList<MachineDR> machineTypes=new ArrayList<>();
	    	
	         String addEmpAPICall = "machines";
             String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);

	            if( ! result2.contains( "not found" )){
	                HashMap<String, Object> map = new HashMap<String, Object>();
	                

	                JSONObject jObject;

	                jObject = new JSONObject(result2 );
	                Iterator<?> keys = jObject.keys();

	                while( keys.hasNext() ){
	                    String key = (String)keys.next();
	                    Object value = jObject.get ( key ) ; 
	                    map.put(key, value);
	                }

	                JSONObject st = (JSONObject) map.get ( "data" );
	                JSONArray records = st.getJSONArray("records");

	                JSONObject emp = null;
	                
	                for ( int i = 0 ; i < records.length(); i ++ ) {

	                    emp = records.getJSONObject(i);
	                    
	                    String MCH_ID="",MACHINE_NO="",MAKE="",OP_RATE_HR="",AVL_HRS="",DAVLHRS="";
	                    
	                    MCH_ID=(emp.get ( "MCH_ID" ).toString ());
	                    MACHINE_NO=emp.get ( "MACHINE_NO" ).toString ();
	                    MAKE=emp.get ( "MAKE" ).toString ();
	                    OP_RATE_HR=emp.get ( "OP_RATE_HR" ).toString ();
	                    AVL_HRS=emp.get ( "AVL_HRS" ).toString ();
	                    DAVLHRS=emp.get ( "DAVLHRS" ).toString ();
	                    //machineTypes.add(new MachineDR(id,name));
	                    mcTypes.add(new String[] {MCH_ID,MACHINE_NO,MAKE,OP_RATE_HR,AVL_HRS,DAVLHRS} );
	                    machineTypes.add(new MachineDR (MCH_ID,MACHINE_NO,MAKE,OP_RATE_HR,AVL_HRS,DAVLHRS));
	                    //System.err.println("id"+id+"    name"+ name);
	                    //machine.setMC_ID(id  );
	                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
	                    
	                    
	                }
	                noOfRecords=machineTypes.size();
	                this.noOfRecords=noOfRecords;
	                
	            }
	            
	            return machineTypes;
	            
	 }
	 public int getNoOfRecords()
     {
     	return noOfRecords;
     }

}


//<table id="table1" border="1" align="center">
//<tr>
//	<th>MCH_ID</th>
//	<th>MACHINE_NO</th>
//	<th>MAKE</th>
//	<th>OP_RATE_HR</th>
//	<th>AVL_HRS</th>
//	<th>DAVLHRS</th>
//</tr>
//<%
//ArrayList<MachineDR> mc_data1 = new MachineData().list();
//request.setAttribute("mc_data", mc_data1);
//
//%>
//<tbody>
//	<c:forEach items="${mc_data}" var="data">
//     		<tr>
//                <td>${data.MCH_ID}</td>
//                <td>${data.MACHINE_NO}</td>
//                <td>${data.MAKE}</td>
//                <td>${data.OP_RATE_HR}</td>
//                <td>${data.AVL_HRS}</td>
//                <td>${data.DAVLHRS}</td>
//            </tr>
//</c:forEach>			
//	</tbody>			
//
//
//</table>


//<c:if test="${currentPage It noOfPages }">
//<td> <a href="Machines.jsp?page=${currentPage + 1 }"> Next</a> </td>
//</c:if>
