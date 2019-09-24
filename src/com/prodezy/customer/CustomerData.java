package com.prodezy.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.machine.MachineDR;
import com.prodezy.webservices.WebAPITester;

public class CustomerData {
	private int noOfRecords;  	
public ArrayList<String[]> list() {
	
    	ArrayList<String[]> existingcust=new ArrayList<String[]>();
    	
         String addEmpAPICall = "customers";
            String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
          //  System.out.println("result2");

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
                    id=(emp.get ( "CUSTOMER_ID" ).toString ());
                    name=emp.get ( "CUSTOMER_NAME" ).toString ();
                    //machineTypes.add(new MachineDR(id,name));
                    existingcust.add(new String[] {id,name} );
                    System.err.println("id"+id+"    name"+ name);
                    //machine.setMC_ID(id  );
                    //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

                }
            }
            return existingcust;
    }



public ArrayList<ContactDR> contact(int offset, int noOfRecords) {
	ArrayList<ContactDR> contacttable=new ArrayList<>();
	
    String addEmpAPICall = "contacts";
       String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
      // System.out.printf("contact_details= "+result2);

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
               
               //String MCH_ID="",MACHINE_NO="",MAKE="",OP_RATE_HR="",AVL_HRS="",DAVLHRS="";
         	  String CONT_PER_ID,CONT_EMAIL,CONT_NO,SUPP_ID,CONT_NAME,CUST_ID;

               
         	 CONT_PER_ID =(emp.get ( "CONT_PER_ID" ).toString ());
         	CONT_EMAIL=emp.get ( "CONT_EMAIL" ).toString ();
         	CONT_NO=emp.get ( "CONT_NO" ).toString ();
         	SUPP_ID=emp.get ( "SUPP_ID" ).toString ();
         	CONT_NAME=emp.get ( "CONT_NAME" ).toString ();
         	CUST_ID=emp.get ( "CUST_ID" ).toString ();
             
               //machineTypes.add(new MachineDR(id,name));
               //mcTypes.add(new String[] {MCH_ID,MACHINE_NO,MAKE,OP_RATE_HR,AVL_HRS,DAVLHRS} );
         	contacttable.add(new ContactDR (CONT_PER_ID,CONT_EMAIL,CONT_NO,CUST_ID,SUPP_ID,CONT_NAME));
               //System.err.println("id"+id+"    name"+ name);
               //machine.setMC_ID(id  );
               //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

           }
           noOfRecords=contacttable.size();
           this.noOfRecords=noOfRecords;
           
       }
       
       return contacttable;
	}

public ArrayList<customerDR> tablelist(int offset, int noOfRecords) {
	
	ArrayList<customerDR> customertableData=new ArrayList<>();
	
     String addEmpAPICall = "customers";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
      //  System.out.println("result2");

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
                
                //String MCH_ID="",MACHINE_NO="",MAKE="",OP_RATE_HR="",AVL_HRS="",DAVLHRS="";
                String CUST_ID;
                 String CUSTOMER_NAME;
                 String CITY;
                 String CUST_ADDRESS;
                 String CONTACT_LL;
                 String CONTACT_BRD;
                 String WEEKLY_OFF;
                 String GST_NO;
                 String PAYMENT_TERMS;
                 String OUR_VENDOR_CODE;
                 String CUST_CODE;
                 String PLANT_CODE;
                
                 CUST_ID=(emp.get ( "CUSTOMER_ID" ).toString ());
                 CUSTOMER_NAME=emp.get ( "CUSTOMER_NAME" ).toString ();
                 CITY=emp.get ( "CITY" ).toString ();
                 CUST_ADDRESS=emp.get ( "CUST_ADDRESS" ).toString ();
                 CONTACT_LL=emp.get ( "CONTACT_LL" ).toString ();
                 CONTACT_BRD=emp.get ( "CONTACT_BRD" ).toString ();
                 WEEKLY_OFF=emp.get ( "WEEKLY_OFF" ).toString ();
                 GST_NO=emp.get ( "GST_NO" ).toString ();
                 PAYMENT_TERMS=emp.get ( "PAYMENT_TERMS" ).toString ();
                 OUR_VENDOR_CODE=emp.get ( "OUR_VENDOR_CODE" ).toString ();
                 CUST_CODE=emp.get ( "CUST_CODE" ).toString ();
                 PLANT_CODE=emp.get ( "PLANT_CODE" ).toString ();
                 
                //machineTypes.add(new MachineDR(id,name));
                //mcTypes.add(new String[] {MCH_ID,MACHINE_NO,MAKE,OP_RATE_HR,AVL_HRS,DAVLHRS} );
                 customertableData.add(new customerDR (CUST_ID,CUSTOMER_NAME,CITY,CUST_ADDRESS,CONTACT_LL,CONTACT_BRD,WEEKLY_OFF,GST_NO,PAYMENT_TERMS,OUR_VENDOR_CODE,CUST_CODE,PLANT_CODE));
                //System.err.println("id"+id+"    name"+ name);
                //machine.setMC_ID(id  );
                //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 

            }
            noOfRecords=customertableData.size();
            this.noOfRecords=noOfRecords;
            
        }
        
        return customertableData;
	}
	public int getNoOfRecords()
	{	
	return noOfRecords;
	}
}
