package com.prodezy.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.prodezy.rawmaterial.RawMaterialDr;
import com.prodezy.webservices.WebAPITester;

public class employeeSpinnerData {

    public ArrayList<String[]> listDept() {
    	
    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    	
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
                    mcTypes.add(new String[] {id,name} );
                   
                }
            }
            return mcTypes;
    }
    
    
public ArrayList<String[]> listGrade() {
    	
    	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
    	
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
                    mcTypes.add(new String[] {id,name} );
                   
                }
            }
            return mcTypes;
    }

public ArrayList<String[]> listRoles() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
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
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}

public ArrayList<String[]> listDesg() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
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
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}

public ArrayList<String[]> listSalary() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
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
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}


private int noOfRecords;
public List<EmployeeDR> list(int offeset, int recordperpage) {
   	
   	//ArrayList<String[]> mcTypes=new ArrayList<String[]>();
   	ArrayList<EmployeeDR> empdata=new ArrayList<>();
   	
        String addEmpAPICall = "employees";
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
                   
                   String  EmployeePK, EMP_NAME,EMP_NO,JOIN_DT, PHOTO,GENDER,DEPARTMENTID, ROLE,IS_USER,ADD_LOCAL,ADD_PERM,EDUCATION,DOB;
                   
                   EmployeePK=(emp.get ( "EmployeePK" ).toString ());
                   EMP_NAME=emp.get ( "EMP_NAME" ).toString ();
                   EMP_NO=emp.get ( "EMP_NO" ).toString ();
                   JOIN_DT=emp.get ( "JOIN_DT" ).toString ();
                   PHOTO=emp.get ( "PHOTO" ).toString ();
                   GENDER=emp.get ( "GENDER" ).toString ();
                   DEPARTMENTID=emp.get ( "DEPARTMENTID" ).toString ();
                   ROLE=emp.get ( "ROLE" ).toString ();
                   IS_USER=emp.get ( "IS_USER" ).toString ();
                   ADD_LOCAL=emp.get ( "ADD_LOCAL" ).toString ();
                   ADD_PERM=emp.get ( "ADD_PERM" ).toString ();
                  // EDUCATION=emp.get ( "EDUCATION" ).toString ();
                   //DOB=emp.get ( "DOB" ).toString ();

//                   RM_EC_NO=emp.get ( "RM_EC_NO" ).toString ();
//                   RM_CAS_NO=emp.get ( "RM_CAS_NO" ).toString ();
//                   GST_NO=emp.get ( "GST_NO" ).toString ();
//                   RM_CRIT=emp.get ( "RM_CRIT" ).toString ();
                   //machineTypes.add(new MachineDR(id,name));
                  // mcTypes.add(new String[] {EmployeePK, EMP_NAME,EMP_NO,JOIN_DT, PHOTO,GENDER,DEPARTMENTID, ROLE,IS_USER,ADD_LOCAL,ADD_PERM} );
                   empdata.add(new EmployeeDR (EmployeePK, EMP_NAME,EMP_NO,JOIN_DT, PHOTO,GENDER,DEPARTMENTID, ROLE,IS_USER,ADD_LOCAL,ADD_PERM));
                   //System.err.println("id"+id+"    name"+ name);
                   //machine.setMC_ID(id  );
                   //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
                   
                   
               }
               noOfRecords=empdata.size();
               this.noOfRecords=noOfRecords;
               
           }
           
           return empdata;
           
}
public int getNoOfRecords()
{
	return noOfRecords;
}
public ArrayList<String[]> listMachine() {
	
	ArrayList<String[]> mcTypes=new ArrayList<String[]>();
	
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
                mcTypes.add(new String[] {id,name} );
               
            }
        }
        return mcTypes;
}

}
