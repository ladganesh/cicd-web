package com.prodezy.plantmaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;
public class PlantData {
	
	private int noOfRecords;
	 public List<PlantDR> list(int offset, int noOfRecords) {
	    	
	    	ArrayList<PlantDR> mcTypes=new ArrayList<>();
	    	//ArrayList<PlantDR> planttable=new ArrayList<>();
	    	
	         String addEmpAPICall = "plants";
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
	                    
	                    String plantid="",plantname="",plantcode="",gstno="",plantaddress="",plantweekoff="",plantcpname,plantcpno,plantcpemail,companyname,complogo,plantcontactno,plantemail;
	                    
	                    plantid=(emp.get ( "plantid" ).toString ());
	                    plantname=emp.get ( "plantname" ).toString ();
	                    plantcode=emp.get ( "plantcode" ).toString ();
	                    gstno=emp.get ( "gstno" ).toString ();
	                    plantaddress=emp.get ( "plantaddress" ).toString ();
	                    plantweekoff=emp.get ( "plantweekoff" ).toString ();
	                    plantcpname=emp.get ( "plantcpname" ).toString ();
	                    plantcpno=emp.get ( "plantcpno" ).toString ();
	                    plantcpemail=emp.get ( "plantcpemail" ).toString ();
	                    companyname=emp.get ( "companyname" ).toString ();
	                    complogo=emp.get ( "complogo" ).toString ();
	                    plantcontactno=emp.get ( "plantcontactno" ).toString ();
	                   plantemail=emp.get ( "plantemailaddress" ).toString ();
	                   mcTypes.add(new PlantDR (plantid,plantname,plantcode,gstno,plantaddress,plantweekoff,plantcpname,plantcpno,plantcpemail,companyname,complogo,plantcontactno,plantemail));

	                    //System.err.println("id"+id+"    name"+ name);
	                    //machine.setMC_ID(id  );
	                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
	                    
	                    System.out.println("Here we come plantdata");
	                }
	                noOfRecords=mcTypes.size();
	                this.noOfRecords=noOfRecords;
	                
	            }
	            
	            return mcTypes;
	            
	 }
	 public List<ShiftDR> shifts(int offset, int noOfRecords) {
	    	
	    	ArrayList<ShiftDR> shift1=new ArrayList<>();
	    	//ArrayList<PlantDR> planttable=new ArrayList<>();
	    	
	         String addEmpAPICall = "shifts";
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
	                    

	                 String shiftid;
	                 String shiftno;
	                 String shifttitle ;
	                 String shiftfromtime ;
	                 String shifttotime;
	                 String breakduration;
	                 String refplantid;
	                    
	                 shiftid=(emp.get ( "shiftid" ).toString ());
	                 shiftno=emp.get ( "shiftno" ).toString ();
	                 shifttitle=emp.get ( "shifttitle" ).toString ();
	                 shiftfromtime=emp.get ( "shiftfromtime" ).toString ();
	                 shifttotime=emp.get ( "shifttotime" ).toString ();
	                 breakduration=emp.get ( "breakduration" ).toString ();
	                 refplantid=emp.get ( "refplantid" ).toString ();
	                  
	                    //machineTypes.add(new MachineDR(id,name));
	                   // mcTypes.add(new String[] {plantid,plantname,plantcode,gstno,plantaddress,plantweekoff,plantcpname,plantcpno,plantcpemail,companyname,complogo,plantcontactno} );
	                  //  planttable.add(new PlantDR (plantid,plantname,plantcode,gstno,plantaddress,plantweekoff,plantcpname,plantcpno,plantcpemail,companyname,complogo,plantcontactno));
	                    shift1.add(new ShiftDR (shiftid,shiftno,shifttitle,shiftfromtime,shifttotime,breakduration,refplantid));

	                    //System.err.println("id"+id+"    name"+ name);
	                    //machine.setMC_ID(id  );
	                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
	                    
	                    System.out.println("Here we come plantdata");
	                }
	                noOfRecords=shift1.size();
	                this.noOfRecords=noOfRecords;
	                
	            }
	            
	            return shift1;
	            
	 }
	   
	 public int getNoOfRecords()
     {
     	return noOfRecords;
     }

}