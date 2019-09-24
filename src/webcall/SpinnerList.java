package webcall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.product_customer.ProductDr;
import com.prodezy.webservices.WebAPITester;

import model.ProcessMapModel;

public class SpinnerList 
{
 String result, addEmpAPICall;
	public ArrayList<String[]> getfgList()
	{
		ArrayList<String[]> fgList=new ArrayList<String[]>();
		  try {
		addEmpAPICall = "finishedgoods";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                    //  String name = ;
                     fgList.add(new String[] {emp.get ( "FG_ID" ).toString (),emp.get ( "FG_PART_NO" ).toString (),emp.get ( "FG_UOM_ID" ).toString ()} );
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	   System.out.println(fgList.get(1)[0]);
		//  System.out.println(empList.size());
		return fgList;
	}

	public ArrayList<String[]> getprocessList()
	{
		ArrayList<String[]> processList=new ArrayList<String[]>();
		  try {
		addEmpAPICall = "processes";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                    //  String name = ;
                     processList.add(new String[] {emp.get ( "PROCESS_ID" ).toString (),emp.get ( "PROCESS_NAME" ).toString ()} );
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	   System.out.println(processList.get(1)[0]);
		//  System.out.println(empList.size());
		return processList;
	}

	
	public ArrayList<String[]> getMachineList()
	{
		ArrayList<String[]> machList=new ArrayList<String[]>();
		  try {
		addEmpAPICall = "machinestypes";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                    //  String name = ;
                     machList.add(new String[] {emp.get ( "MC_TYPE_ID" ).toString (),emp.get ( "MC_TYPE" ).toString ()} );
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	   System.out.println(machList.get(1)[0]);
		//  System.out.println(empList.size());
		return machList;
	}

	public ArrayList<String[]> getDieList()
	{
		ArrayList<String[]> dieList=new ArrayList<String[]>();
		  try {
		addEmpAPICall = "die_tool";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                    //  String name = ;
                    dieList.add(new String[] {emp.get ( "DT_ID" ).toString (),emp.get ( "die_tool_no" ).toString ()} );
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	   System.out.println(dieList.get(1)[0]);
		//  System.out.println(empList.size());
		return dieList;
	}

	public ArrayList<ProcessMapModel> getProcessMapDataList(String fg_id)
	{
		ArrayList<ProcessMapModel> processMap=new ArrayList<>();
		  try {
			  System.out.println("AAAaa"+fg_id);
		addEmpAPICall = "processmachmaps";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                     ProcessMapModel model = new ProcessMapModel();
                     model.setMap_id(emp.get ( "FPM_ID" ).toString ());
                     model.setProcess_id(emp.get("PROCESS_NAME").toString());
                     model.setMachine_id(emp.get ( "MC_TYPE" ).toString ());
                     model.setDie_id(emp.get ( "die_tool_no" ).toString ());
                     model.setSetup_time(emp.get("SETUP_TIME").toString());
                     model.setCycle_time(emp.get("IDEAL_PROCESS_TIME").toString());
                     model.setRemark(emp.get("REMARKS").toString());
                     model.setOutput_hr(emp.get("TG_OPT_HR").toString());
                     model.setOutput_shift(emp.get("TG_OPT_SHT").toString());
                     model.setOutput_day(emp.get("TG_OPT_DAY").toString());
                     model.setUom_id(emp.get("UOM").toString());
                     model.setCost_rm(emp.get("VAL_AT_PROC").toString());
                     model.setRejection(emp.get("MAX_REJ_PERM").toString());
                     processMap.add(model);
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	  // System.out.println(processMap.get(1)[0]);
	System.out.println(processMap.size());
		return processMap;
	}

	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<String[]> getCustomerlist()
	{
		ArrayList<String[]> Customer=new ArrayList<String[]>();
		  try {
		addEmpAPICall = "customers";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

             
                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                    //  String name = ;
                     Customer.add(new String[] {emp.get ( "CUSTOMER_ID" ).toString (),emp.get ( "CUSTOMER_NAME" ).toString (),emp.get ( "CUST_ADDRESS" ).toString ()} );
                      
                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
	   System.out.println(Customer.get(1)[0]);
		//  System.out.println(empList.size());
		return Customer;
	}
	
	
	public ArrayList<ProductDr> getProduct_customer()
	{
		ArrayList<ProductDr>prod_cust=new ArrayList<ProductDr>();
		  try {
		addEmpAPICall = "customermaps";
		
		  result = WebAPITester.prepareWebCall(addEmpAPICall);
		  System.out.println("Result  "+result);
		
		  if( ! result.contains( "not found" ))          
		  {
			  HashMap<String, Object> map = new HashMap<String, Object>();
              JSONObject jObject = new JSONObject( result);
              Iterator<?> keys = jObject.keys();

              while( keys.hasNext() ){
                  String key = (String)keys.next();
                  Object value = jObject.get ( key ) ; 
                  map.put(key, value);
              }

              JSONObject st = (JSONObject) map.get ( "data" );
              JSONArray records = st.getJSONArray ( "records");

  			System.out.println("customermap= "+result);

                  for ( int i = 0 ; i < records.length () ; i ++ )
                  {

                     JSONObject emp = records.getJSONObject ( i);
                     
                     String M_FG_ID =emp.get ( "M_FG_ID" ).toString ();
                     String FG=emp.get ( "PART_NAME" ).toString ();
                     String M_CUST_ID =emp.get ( "M_CUST_ID" ).toString ();
                     String SALES_RATE=  emp.get ( "SALES_RATE" ).toString ();
                     String S_UOM_ID = emp.get ( "S_UOM_ID" ).toString ();
                     String customer_name=emp.get("CUSTOMER_NAME").toString();
                     String FG_C_ID=emp.get ( "FG_C_ID" ).toString ();
                     String uom=emp.get("UOM").toString();
                     prod_cust.add(new ProductDr (FG_C_ID,M_FG_ID,M_CUST_ID,SALES_RATE,S_UOM_ID,FG,customer_name,uom));

                  }
          
                 
              
       }
		 }catch (Exception e) {
			System.out.println(e);
		}
	
//.out.println(prod_cust.get(1)[0]);
		//  System.out.println(empList.size());
		return prod_cust;
	}
	
	
}
