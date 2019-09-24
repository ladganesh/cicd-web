
<%@page import="com.prodezy.rawmaterial.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Raw Material</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>  
 <body id="page-top">
   <%@include file="homeScreen.html" %>
    <!-- Begin Page Content -->
    <div class="container-fluid">
      <!-- Content Row -->
      <!-- Page Heading -->
	   <form method="post" action="RawMaterial" method="post">
	   <script>
		function isKeyPressed(event) {
  			var text = "";
 		    document.getElementById("demo1").innerHTML = text;
		}
		
</script> 
          <div>
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
    	      	<div class="card-header py-3">
        	          <h6 class="m-0 font-weight-bold text-primary">Raw Material</h6>
                </div>
                                <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                
                <div class="card-body">					
	 		    	<div class="row">
						<div class="col-lg-6 mb-4">
	  		          		<div>				      
	  		          			<br><br>      
				                <table align="center">				                
										<tr height=50>
											<td>
												<font color="red">*</font> RM Code
											</td>
											<td>
												<input type="text" id="rmcode" name="rmcode"  class="form-control form-control-user" required="required">
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> Type
											</td>
											<td>
												<select class="form-control form-control-user" name="type"id="type">
												<%   
   				
   				ArrayList<String[]> type = new RMspinnerData().listType();

   				for(int i = 0; i < type.size(); i++) {
   					
   					String id1=(String)type.get(i)[0];
   					String option1 = (String)type.get(i)[1];
   					
   						
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
												</select>
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> Category RM/Part
											</td>
											<td>
												<select class="form-control form-control-user" id="category" name="category">
													<%   
   				
   				ArrayList<String[]> rmt1 = new RMspinnerData().listCategory();

   				for(int i = 0; i < rmt1.size(); i++) {
   					
   					String id1=(String)rmt1.get(i)[0];
   					String option1 = (String)rmt1.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
												</select>
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> RM Name
											</td>
											<td>
												<input type="text" class="form-control form-control-user" name="rmname" id="rmname" required="required">
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> Unit Of<br>Measurement
											</td>
											<td>
												<select class="form-control form-control-user" name="measurement" id="measurement">
													<%   
   				
   				ArrayList<String[]> unit = new RMspinnerData().listUnit();

   				for(int i = 0; i < unit.size(); i++) {
   					
   					String id1=(String)unit.get(i)[0];
   					String option1 = (String)unit.get(i)[1];
   					
 	
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>					</select>
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> Reorder Level
											</td>
											<td>
												<input type="text" name="reorderlevel" id="reorderlevel"class="form-control form-control-user" required="required">
											</td>
										</tr>
										<tr height=50>
											<td>
												<font color="red">*</font> Rate per Unit
											</td>
											<td>
												<input type="text" name="rpu" id="rpu" class="form-control form-control-user" required="required">
											</td>
										</tr>
										<tr>
									<td><input type="hidden" name="id" class="form-control form-control-user" id="id" value="" size="45"/></td>
										</tr>
									</table>
									<br><br>
								<div align="center">
         							<input type="submit" class="btn btn-primary" value="Add_to_Master" name="Add_to_Master"/>     
         							<input type="submit" class="btn btn-primary" value="Edit_Record" name ="Add_to_Master"/>     
         							<input type="reset" class="btn btn-primary" value="Reset" /><br><br>           
         						    <input type="button" class="btn btn-primary" value="Cancel" />     
         						    <input type="button" class="btn btn-primary" value="Export to Excel" onclick=" exportToExcel('dataTable','RawMaterial_master')"/>     
         						    <input type="button" class="btn btn-primary" value="Delete" />
								</div>										
            		    	</div>
			            </div>

			            <div class="col-lg-6 mb-4">
            				<div class="card shadow mb-4">
                			<!-- Card Header - Dropdown -->
     				           <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  					<h6 class="m-0 font-weight-bold text-primary">Parameters</h6>                  
                				</div>
				                <!-- Card Body -->
                				<div class="card-body">
           							<table align="center">
										<tr>
											<td>
												<font color="red">*</font> Length
											</td>
											<td>
												<input type="text" id="length" name="length" class="form-control form-control-user" required="required">
											</td>
										<tr>
										<tr>
											<td>
												 <font color="red">*</font> Thickness
											</td>
											<td>
												<input type="text" id="thickness" name="thickness"class="form-control form-control-user" required="required">
											</td>
										<tr>
										<tr>
											<td>
												<font color="red">*</font> Width
											</td>
											<td>
												<input type="text" id="width" name="width" class="form-control form-control-user" required="required">
											</td>
										<tr>
										<tr>
											<td>
												<font color="red">*</font> Density
											</td>
											<td>
												<input type="text" id="density"  name="density" class="form-control form-control-user" required="required">
											</td>
										<tr>
           							</table>					
				                </div>
			              </div>
			              <div class="card shadow mb-4">
                			<!-- Card Header - Dropdown -->
     				           <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  					<h6 class="m-0 font-weight-bold text-primary">Other Info</h6>                  
                				</div>
				                <!-- Card Body -->
                				<div class="card-body">
           							<table align="center">
										<tr>
											<td>
												EC No
											</td>
											<td>
												<input type="text" id="ecno" class="form-control form-control-user">
											</td>
										<tr>
										<tr>
											<td>
												 CAS No
											</td>
											<td>
												<input type="text" id="casno" class="form-control form-control-user">
											</td>
										<tr>
										<tr>
											<td>
												GST No
											</td>
											<td>
												<input type="text" id="gstno" class="form-control form-control-user">
											</td>
										<tr>
										<tr>
											<td>
												Acceptance Criteria
											</td>
											<td>
												<textarea id="acceptance" class="form-control form-control-user" rows="2"></textarea>						
											</td>
										<tr>
           							</table>					
				                </div>
			              </div>
		            	</div>         
					<div class="card-body">	
						<div class="table-responsive">
						  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
							<tr>
								<th>RM Ctg</th>
								<th>RM Name</th>
								<th>RM Rate</th>
								<th>Reorder<br>Level</th>
								<th>UOM</th>
								<th>RM Code</th>
								<th>Length</th>		
								<th>Width</th>
								<th>Thickness</th>
								<th>Density</th>
								<th>id</th>
							</tr>
							</thead>
							<tbody>
							   		<c:forEach items="${rawmaterialdata}" var="data">
							   	
							<tr>
									
				                    <td>${data.RM_CTG}</td>
				                    <td>${data.RM_NAME}</td>
				                    <td>${data.RM_RATE}</td>
				                    <td>${data.REORDER_LEVEL}</td>
				                    <td>${data.RMM_UOM_ID}</td>
				                    <td>${data.RM_CODE}</td>
				                    <td>${data.length}</td>
				                    <td>${data.width}</td>
				                    <td>${data.thickness}</td>
				                    <td>${data.density}</td>
				                    <td>${data.RM_ID }    </td>	
                               
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
            <span aria-hidden="true">×</span>
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
  
  
  
  
 <!--  fething data in table-->
 
 
 <script type="text/javascript">

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				//console.log(rIndex);
				var flag=this.cells[10].innerHTML;
				<c:forEach items="${rawmaterialdata}" var="data">
				
					console.log(flag);
		
				if(flag==${data.RM_ID})
				{
					console.log("here     ............");
	
					document.getElementById("rmcode").value="${data.RM_CODE}";
					document.getElementById("category").value="${data.RM_CTG}";
					document.getElementById("rmname").value="${data.RM_NAME}";
				//	document.getElementById("UOM").value="${data.RMM_UOM_ID}";
					document.getElementById("reorderlevel").value="${data.REORDER_LEVEL}";
					document.getElementById("rpu").value="${data.RM_RATE}";
					document.getElementById("length").value="${data.length}";
					document.getElementById("thickness").value="${data.thickness}";
					document.getElementById("width").value="${data.width}";
					document.getElementById("density").value="${data.density}";
					document.getElementById("ecno").value="${data.RM_EC_NO}";
					document.getElementById("casno").value="${data.RM_CAS_NO}";
					document.getElementById("gstno").value="${data.GST_NO}";
					document.getElementById("acceptance").value="${data.RM_CRIT}";
					document.getElementById("id").value="${data.RM_ID}";

					
				
					
	
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