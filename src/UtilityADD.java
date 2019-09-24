import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.prodezy.webservices.WebAPITester;

public class UtilityADD extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String utilityname=req.getParameter("utility_name");
        String value=req.getParameter("txtname");
        
        PrintWriter out = resp.getWriter();
        
        String addEmpAPICall = null;
        String result2 = null;
        JSONObject responseObject = null;

        if (  ! value.equalsIgnoreCase ( "" ) ) {

            switch ( utilityname ) {

                case "Grades":
                    // res = DB_Operations.insertIntoGradesMaster ( value );
                    //showDataInParticularList ( "grade" , "GradeName" );

                    try{
                        addEmpAPICall = "gradeadd?GradeName=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;

                case "Designations":
                    //res = DB_Operations.insertIntoDesignationsMaster ( value );
                    //showDataInParticularList ( "designation" , "DesgTitle" );

                    try{
                        addEmpAPICall = "designationsadd?DesgTitle=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;

                case "Salary Band":
                    //res = DB_Operations.insertIntoSalaryMaster ( value );
                    //showDataInParticularList ( "salaryband" , "SB_RANGE" );

                    try{
                        addEmpAPICall = "salarybandadd?SB_RANGE=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Nature of Employment":
                    //res = DB_Operations.insertIntoEmpNatureMaster ( value );
                    
                    

                    break;

                case "Unit of Measurement":
                    //res = DB_Operations.insertIntoUOMMaster ( value );
                    //showDataInParticularList ( "uom" , "UOM" );

                    try{
                        addEmpAPICall = "unitmeasadd?UOM=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Pack Size":
                    //res = DB_Operations.insertUtilitiesMaster ( "PackSize" , value );
                    //showDataInParticularList ( "pack_size" , "PackSize" );

                    try{
                        addEmpAPICall = "packsizeadd?PackSize=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Raw Material Type":
                    //res = DB_Operations.insertUtilitiesMaster ( "RawMaterial" , value );
                    //showDataInParticularList ( "raw_material_type" , "RawMaterialType" );

                   try{
                        addEmpAPICall = "rmtadd?RawMaterial=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Category":
                    //res = DB_Operations.insertUtilitiesMaster ( "Category" , value );
                    //showDataInParticularList ( "category" , "Category" );

                    try{
                        addEmpAPICall = "categoryadd?Category=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                         //   JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Segment":
                    // res = DB_Operations.insertUtilitiesMaster ( "Segment" , value );
                    //showDataInParticularList ( "segment" , "Segment" );

                    try{
                        addEmpAPICall = "segmentadd?Segment="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
               
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Industry":
                    //res = DB_Operations.insertUtilitiesMaster ( "Industry" , value );
                    //showDataInParticularList ( "industry" , "Industry" );

                     try{
                        addEmpAPICall = "industryadd?Industry=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Rejection Reason":
                    //res = DB_Operations.insertUtilitiesMaster ( "RejectionReason" , value );
                    //showDataInParticularList ( "rejectionReason" , "RejectionReasons" );

                     try{
                        addEmpAPICall = "rejreasonsadd?RR_DESC=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Document Types":
                    //res = DB_Operations.insertUtilitiesMaster ( "DocumentType" , value );
                    //showDataInParticularList ( "documentType" , "DocumentType" );
//   
//                        if(  jRadioButton1.isSelected ()      ){
//                            if( ! value.contains ( "Part - ")  )
//                                value = "Part - "+ value ;
//                        }else if( jRadioButton2.isSelected ()       ){
//                            if( ! value.contains ( "RM - ")  )
//                            value = "RM - "+ value ;
//                        }else if( jRadioButton3.isSelected ()       ){
//
//                        }

                     try{
                        addEmpAPICall = "rdmadd?RDM_NAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Departments":
                    //res = DB_Operations.insertUtilitiesMaster ( "Departments" , value );
                    // showDataInParticularList ( "departments" , "Departments" );

                    try{
                        addEmpAPICall = "departmentadd?DNAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Resources":
                    //res = DB_Operations.insertUtilitiesMaster ( "Resources" , value );
                    //showDataInParticularList ( "resources" , "Resources" );

                    try{
                        addEmpAPICall = "resourceadd?RSNAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "User Roles":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "userrolesadd?RoleName="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;
                    
                    case "TimeLoss Reasons":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "timeloss_reason_add?TLR_DESC="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;
                    
                    
                    case "Maintenance Types":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "maintenance_type_add?activity="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;
                    case "Machines Types":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "machinestype_add?MC_TYPE="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;
                case "Quality Raw Material":
                   try{
                        addEmpAPICall = "rmqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            ///JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    
                    break;
                case "Quality Process":
                   try{
                        addEmpAPICall = "procqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }
                    
                    
                    break;
                case "Quality Product":
                 try{
                        addEmpAPICall = "partqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    
                    break;
                    
                    //*******---------------
            }

        }else {
        	resp.sendRedirect("Utility.jsp");
        }
        
	}
	

}
