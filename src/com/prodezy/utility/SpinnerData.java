package com.prodezy.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.rawmaterial.RawMaterialDr;
import com.prodezy.webservices.WebAPITester;

public class SpinnerData {

    public ArrayList<UtilityDr> listDept() {
    	
    	ArrayList<UtilityDr> mcTypes=new ArrayList<>();
    	
         String addEmpAPICall = "department";
            String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
            //System.out.println("result2");

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
                    id=(emp.get ( "DID" ).toString ());
                    name=emp.get ( "DNAME" ).toString ();                   
                    mcTypes.add(new UtilityDr(id,name) );
                   
                }
            }
            return mcTypes;
    }
    
    
public ArrayList<UtilityDr> listGrade() {
    	
    	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
    	
         String addEmpAPICall = "grade";
            String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//            System.out.println("result2");

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
                    id=(emp.get ( "GradeID" ).toString ());
                    name=emp.get ( "GradeName" ).toString ();                   
                    mcTypes.add(new UtilityDr(id,name) );
                   
                }
            }
            return mcTypes;
    }

public ArrayList<UtilityDr> listRoles() {
	
	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
	
     String addEmpAPICall = "userroles";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//        System.out.println("result2");

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
                id=(emp.get ( "Role_ID" ).toString ());
                name=emp.get ( "RoleName" ).toString ();                   
                mcTypes.add(new UtilityDr (id,name) );
               
            }
        }
        return mcTypes;
}

public ArrayList<UtilityDr> listDesg() {
	
	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
	
     String addEmpAPICall = "designations";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//        System.out.println("result2");

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
                id=(emp.get ( "DesgID" ).toString ());
                name=emp.get ( "DesgTitle" ).toString ();                   
                mcTypes.add(new UtilityDr(id,name));
               
            }
        }
        return mcTypes;
}

public ArrayList<UtilityDr> listSalary() {
	
	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
	
     String addEmpAPICall = "salaryband";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//        System.out.println("result2=="+result2);

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
                id=(emp.get ( "SB_ID" ).toString ());
                name=emp.get ( "SB_RANGE" ).toString ();                   
                mcTypes.add(new UtilityDr(id,name)  );
               
            }
        }
        return mcTypes;
}


public ArrayList<UtilityDr> listMachine() {
	
	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
	
     String addEmpAPICall = "machinestypes";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//        System.out.println("result2=="+result2);

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
                mcTypes.add(new UtilityDr(id,name) );
               
            }
        }
        return mcTypes;
}

public ArrayList<UtilityDr> listuom() {
	
	ArrayList<UtilityDr> mcTypes=new ArrayList<UtilityDr>();
	
     String addEmpAPICall = "unitmeas";
        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//        System.out.println("result2=="+result2);

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
                mcTypes.add(new UtilityDr(id,name) );
               
            }
        }
        return mcTypes;
}
}
