package com.prodezy.diemaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.plantmaster.PlantDR;
import com.prodezy.webservices.WebAPITester;

//edited by harshal
public class DieMaster {
	private int noOfRecords;
	 public List<DieDR> list(int offset, int noOfRecords) {
	    	
	    	ArrayList<DieDR> mcTypes=new ArrayList<>();
	    	
	         String addEmpAPICall = "die_tool";
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
                    
                    String name,total_strokes,cost_maintenance,maintenance_stroke,reminder_count,date_maintenance,owner_id,shut_id,tonnage,dimensions,cost_purchase;
                    String id,no;
                    id=(emp.get ( "DT_ID" ).toString ());
                    no=emp.get ( "die_tool_no" ).toString ();
                    name=emp.get ( "die_name" ).toString ();
                    total_strokes=emp.get("total_strokes").toString();
                    cost_maintenance=emp.get("cost_maintenance").toString();
                    maintenance_stroke=emp.get("maintenance_strokes").toString();
                    reminder_count=emp.get("reminder_count").toString();
                    date_maintenance=emp.get("date_maintenance").toString();
                    owner_id=emp.get("owner_id").toString();
                    shut_id=emp.get("shut_height").toString();
                    tonnage=emp.get("tonnage").toString();
                    dimensions=emp.get("dimension").toString();
                    cost_purchase=emp.get("cost_purchase").toString();

                    

                    //machineTypes.add(new MachineDR(id,name));	
                    mcTypes.add(new DieDR (id,no,name,total_strokes,cost_maintenance,maintenance_stroke,reminder_count,date_maintenance,owner_id,shut_id,tonnage,dimensions,cost_purchase) );
                    System.err.println("id"+id+"name"+ name);
                    //machine.setMC_ID(id  );
                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

                }
            }
            return mcTypes;
	}
	 public int getNoOfRecords()
     {
		 
     	return noOfRecords;
     }

}
