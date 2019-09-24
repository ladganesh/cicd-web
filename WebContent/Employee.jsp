
<%@page import="com.prodezy.employee.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%-- <%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
 --%><html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Employee</title>

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
         <form action="EmployeeAdd" method="post">
           <div>
				<div class="card shadow mb-4" >
           			<div class="card-header py-3" >
                  		<h6 class="m-0 font-weight-bold text-primary">Employee Master</h6>
           			</div>
           			  <p id="demo1" style="color:red;" align="center">${errormessage}</p>
           			
				<div class="card-body">
			   <table align="center">
			   <tr>
			   		<td>
						Employee No
			   		</td>
			   		<td>
						<input type="text" class="form-control form-control-user" name="empno" id="empno" value="" size="45"/>			   		
			   		</td>
			   		<td>
			   			Employee Name			   			
			   		</td>
			   		<td>
						<input type="text" class="form-control form-control-user" name="name" id="name" value="" size="45"/>			   		
			   		</td>
			   </tr>
			   <tr>
			   		<td>
						Department 			   		
			   		</td>
				<td><select id="isdept" class="form-control form-control-user" name="isdept"  onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> empdept = new employeeSpinnerData().listDept();

   				for(int i = 0; i < empdept.size(); i++) {
   					
   					String id1=(String)empdept.get(i)[0];
   					String option1 = (String)empdept.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select>
				</td>  
			   		<td>
						Grade
			   		</td>
			   		<td><select id="isgrade" class="form-control form-control-user" name="isgrade" onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> empgrade = new employeeSpinnerData().listGrade();

   				for(int i = 0; i < empgrade.size(); i++) {
   					
   					String id1=(String)empgrade.get(i)[0];
   					String option1 = (String)empgrade.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select>
				</td>  
			   </tr>
			   <tr>
			   		<td>
						Role 			   		
			   		</td>
			   		<td><select id="isrole" class="form-control form-control-user" name="isrole" onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> emprole = new employeeSpinnerData().listRoles();

   				for(int i = 0; i < emprole.size(); i++) {
   					
   					String id1=(String)emprole.get(i)[0];
   					String option1 = (String)emprole.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select>
				</td>  
			   		<td>
						Designation 			   		
			   		</td>
			   		<td><select id="isdesg" class="form-control form-control-user" name="isdesg" onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> empDesg = new employeeSpinnerData().listDesg();

   				for(int i = 0; i < empDesg.size(); i++) {
   					
   					String id1=(String)empDesg.get(i)[0];
   					String option1 = (String)empDesg.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select>
				</td>  
			   </tr>
			    <tr>
			   		<td>
						Date of Birth
			   		</td>
			   		<td>
						 <input type="date" name="doj" id="doj"  size="45" class="form-control form-control-user" />
			   		</td>
			   		<td>
						Gender
			   		</td>
			   		<td>
						<select name="gender" id="gender" class="form-control form-control-user">
							<option>Male</option>
							<option>Female</option>
						</select>
			   		</td>
			   </tr>
			   
			   <tr>
			   		<td>
						Date of Joining
			   		</td>
			   		<td>
						 <input type="date" name="dob" id ="dob" size="45" class="form-control form-control-user" />
			   		</td>
			   		<td>
						Joining Skill Level
			   		</td>
			   		<td>
						<select name="joiningskill" id="joiningskill" class="form-control form-control-user">
							<option>Beginner</option>
							<option>Intermediate</option>
							<option>Proficient</option>
							<option>Expert</option>
						</select>
			   		</td>
			   </tr>
			   <tr>
			   		<td>
						Current Skill Level
			   		</td>

			   		<td>
						<select name="currentskill" id=" currentskill" class="form-control form-control-user">
							<option>Beginner</option>
							<option>Intermediate</option>
							<option>Proficient</option>
							<option>Expert</option>
						</select>			   		
			   		</td>
			   		<td>
						Authorized Skill
			   		</td>
			   		<td>
						<select name="authorizedskill"  id="authorizedskill " class="form-control form-control-user">
							<option>Beginner</option>
							<option>Intermediate</option>
							<option>Proficient</option>
							<option>Expert</option>
						</select>			   		
			   		</td>
			   </tr>
			   <tr>
			   		<td>
						Education	   		
			   		</td>
			   		<td>
						<select name="education"  id="education" class="form-control form-control-user">
							<option>SSC</option>
							<option>HSC</option>
							<option>Bachelor</option>
							<option>Master</option>
							<option>PHD</option>
						</select>		
			   		</td>
			   		<td>
						Salary Band			   		
			   		</td>
			   		<td><select id="issalary" class="form-control form-control-user" name="issalary" onkeypress="isKeyPressed(event)" >
   				<%   
   				
   				ArrayList<String[]> empSalary = new employeeSpinnerData().listSalary();

   				for(int i = 0; i < empSalary.size(); i++) {
   					
   					String id1=(String)empSalary.get(i)[0];
   					String option1 = (String)empSalary.get(i)[1];
   					
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>
				</select>
				</td>  
			   </tr>
			   <tr>
			   		<td>
						Nature Of Employement
			   		</td>
			   		<td>
						<select name="nature" id="nature"  class="form-control form-control-user">
							<option>Permanent</option>
							<option>On Contract</option>
							<option>Daily Wages</option>
						</select>
			   		</td>
			   		<td>
						Pan Card no			   		
			   		</td>
			   		<td>
						<input type="text" name="pancard" id="pancard" value="pancard" Size="45" class="form-control form-control-user"/>
			   		</td>
			   </tr>
			  
			   <tr>
			   		<td>
						Local Address			   		
			   		</td>
			   		<td>
						<textarea name="laddress" id="laddress" rows="4" cols="35" class="form-control form-control-user"></textarea>
			   		</td>
			   		<td>
						Permanent Address
			   		</td>
			   		<td>
						<textarea name="paddress" id="paddress" rows="4" cols="35" class="form-control form-control-user"></textarea>
			   		</td>

			   </tr>
			   <tr>
			   		<td>
						Photo
			   		</td>
			   		
			   		<td>
						<img src="" id="image" width="50" height="60"/> 
						<input type="file" name="photo" id="myFile" value="" onchange="previewFile()"/>			   		
			   		</td>

			   </tr>
				<tr>
									<td><input type="hidden" name="employeepk" class="form-control form-control-user" id="employeepk" value="" size="45"/></td>
								</tr>
			  </table>

					<div align ="center">
          				<input type="submit" class="btn btn-primary" value="Add_to_Employee" name="Add_to_Employee" />          
          				<input type="button" class="btn btn-primary" value="Export to Excel" onclick=" exportToExcel('dataTable','Employee_master' )"/>                   
          				<input type="reset" class="btn btn-primary" value="Clear" />                    
          				<input type="submit" class="btn btn-primary" value="Edit_record" name="Add_to_Employee"  />     
          				<input type="button" class="btn btn-primary" value="Cancel" />
					</div>
					<div class="card-body">

<div class="table-responsive">

  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
	<tr>
			<td style="visibility:hidden;"> </td>
	
 		<th>Name</th>
		<th>Emp No</th>
		<th>Joint Date</th>
		<th>Photo</th>
		<th>Gender</th>
		<th>Department</th>
		<th>Role</th>		
		<th>Is user</th>
		<th>Address local</th>
		<th>Address Permanent</th>
		
			
	</tr>
	</thead>
	
   	
   	<tbody>
   		   		<c:forEach items="${Emplist}" var="data">
   		
         		<tr>
         		                     <td style="visibility:hidden;">${data.EMPLOYEEPK} </td>
         		
     	            <td>${data.EMP_NAME}</td>
                    <td>${data.EMP_NO}</td>
                    <td>${data.JOIN_DT}</td>
                    <td>${data.PHOTO}</td>
                    <td>${data.GENDER}</td>
                    <td>${data.DEPARTMENTID}</td>
                    <td>${data.ROLE}</td>
                    <td>${data.IS_USER}</td>
                    <td>${data.ADD_LOCAL}</td>
                    <td>${data.ADD_PERM}</td>
                         
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
	    </form>
    </div>    
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
  <script type="text/javascript">

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				//console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${Emplist}" var="data">
				
					console.log(flag);
		
				if(flag==${data.EMPLOYEEPK})
				{
/* 					console.log("here     ............");
 */				
					
						document.getElementById("employeepk").value="${data.EMPLOYEEPK}";
						document.getElementById("empno").value="${data.EMP_NO}";
		  				document.getElementById("name").value="${data.EMP_NAME}";
		  				document.getElementById("isdept").value="${data.DEPARTMENTID}";
		  				document.getElementById("laddress").value="${data.ADD_LOCAL}";
		  				document.getElementById("isrole").value="${data.ROLE}";
		  				document.getElementById("gender").value="${data.GENDER}";
			  			document.getElementById("paddress").value="${data.ADD_PERM}";
			  			document.getElementById("education").value="${data.EDUCATION}";
			  			document.getElementById("dob").value="${data.DOB}";

	
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
 