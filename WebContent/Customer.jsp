
<%@page import="com.prodezy.customer.customerDR"%>
<%@page import="com.prodezy.customer.CustomerData"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Customer</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

	<script>
		function isKeyPressed(event) {
  			var text = "";
 		    document.getElementById("demo1").innerHTML = text;
		}
		
	</script>  
</head>
    <body id="page-top">
        <%@include file="homeScreen.html" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
	      <form method="post" action="CustomerADD" >
          <div >

            <div class=s>

              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Customer</h6>
                </div>
                                <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                
                <div class="card-body">

 		         <div class="row">
	
    		        <!-- Customer Detail form -->
            		<div class="col-xl-8 col-lg-7">
	            		<div>
				            <table align="center">
					            <tr>
        				          <td>Existing Customer</td><td><select id="iscustomer" class="form-control form-control-user" name="iscustomer" onkeypress="isKeyPressed(event)">
					   				<option> <%="Select Existing Customer" %> </option>
   										<%   try{
   											ArrayList<String[]> customerData = new CustomerData().list();
   				
   											for(int i = 0; i < customerData.size(); i++) {
   					
							   					String id1=(String)customerData.get(i)[0];
							   					String option1 = (String)customerData.get(i)[1];
   					
   										%>   				
						   				<option value="<%= id1 %>"><%= option1 %> </option>
						   				<% }}catch(Exception a){a.getMessage();} %>
									</select></td>
								</tr>       
								<tr>
									<td>Name</td><td><input type="text" value="" class="form-control form-control-user" name="name1" size="45" id="name1"onkeypress="isKeyPressed(event)"/></td>
								</tr>
								<tr>
									<td>Address</td><td><textarea name="addr" class="form-control form-control-user" value="" rows="4" cols="35" id="addr"onkeypress="isKeyPressed(event)""></textarea></td>
								</tr>
								<tr>
									<td>City</td><td><select name="city" id="city"  class="form-control form-control-user" value="" required>
					                    <option>Mumbai</option>
                    					<option>Nashik</option>
                    					<option>Pune</option>
                    					<option>Nagpur</option>
                    					<option>Thane</option>
                    					<option>Aurangabad</option>
                    				</select></td>
								</tr>
								<tr>
									<td>Customer Code</td><td><input type="text" class="form-control form-control-user" value="" name="cust_code" size="45" id="cust_code" onkeypress="isKeyPressed(event)"/></td>
								</tr>
								<tr>
									<td>Plant Code</td><td><input type="text" class="form-control form-control-user" value="" name="plant_code" size="45" id="plant_code" onkeypress="isKeyPressed(event)"/></td>
								</tr>
								<tr>
										<td>Contact</td>
								</tr>
								<tr>
										<td>   LL</td><td><input type="text" class="form-control form-control-user" name="contll" value="" size="45" minlength="6" maxlength="10" id="contll"/></td>
								</tr>
								<tr>
										<td>   Board</td><td><input type="text" class="form-control form-control-user" name="contboard" value="" size="45" minlength="6" maxlength="10" id="contboard"/></td>
								</tr>
								<tr>
									<td>Weekly Off</td> <td> <select name="weeklyoff" class="form-control form-control-user" value=""id="weeklyoff">
				                        <option>Sunday</option>
                				        <option>Monday</option>
                      					<option>Tuesday</option>
  					                    <option>Wednesday</option>
                    				    <option>Thursday</option>
          					            <option>Friday</option>
   					                    <option>Saturday</option>
    	                			    </select></td>
								</tr>
								<tr>
									<td>GST No</td><td><input type="text" class="form-control form-control-user" name="gstno" value="" size="45" id="gstno"/></td>
								</tr>
								<tr>
									<td>Our Vender Code</td><td><input type="text" class="form-control form-control-user" name="vender_code" value="" size="45" id="vendor_code"/></td>
								</tr>
								<tr>
									<td>Credit period</td><td><input type="text" class="form-control form-control-user" name="credit_period"  value="" size="45" id="credit_period"/></td>
								</tr>
								<tr>
								<td><input type="hidden" class="form-control form-control-user" name="id"  value="" size="45" id="id"/></td>
								</tr>
					    </table>         
                	</div>
            </div>

            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Contact Person</h6>                  
                </div>
                <!-- Card Body -->
                <div class="card-body">
            Person 1
            <table align="center">

        	
			<tr>
     	       <td>Name</td><td><input type="text" id="person1" name="person1" class="form-control form-control-user" value=""/></td>
			</tr>
			<tr>                
				<td>Contact No</td><td><input type="text" id="contact1" class="form-control form-control-user" name="contact1" value="" /></td>
			</tr>
			<tr>
				<td>Email</td><td><input type="text" id="email1" class="form-control form-control-user" name="email1" value="" /></td>
			</tr>
		   </table>
			<br>
			Person 2
		   <table align="center">
     		<tr>
				<td>Name</td><td><input type="text" name="person2" id="person2" class="form-control form-control-user" value="" /></td>
			</tr>
			<tr>
				<td>Contact No</td><td><input type="text" id="contact2" class="form-control form-control-user" name="contact2" value=""/></td>
			</tr>
			<tr>
				<td>Email</td><td><input type="text" id="email2" class="form-control form-control-user" name="email2" value="" /></td>
			</tr>
		   </table>
		   <br>
		   Person 3		   
		   <table align="center">
			<tr>
	            <td>Name</td><td><input type="text" id="person3" name="person3" class="form-control form-control-user" value="" /></td>
			</tr>
			<tr>
				<td>Contact No</td><td><input type="text" id="contact3" class="form-control form-control-user" name="contact3" value="" /></td>
			</tr>
			<tr>
				<td>Email</td><td><input type="text" id="email3" name="email3" class="form-control form-control-user"  value="" /></td>
			</tr>
 </table>            					
                </div>
              </div>
            </div>         
          </div>      
          <br>
<div align="center">
         <input type="submit" class="btn btn-primary" name="Add_to_Master" value="Add_to_Master" />        
         <input type="submit" class="btn btn-primary" id="btnexcel" name="Export_to_Excel" value="Export_to_Excel" onclick="exportToExcel('dataTable','Customer_Master')" />    
         <input type="reset" class="btn btn-primary" value="Clear" />      
         <input type="submit" class="btn btn-primary" name="Cancel" value="Cancel" />   
         <input type="submit" class="btn btn-primary" name="Add_to_Master" value="Edit_record" />
</div>
<div class="card-body">

<div class="table-responsive">

  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
	<tr>
		<th>CUST_ID</th>
		<th>CUSTOMER_NAME</th>
		<th>CITY</th>
		<th>CUST_ADDRESS</th>
		<th>CONTACT_LL</th>
		<th>CONTACT_BRD</th>
		<th>WEEKLY_OFF</th>		
		<th>GST_NO</th>
		<th>PAYMENT_TERMS</th>
		<th>OUR_VENDOR_CODE</th>
		<th>CUST_CODE</th>
		<th>PLANT_CODE</th>		
	</tr>
	</thead>
	<tbody>
   	<c:forEach items="${customerList}" var="data">
         		<tr>
                    <td>${data.CUST_ID}</td>
                    <td>${data.CUSTOMER_NAME}</td>
                    <td>${data.CITY}</td>
                    <td>${data.CUST_ADDRESS}</td>
                    <td>${data.CONTACT_LL}</td>
                    <td>${data.CONTACT_BRD}</td>
                    <td>${data.WEEKLY_OFF}</td>
                    <td>${data.GST_NO}</td>
                    <td>${data.PAYMENT_TERMS}</td>
                    <td>${data.OUR_VENDOR_CODE}</td>
                    <td>${data.CUST_CODE}</td>
                    <td>${data.PLANT_CODE}</td>                    
                </tr>
    </c:forEach>			
   	</tbody>	
   	</table>
   		</div>
</div>
</div>
      <!-- Footer -->
		<%@include file="footer.html" %>
      <!-- End of Footer --> 
</div>
  
</div>   	
</div>	
</form>

</div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">Ã</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
	
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
  
  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

<script type="text/javascript">
 
    
var temp;
    var  table=document.getElementById('dataTable'),rIndex;
    for(var i=0;i<table.rows.length;i++)
    	{
    		table.rows[i].onclick=function()
    		{
    				
    				rIndex=this.rowIndex;
    			
    				//console.log(rIndex);
    				var flag=this.cells[0].innerHTML;
    				var flag2;
    				<c:forEach items="${customerList}" var="data">
    				
    					console.log(flag);
    		
    				if(flag==${data.CUST_ID})
    				{
    /* 					console.log("here     ............");
     */	

     					document.getElementById("id").value="${data.CUST_ID}";
    					document.getElementById("name1").value="${data.CUSTOMER_NAME}";
    					document.getElementById("addr").value="${data.CUST_ADDRESS}";
    					document.getElementById("contll").value="${data.CONTACT_LL}";
    					document.getElementById("contboard").value="${data.CONTACT_BRD}";
    					document.getElementById("vendor_code").value="${data.OUR_VENDOR_CODE}";
    					document.getElementById("plant_code").value="${data.PLANT_CODE}";
    					document.getElementById("cust_code").value="${data.CUST_CODE}";
    					document.getElementById("city").value="${data.CITY}";

    					document.getElementById("gstno").value="${data.GST_NO}";
    					document.getElementById("weeklyoff").value="${data.WEEKLY_OFF}";
    					
                             	
    				}
    				</c:forEach>
    				
    				
    				
    				var flag2=this.cells[0].innerHTML;

    			<c:forEach items="${contactlist}" var="data">
    				
					console.log(flag2);
					console.log(${data.CUST_ID});

		
				if(flag2==${data.CUST_ID})
				{
	

					document.getElementById("person1").value="${data.CONT_NAME}";
					document.getElementById("email1").value="${data.CONT_EMAIL}";
					document.getElementById("contact1").value="${data.CONT_NO}";
				
				}
				</c:forEach>
				
				
	    				
    				
    				
    		};
    	}  
    	
    		

    
    
    
    
 </script>
 <script type="text/javascript">
function exportToExcel(tableID, filename = ''){
    var downloadurl;
    var dataFileType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTMLData = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'export_excel_data.xls';
    
    // Create download link element
    downloadurl = document.createElement("a");
    
    document.body.appendChild(downloadurl);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTMLData], {
            type: dataFileType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadurl.href = 'data:' + dataFileType + ', ' + tableHTMLData;
    
        // Setting the file name
        downloadurl.download = filename;
        
        //triggering the function
        downloadurl.click();
    }
}
 
</script>
</body>
</html>
