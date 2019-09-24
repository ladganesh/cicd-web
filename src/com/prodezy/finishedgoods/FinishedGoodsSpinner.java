package com.prodezy.finishedgoods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.finishedgoods.FinishedGoodsDR;
import com.prodezy.webservices.WebAPITester;

public class FinishedGoodsSpinner {
	

private int noOfRecords;
public List<FinishedGoodsDR> list(int offset, int noOfRecords) {
   	
   	//ArrayList<String[]> mcTypes=new ArrayList<String[]>();
   	ArrayList<FinishedGoodsDR> fgdata=new ArrayList<>();
   	
        String addEmpAPICall = "finishedgoods";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
      //  System.out.println("result2======"+result2);
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
                   
                   String  fgid,fgpartuniqueid,fgpartno,partname,salesrate,ntweight,grsweight,notes,prdcost,fguomid;
                   
                   
                   
           		fgid=emp.get ( "FG_ID" ).toString ();
           		fgpartuniqueid=emp.get ( "FG_PART_UNIQUE_ID" ).toString ();
           		fgpartno=emp.get ( "FG_PART_NO" ).toString ();
           		partname=emp.get ( "PART_NAME" ).toString ();
           		salesrate=emp.get ( "SALES_RATE" ).toString ();
           		ntweight=emp.get ( "NT_WGHT" ).toString ();
           		grsweight=emp.get ( "GRS_WGHT" ).toString ();
           		notes=emp.get ( "NOTES" ).toString ();
           		prdcost=emp.get ( "PROD_COST" ).toString ();
           		fguomid=emp.get ( "FG_UOM_ID" ).toString ();
 //                  ADD_PERM=emp.get ( "ADD_PERM" ).toString ();
//                   RM_EC_NO=emp.get ( "RM_EC_NO" ).toString ();
//                   RM_CAS_NO=emp.get ( "RM_CAS_NO" ).toString ();
//                   GST_NO=emp.get ( "GST_NO" ).toString ();
//                   RM_CRIT=emp.get ( "RM_CRIT" ).toString ();
                   //machineTypes.add(new MachineDR(id,name));
                  // mcTypes.add(new String[] {EmployeePK, EMP_NAME,EMP_NO,JOIN_DT, PHOTO,GENDER,DEPARTMENTID, ROLE,IS_USER,ADD_LOCAL,ADD_PERM} );
                   fgdata.add(new FinishedGoodsDR (fgid,fgpartuniqueid,fgpartno,partname,salesrate,ntweight,grsweight,notes,prdcost,fguomid));
                   //System.err.println("id"+id+"    name"+ name);
                   //machine.setMC_ID(id  );
                   //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
                   
                   
               }
               noOfRecords=fgdata.size();
               this.noOfRecords=noOfRecords;
               
           }
           
           return fgdata;
}
public int getNoOfRecords()
{
	return noOfRecords;
}
}



