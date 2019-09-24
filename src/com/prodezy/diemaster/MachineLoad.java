package com.prodezy.diemaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

public class MachineLoad {

	public ArrayList<String[]> list() {
    	
    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    	
         String addEmpAPICall = "machines";
            String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
            System.out.println("result2");

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
                    
                    String name;
                    String id;
                    id=(emp.get ( "MCH_ID" ).toString ());
                    name=emp.get ( "MACHINE_NO" ).toString ();
                    //machineTypes.add(new MachineDR(id,name));
                    mcTypes.add(new String[] {id,name} );
                    System.err.println("id"+id+"    name"+ name);
                    //machine.setMC_ID(id  );
                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

                }
            }
            return mcTypes;
	}

}
