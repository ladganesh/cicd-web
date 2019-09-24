package com.prodezy.rawmaterial;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.webservices.WebAPITester;

public class RMspinnerData {
public ArrayList<String[]> listType() {
    	
    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    	
         String addEmpAPICall = "rmt";
            String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
          //  System.out.println("raw material data "+result2);
           
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
                    id=(emp.get ( "RMType_ID" ).toString ());
                    name=emp.get ( "RawMaterial" ).toString ();                   
                    mcTypes.add(new String[] {id,name} );
                   
                }
            }
            return mcTypes;
    }
public ArrayList<String[]> listCategory() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
     String addEmpAPICall = "category";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
        //System.out.println("category:"+result2);

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
                id=(emp.get ( "Category_ID" ).toString ());
                name=emp.get ( "Category" ).toString ();                   
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}

public ArrayList<String[]> listUnit() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
     String addEmpAPICall = "unitmeas";
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
                id=(emp.get ( "UOM_ID" ).toString ());
                name=emp.get ( "UOM" ).toString ();                   
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}

private int noOfRecords;
public List<RawMaterialDr> list(int offset, int noOfRecords) {
   	
   	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
   	ArrayList<RawMaterialDr> rawmaterial=new ArrayList<>();
   	
        String addEmpAPICall = "rawmaterials";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
       // System.out.println("result2==="+result2 );

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
                   
                   String RM_ID,RM_CTG, RM_NAME,RM_RATE,REORDER_LEVEL, RMM_UOM_ID,RM_CODE,Length,Width,Thickness,Density, RM_EC_NO,RM_CAS_NO, GST_NO,RM_CRIT;
                   
                   RM_ID=(emp.get ( "RM_ID" ).toString ());
                   RM_CTG=emp.get ( "RM_CTG" ).toString ();
                   RM_NAME=emp.get ( "RM_NAME" ).toString ();
                   RM_RATE=emp.get ( "RM_RATE" ).toString ();
                   REORDER_LEVEL=emp.get ( "REORDER_LEVEL" ).toString ();
                   RMM_UOM_ID=emp.get ( "RMM_UOM_ID" ).toString ();
                   RM_CODE=emp.get ( "RM_CODE" ).toString ();
                   Length=emp.get ( "length" ).toString ();
                   Width=emp.get ( "width" ).toString ();
                   Thickness=emp.get ( "thickness" ).toString ();
                   Density=emp.get ( "density" ).toString ();
                   RM_EC_NO=emp.get ( "RM_EC_NO" ).toString ();
                   RM_CAS_NO=emp.get ( "RM_CAS_NO" ).toString ();
                   GST_NO=emp.get ( "GST_NO" ).toString ();
                   RM_CRIT=emp.get ( "RM_CRIT" ).toString ();
                 // System.out.printf("length is "+Length);
                   //machineTypes.add(new MachineDR(id,name));
                   mcTypes.add(new String[] {RM_ID,RM_CTG, RM_NAME,RM_RATE,REORDER_LEVEL, RMM_UOM_ID,RM_CODE,Length,Width,Thickness,Density,RM_EC_NO,RM_CAS_NO,GST_NO,RM_CRIT} );
                   rawmaterial.add(new RawMaterialDr (RM_ID,RM_CTG, RM_NAME,RM_RATE,REORDER_LEVEL, RMM_UOM_ID,RM_CODE,Length,Width,Thickness,Density,RM_EC_NO,RM_CAS_NO,GST_NO,RM_CRIT));
                   //System.err.println("id"+id+"    name"+ name);
                   //machine.setMC_ID(id  );
                   //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
                   
                   
               }
               noOfRecords=rawmaterial.size();
               this.noOfRecords=noOfRecords;
               
           }
           
           return rawmaterial;
           
}
public int getNoOfRecords()
{
	return noOfRecords;
}
}
