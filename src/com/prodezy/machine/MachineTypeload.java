package com.prodezy.machine;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import org.json.JSONArray;
import org.json.JSONObject;
import com.prodezy.webservices.*;


public class MachineTypeload {
	
//ArrayList<MachineDR> machineTypes = new ArrayList<MachineDR>() ;
//ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    
    public ArrayList<String[]> list() {
    	
    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    	
         String addEmpAPICall = "machinestypes";
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
                    id=(emp.get ( "MC_TYPE_ID" ).toString ());
                    name=emp.get ( "MC_TYPE" ).toString ();
                    //machineTypes.add(new MachineDR(id,name));
                    mcTypes.add(new String[] {id,name} );
                    //System.err.println("id"+id+"    name"+ name);
                    //machine.setMC_ID(id  );
                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

                }
            }
            return mcTypes;
    }
    
//    public ArrayList<MachineDR> staticlist()
//    {
//    	ArrayList<MachineDR> machineTypes=new ArrayList<MachineDR>();
//    	
//    	machineTypes.add(new MachineDR(1,"myr"));
//    	machineTypes.add(new MachineDR(2,"vish"));
//    	machineTypes.add(new MachineDR(3,"parth"));
//    	machineTypes.add(new MachineDR(4,"swami"));
//    	machineTypes.add(new MachineDR(5,"dip"));
//    	machineTypes.add(new MachineDR(6,"swap"));
//    	machineTypes.add(new MachineDR(7,"shar"));
//    	
//    	return machineTypes;
//    }
    
//    public ArrayList<String[]> getList1()
//	{
//		ArrayList<String[]> empList=new ArrayList<String[]>();
//			empList.add(new String[] {"1","asd"});
//			empList.add(new String[] {"2","Mayur"});
//			empList.add(new String[] {"3","Harshali"});
//			empList.add(new String[] {"1","Akshay"});
//			empList.add(new String[] {"1","Ajay"});
//			empList.add(new String[] {"1","Harshad"});
//			empList.add(new String[] {"1","Pankaj"});
//			empList.add(new String[] {"1","Aakash"});			
//		return empList;
//	}
 
    
//   
//    public String prepareWebCall ( String api) {
//         URL myUrl=null;
//         HttpURLConnection connection = null;
//         final String REQUEST_METHOD = "POST";
//         final int READ_TIMEOUT = 60000;
//         final int CONNECTION_TIMEOUT = 60000;
//         String inputLine;
//         String result;
//         String header="eyJpdiI6Ik12OEJWT05uS2J6N0VVSUtMUUdQOUE9PSIsInZhbHVlIjoibnBvOHcwRzBJazdwRm5YVldLMHZHK2tvWWhrNVRtUE43TysyeTIrUm55MUozWCsyR3RGY1wvemIwbTRIQUpxaVwvRyt3XC9vZzN4ajJ3N21ibHFmeVJzM3ZlOHZLVkh2cmRrMlJvSUpKZ0VVaHcxRStmSytlYnlRa2dpMHBZXC83ZlQxc1JKRWMwZnZMWWE0XC9keVRVdW1wNXBIbEN5YnFpZlhEbWpoYlo0dzRwT2VSU1FnYkxYZ0N2UVZIZXd1SGR2dUtkZkd3VWx5VTk2Z01GcFwvNEdWcDh0emdBdnRcLytWK0syblwvUFpSZ2k5emJxSXRUZ3N6ZGN1aXFpdGN0ZGF0MWhpIiwibWFjIjoiMTQxMTM4MTc5MmRiZjgzNzgwYWExNDU4ZjQ1MjZjNWM1NjA1MzQ3YWVlZjMxYmM0YzE3ZGQyNDRkZmMxNDM2NiJ9";
//         
//       String url = "http://192.168.0.107:80/projects/erp/public/"+api;
////         System.err.println(apiNameANDparameters);
////         System.err.println(url);
//        try {
//            myUrl = new URL ( url );
//        } catch ( MalformedURLException e1 ) {
//            System.out.println ( ""+e1.getMessage () );
//        }
//
//        try {
//            connection = ( HttpURLConnection ) myUrl.openConnection();
//            connection.setRequestMethod ( REQUEST_METHOD );
//            connection.setReadTimeout ( READ_TIMEOUT );
//            connection.setConnectTimeout ( CONNECTION_TIMEOUT );
//            connection.setDoInput ( true );
//            connection.setDoOutput ( true );
//            connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            
//            if( !api.contains ("auth/login" )){
//                 connection.addRequestProperty ( "Authorization" , "encoded " +header  ); 
//            }
//            connection.connect ();
//            
//            DataOutputStream request = new DataOutputStream ( connection.getOutputStream () );
//          
//            
//            request.flush ();
//            request.close ();
//            connection.connect ();
//
//            InputStreamReader streamReader = new InputStreamReader ( connection.getInputStream () );
//
//            BufferedReader reader = new BufferedReader ( streamReader );
//            StringBuilder stringBuilder = new StringBuilder ();
//
//            while ( ( inputLine = reader.readLine () ) != null ) {
//                stringBuilder.append ( inputLine );
//            }
//
//            reader.close ();
//            streamReader.close ();
//
//            result = stringBuilder.toString ();
//            return result;
//
//        } catch ( IOException e2 ) {
//            return e2.getMessage ();
//        }
//
//    }

}
