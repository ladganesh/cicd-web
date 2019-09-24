<%@page import="com.prodezy.diemaster.*"%>
<%@page import="com.prodezy.employee.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prod-Ezy Die Master</title>
<!-- <link rel="stylesheet" type="text/css" href="MyStyle.css">
 --><link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
 
</head>
<body>
			<%@include file="homeScreen.html" %>
	<div class="container-fluid">

     <!-- Page Heading -->
    <form action="${pageContext.request.contextPath}/dieadd" method="post">
    <div>

              <!-- Circle Buttons -->
       <div class="card shadow mb-4" >
           <div class="card-header py-3" >
                  <h6 class="m-0 font-weight-bold text-primary">Die Master</h6>
                                  <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                  
           </div>

		<div class="card-body">
        <table align="center">
               
        <tr>
    			<td>Die (Tool)no</td><td><input type="text" class="form-control form-control-user" name="die_tool" id="die_tool" value="" size="35" required/></td>
    			<td>Preventive Maintenance<br>reminder Date</td><td><input type="date"  class="form-control form-control-user" name="prev_main_date" id="prev_main_date"required></td>
		</tr>
		<tr>
			    <td>Die (Tool)name</td><td><input type="text" class="form-control form-control-user" name="die_tool_name" id="die_tool_name" value="die_tool_name" size="35" required/></td>
			    <td>Date of Purchase</td><td><input type="date" class="form-control form-control-user" name="date_purchase" id="date_purchase" required></td>			    
		</tr>
		<tr>
				<td>Total Strokes<br>(Tool Life)</td><td><input type="text" class="form-control form-control-user" id="total_strokes" name="total_strokes" value="" size="35" required/></td>
				<td>Cost of Purchase</td><td><input type="text" class="form-control form-control-user" name="cost_purchase" id="cost_purchase" value="" size="35" required/></td>				
		</tr>
		<tr>
			<td>Maintenance Frequency<br>(Strokes)</td><td><input type="text" class="form-control form-control-user" id="main_freq" name="main_freq" value="" size="35" required/></td>
			<td>Shut Height<br>(mm)</td><td><input type="text" class="form-control form-control-user" name="shut_height" id="shut_height" value="" size="35" required/></td> 			
		</tr>
		<tr>
				<td>Machine</td><td><select id="ismachine" class="form-control form-control-user" name="ismachine" id="ismachine" onkeypress="isKeyPressed(event)">
   				<%
   					try{
   						
   						ArrayList<String[]> machine= new employeeSpinnerData().listMachine();

   		   				for(int i = 0; i < machine.size(); i++) {
   		   					
   		   					String id1=(String)machine.get(i)[0];
   		   					String option1 = (String)machine.get(i)[1];
   		   					
   						
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% }}catch(Exception a){a.getMessage();}%>
				</select></td><td>Owned by</td><td><input type="text" class="form-control form-control-user" name="owned_by" id="owned_by" value="" size="35"/></td>				                    
		</tr>
	
		<tr>
			<td>Reminder Count</td><td><input type="text"  required class="form-control form-control-user" name="rem_count" id="rem_count" value="" size="35"/></td>
			<td>Tonnage</td><td><input type="text" required  class="form-control form-control-user" name="tonnage" id="tonnage" value="" size="35"/></td>			
		</tr>
		<tr>
			<td>Maintenance Cost</td><td><input type="text" required class="form-control form-control-user" id="cost_maintenance" name="cost_maintenance" value="" size="35"/></td>
			<td>Dimensions</td><td><input type="text" required class="form-control form-control-user" name="dimensions" id="dimensions"value="" size="35"/></td>			
		</tr>
		<tr>
			<td>Date Wise<br>Maintenance</td><td><input type="date" class="form-control form-control-user" name="Datepicker" id="Datepicker"></td>
		</tr>    
		<tr>
			<td><input type="hidden" class="form-control form-control-user" id="die_id" name="die_id"></td>
		</tr>   

</table>
<div align ="center">
	         <p id="demo" style="color:red;">${param.message}</p>
         <input type="submit" class="btn btn-primary" name="Add_to_Die_Master" value="Add_to_Die_Master" />        
         <input type="submit" class="btn btn-primary" id="btnexcel" name="Export_to_Excel" value="Export_to_Excel" onClick="exportToExcel('dataTable','Die_Master')" />    
         <input type="submit" class="btn btn-primary" name="Create_QR_code" value="Create_QR_code" />    
         <input type="reset" class="btn btn-primary" value="Clear" />      
         <input type="submit" class="btn btn-primary" name="Cancel" value="Cancel" />    
         <input type="submit" class="btn btn-primary" name="Add_to_Die_Master" value="Edit_record" />          
</div>
</div>

<div class="table-responsive">

 <div class="card-body">

<div class="table-responsive">

  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
	<tr>
        <th style ="visibility:hidden;"></td> 
		
		<th>Die_tool_no</th>
		<th>Die_name</th>
		<th>Total_strokes</th>
		<th>Maintenance</th>
		<th>Cost_Maintenance</th>
		<th>Remainder_count</th>		
		<th>Cost_Purchase</th>
		<th>Owner_id</th>
		<th>Shut_height</th>
		<th>Tonnage</th>
		<th>Dimensions</th>		

	</tr>
	</thead>
	<tbody>
   		 <c:forEach items="${dielist}" var="data">
         		<tr>
         		<td style ="visibility:hidden;">${data.id}</td> 
         		    <td> ${data.no}</td>
                    <td>${data.name}</td>
                    <td>${data.total_strokes}</td>
                    <td>${data.cost_maintenance}</td>
                    <td>${data.maintenance_stroke}</td>
                    <td>${data.reminder_count}</td>
                    <td>${data.cost_purchase}</td>
                    <td>${data.owner_id}</td>
                    <td>${data.shut_id}</td>
                    <td>${data.tonnage}</td>
                    <td>${data.dimensions}</td>   
                  
                     
                               
                </tr>
    </c:forEach>	 		
   	</tbody>	
   	</table>
 
   		</div>
 


<script type="text/javascript">

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				//console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${dielist}" var="data">
				
					console.log(flag);
		
				if(flag==${data.id})
				{
/* 					console.log("here     ............");
 */				
					
						document.getElementById("die_tool").value="${data.no}";
						document.getElementById("die_tool_name").value="${data.name}";
		  				document.getElementById("total_strokes").value="${data.total_strokes}";
		  				document.getElementById("cost_maintenance").value="${data.cost_maintenance}";
		  				document.getElementById("main_freq").value="${data.maintenance_stroke}";
		  				document.getElementById("rem_count").value="${data.reminder_count}";
		  				document.getElementById("Datepicker").value="${data.date_maintenance}";
			  			document.getElementById("owned_by").value="${data.owner_id}";
			  			document.getElementById("shut_height").value="${data.shut_id}";
			  			document.getElementById("tonnage").value="${data.tonnage}";
			  			document.getElementById("dimensions").value="${data.dimensions}";
			  			document.getElementById("cost_purchase").value="${data.cost_purchase}";
			  			document.getElementById("die_id").value="${data.id}";



	
				}
				</c:forEach>
		};
	}  
	
		


	
 </script>

      <!-- Footer -->
		<%@include file="footer.html" %>
      <!-- End of Footer -->  
</div>
</div>

</div>



</form>
</div>
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