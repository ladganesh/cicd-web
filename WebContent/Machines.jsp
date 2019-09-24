
<%@page import="java.util.List"%>
<%@page import="com.prodezy.machine.*"%>
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

  <title>ProdEzy -Machine Master</title>

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
<body>
			<%@include file="homeScreen.html" %>
<div class="container-fluid">

     <!-- Page Heading -->
	<form action="machineADD" method="post" enctype="multipart/form-data">
    <div>

              <!-- Circle Buttons -->
       <div class="card shadow mb-4" >
           <div class="card-header py-3" >
                  <h6 class="m-0 font-weight-bold text-primary">Machines</h6>
           </div>
                <p id="demo1" style="color:red;" align="center">${errormessage}</p>

		<div class="card-body">
			
			<table align="center">
            <tr height=50>
    			<td>Machine Name/No</td> <td><input type="text" class="form-control form-control-user" name="machineno" value="" size="45" id="machineno" onkeypress="isKeyPressed(event)"/></td>	
		    </tr>
			<tr height=50>
				<td>Make</td><td><input type="text" class="form-control form-control-user" name="make" value="" size="45" id="make" onkeypress="isKeyPressed(event)"/></td>
			</tr>
			<tr height=50>
				<td>Machine Type</td><td><select id="ismachinetype" class="form-control form-control-user" name="ismachinetype" onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> machineTypes = new MachineTypeload().list();

   				for(int i = 0; i < machineTypes.size(); i++) {
   					
   					String id1=(String)machineTypes.get(i)[0];
   					String option1 = (String)machineTypes.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select></td>  
			</tr>
			<tr height=50>				
				<td>Operating Rate/Hr</td><td><input type="text" class="form-control form-control-user" name="operating" value="" size="45" id="operating" onkeypress="isKeyPressed(event)"/></td>
			</tr>
			<tr height=50>

				<td>Availability in Hrs</td><td><input type="text" class="form-control form-control-user" name="available" value="" size="45" id="available" onkeypress="isKeyPressed(event)"/></td>
			</tr>
			<tr height=50>
				<td>Designed Availability<br>in hrs</td><td><input type="text" class="form-control form-control-user" name="desig_available" value="" size="45" id="desig_available" onkeypress="isKeyPressed(event)"/></td>
			</tr>
			<tr height=50>
				<td>Maintenance Rating</td><td><input type="text" class="form-control form-control-user" name="maintenance_rating" value="" size="45" id="maintenance_rating" onkeypress="isKeyPressed(event)"/></td>
	        </tr>
	        <tr height=50>
			<td><input type="hidden" class="form-control form-control-user" name="id" value="" size="45" id="id" /></td>
			</tr>
</table>

<p id="demo1" style="color:red;" align="center">${param.message}</p>
<table align="center">
	<tr>
         <td><input type="submit"  class="btn btn-primary" name="Add_to_Machine_Master" value="Add_to_Machine_Master" /></td>
         <td><input type="submit"  class="btn btn-primary" id="btnexcel" name="Add_to_Machine_Master" value="Export_to_Excel" onclick="exportToExcel('dataTable','machine_excel')"/>
         </td><td><input type="submit"  class="btn btn-primary" name="Add_to_Machine_Master" value="Create_QR_code" /></td>
         <td><input type="reset"  class="btn btn-primary" value="Clear" /></td>
         <td><input type="submit"  class="btn btn-primary" name="Cancel" value="Cancel" /></td>
         <td><input type="submit"  class="btn btn-primary" name="edit_record" value="edit_record"/></td>
       	 <td><input type="submit"  class="btn btn-primary" name="Delete_Record" value="Delete_Record"/></td>
     
        <td><input type="file" name="excelfile" id="excelfile">
        <input type="submit"  class="btn btn-primary" name="Import_to_Excel" value="Import_to_Excel" /></td>
         
	</tr>
</table>
<div class="card-body">
<div class="table-responsive">
  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
	<th>MCH_ID</th>
	<th>MACHINE_NO</th>
	<th>MAKE</th>
	<th>OP_RATE_HR</th>
	<th>AVL_HRS</th>
	<th>DAVLHRS</th>
</tr>
</thead>
<!-- <tfoot>
<tr>
	<th>MCH_ID</th>
	<th>MACHINE_NO</th>
	<th>MAKE</th>
	<th>OP_RATE_HR</th>
	<th>AVL_HRS</th>
	<th>DAVLHRS</th>
</tr>
</tfoot> -->
<tbody>
	<c:forEach items="${machineList}" var="data">
	
	<tr>
	               <td>${data.MCH_ID}</td>
                <td>${data.MACHINE_NO}</td>
                <td>${data.MAKE}</td>
                <td>${data.OP_RATE_HR}</td>
                <td>${data.AVL_HRS}</td>
                <td>${data.DAVLHRS}</td>
	</tr>
	
	</c:forEach>
</tbody>
</table>
</div>
</div>
 </div>
      <!-- End of Main Content -->

      <!-- Footer -->
		<%@include file="footer.html" %>
      <!-- End of Footer -->      
    </div>
   </div>

    <!-- End of Content Wrapper -->

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

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${machineList}" var="data">
				
					console.log(flag);
		
				if(flag==${data.MCH_ID})
				{
					console.log("here     ............");
	
					   document.getElementById('id').value="${data.MCH_ID}";
			           document.getElementById('machineno').value="${data.MACHINE_NO}";
			           document.getElementById('make').value="${data.MAKE}";
			           document.getElementById('operating').value="${data.OP_RATE_HR}";
			           document.getElementById('available').value="${data.AVL_HRS}";
			           document.getElementById('desig_available').value="${data.DAVLHRS}";
			   						
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