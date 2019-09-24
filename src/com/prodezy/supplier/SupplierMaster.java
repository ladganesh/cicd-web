package com.prodezy.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.customer.ContactDR;
import com.prodezy.webservices.WebAPITester;

public class SupplierMaster {
	

private int noOfRecords;
public List<SupplierDr> list(int offset, int noOfRecords) {
   	
   	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
   	ArrayList<SupplierDr> supplier=new ArrayList<>();
   	
        String addEmpAPICall = "suppliers";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
      //  System.out.println("result2==="+result2 );

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
                   
                   String supp_id,	  supp_name,  supp_add, supp_cnt_ll,  supp_cnt_brd,  week_off,  gst_no, vendor_code, category, city, authorised    ;               
                   supp_id=(emp.get ( "SUPP_ID" ).toString ());
                   supp_name=emp.get ( "SUPP_NAME" ).toString ();
                   supp_cnt_ll=emp.get ( "SUPP_CNT_LL" ).toString ();
                   supp_cnt_brd=emp.get ( "SUPP_CNT_BRD" ).toString ();
                   week_off=emp.get ( "WEEK_OFF" ).toString ();
                   gst_no=emp.get ( "GST_NO" ).toString ();
                   vendor_code=emp.get ( "VENDOR_CODE" ).toString ();
                   category=emp.get ( "CATEGORY" ).toString ();
                   city=emp.get ( "CITY" ).toString ();
                   authorised=emp.get ( "AUTHORIZED_RM" ).toString ();
                   supp_add=emp.get ( "SUPP_ADD" ).toString ();
//                   RM_CAS_NO=emp.get ( "RM_CAS_NO" ).toString ();
//                   GST_NO=emp.get ( "GST_NO" ).toString ();
//                   RM_CRIT=emp.get ( "RM_CRIT" ).toString ();
//                  System.out.printf("length is "+Length);
                   //machineTypes.add(new MachineDR(id,name));
                   mcTypes.add(new String[] {supp_id,	  supp_name,  supp_add, supp_cnt_ll,  supp_cnt_brd,  week_off,  gst_no, vendor_code, category, city, authorised } );
                   supplier.add(new SupplierDr (supp_id,	  supp_name,  supp_add, supp_cnt_ll,  supp_cnt_brd,  week_off,  gst_no, vendor_code, category, city, authorised));
                   //System.err.println("id"+id+"    name"+ name);
                   //machine.setMC_ID(id  );
                   //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
                   
                   
               }
               noOfRecords=supplier.size();
               this.noOfRecords=noOfRecords;
               
           }
           
           return supplier;
           
}


public ArrayList<ContactDR> contact(int offset, int noOfRecords) {
	ArrayList<ContactDR> contacttable=new ArrayList<>();
	
    String addEmpAPICall = "contacts";
       String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
       System.out.printf("contact_details= "+result2);

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

public int getNoOfRecords()
{
	return noOfRecords;
}
}



