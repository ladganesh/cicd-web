package com.prodezy.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeList {
	public ArrayList<String[]> getEmployeeList()
	{
		ArrayList<String[]> empList=new ArrayList<String[]>();
		empList.add(new String[] {"1","Akshay"});
		empList.add(new String[] {"2","Ajay"});
		empList.add(new String[] {"3","Harshali"});
		empList.add(new String[] {"4","Mayur"});
		empList.add(new String[] {"5","Demo 111111111111111111111"});
		empList.add(new String[] {"6","Mayur"});

		String addEmpAPICall ="employees";
//        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall, StaticValues.getHeader ()   , "");
//        if( !  result2.contains(  "not found"   )  )
//        {
//            if ( result2!= null ) 
//            {
//                  HashMap<String, Object> map = new HashMap<String, Object>();
//                  JSONObject jObject = new JSONObject( result2 );
//                  Iterator<?> keys = jObject.keys();
//
//                  while( keys.hasNext() )
//                  {
//                      String key = (String)keys.next();
//                      Object value = jObject.get ( key ) ; 
//                      map.put(key, value);
//                  }
//  
//                  JSONObject st = (JSONObject) map.get ( "data" );
//                  JSONArray records = st.getJSONArray ( "records");
//
//                  JSONObject emp = null;
//                  for ( int i = 0 ; i < records.length () ; i ++ ) 
//                  {
//                          emp = records.getJSONObject ( i);
//                          empList.add(new String[]{emp.getInt("EmployeePK")+"",emp.getString ( "EMP_NAME" )} ) ;
//                  }
//            }
//        }
		return empList;
	}
	
	public void cheack(String meth)
	{
		System.out.println(meth);
	}
}