<%@page import="webcall.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.*" %>
<%@page import="model.*" %>
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

  <title>Prod-Ezy Process Master</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="css/duration-picker.css" rel="stylesheet">
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="js/duration-picker.js"></script>
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

	<script>

		function removeRequired(form)
		{
		    $.each(form, function(key, value)
		    		{
		        if ( value.hasAttribute("required"))
		        {

		            value.removeAttribute("required");
		        }
		    });
		}		

	</script>  
</head>
<body id="page-top">

	<%@include file="homeScreen.html"%>
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
		  <form action="${pageContext.request.contextPath}/processmap"method="post" name="FC">
          	<div>
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Process Map Master</h6>
                </div>
                <div class="card-body">
					<p id="demo" style="color:red;">${param.loginMsg}</p>

								<table align="center">
									<tr>
									<td>Part Code/No</td>
									<td> <select id="isFg" class="form-control form-control-user" name="isFg" onkeypress="isKeyPressed(event)">
											<%
												out.print("chk");
							                    ArrayList<String[]> al = new SpinnerList().getfgList();
												out.print(al.size());
			
								   				for(int i = 0; i < al.size(); i++) 
								   				{
													String id=(String)al.get(i)[0];
								   					String option = (String)al.get(i)[1];
								   					String uom = (String)al.get(i)[2]; %>  	
											
							   				
											<option value="<%= id %> + <%= uom %>" ><%= option%>
											</option>
											<%	}
										
											%> 
									</select>
									</td>

										<td width=10></td>

									<td>Process</td>
									<td><select id="proc" class="form-control form-control-user" name="proc" onkeypress="isKeyPressed(event)" >
											<%   	
										
											
						                    ArrayList<String[]> procList = new SpinnerList().getprocessList();
											out.print(procList.size());
		
							   				for(int i = 0; i < procList.size(); i++) 
							   				{
												String id=(String)procList.get(i)[0];
							   					String option = (String)procList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
											<% }
											
							   				%> 
									</select></td>
								</tr>
								<tr>
									<td>Machine Type</td>
									<td><select id="machine" name="machine" class="form-control form-control-user"	onkeypress="isKeyPressed(event)" >
											<%   	
											
												out.print("chk");
						                    ArrayList<String[]> machList = new SpinnerList().getMachineList();
											out.print(machList.size());
		
							   				for(int i = 0; i < machList.size(); i++) 
							   				{
												String id=(String)machList.get(i)[0];
							   					String option = (String)machList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
											<% 
											}
							   				%> 
									</select></td>

										<td width=10></td>

									<td>Die/Tool</td>
									<td><select id="die" name="die" onkeypress="isKeyPressed(event)" class="form-control form-control-user">
											<%   	
											
												out.print("chk");
						                    ArrayList<String[]> dieList = new SpinnerList().getDieList();
											out.print(dieList.size());
		
							   				for(int i = 0; i < dieList.size(); i++) 
							   				{
												String id=(String)dieList.get(i)[0];
							   					String option = (String)dieList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
												<% }
										
						   				%> 
									</select></td>									
								</tr>
								<tr>
										<td>Setup Time</td>
										<td>
										<input type="text" name="setupTime" class="form-control form-control-user" id="duration1"/>
										<!-- <select >
									    <option>Secs</option>
									    <option>Mins</option>
									    <option>Hrs</option>
									    </select> --></td>

										<td width=10></td>
			
										<td>Cycle Time</td>
										<td><input type="text" name="cycleTime" class="form-control form-control-user" id="duration2"/>
<!--										<select >
									    <option>Secs</option>
									    <option>Mins</option>
									    <option>Hrs</option>
									    </select>--></td>								
									</tr>
					     			<tr>
										<td>Target output/hour</td>
										<td><input type="text" name="output_hr" class="form-control form-control-user" value="" size="20"  required="required"/></td>

										<td width=10></td>

										<td>Target output/shift</td>
										<td><input type="text" name="output_shift" value=""	size="20" class="form-control form-control-user" required="required" /></td>
									</tr>
									<tr>
										<td>Target output/day</td>
										<td><input type="text" name="output_day" value="" class="form-control form-control-user"  required="required"/></td>

										<td width=10></td>
			
										<td>Cost of the RM/IRM <br>after this process</td>
										<td><input type="text" name="cost_rm" value="" class="form-control form-control-user" required="required" /></td>
									</tr>
									<tr>
										<td>Maximum permissible<br>rejection/day</td>
										<td><input type="text" name="rejection" value="" class="form-control form-control-user"  required="required"/></td>

										<td width=10></td>
			
										<td>Remark</td>
										<td><textarea rows="2" class="form-control form-control-user" cols="22" name="remark" value=" "></textarea></td>
									</tr>
								</table>
					<br>
					<div align="center">
						<button class="btn btn-primary" type="submit" name="add" value="Add">Add</button>  <button class="btn btn-primary" type="submit" name="add" value="Load Map" onClick="removeRequired(this.form)">Load Map</button>	<button class="btn btn-primary" type="submit" name="update" value="Update">Update</button>	<button class="btn btn-primary" type="reset" name="reset" value="Reset">Reset</button>	<button class="btn btn-primary" type="submit" name="excel" value="excel">Export</button>	<button class="btn btn-primary" type="submit" name="cancel" value="cancel">Cancel</button> <button class="btn btn-primary"  type="submit" name="delete" value="Delete">Delete</button> <button class="btn btn-primary" type="reset" value="Reset">Reset</button>
					</div>
					<br>
			<div class="card-body">
					<div class="table-responsive">
							  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th>Process</th>
										<th>Machine</th>
										<th>Die/Tool</th>
										<th>Set up Time</th>
										<th>Cycle Time</th>
										<th>Remark</th>
										<th>O/P per hour</th>
										<th>O/P per shift</th>
										<th>O/P per day</th>
										<th>Unit of Part</th>
										<th>Effective value</th>
										<th>Maximum permissible</th>	
									</tr>
								</thead>
								<%--	<tbody>
						 	<% ArrayList<ProcessMapModel> dieList1 = new SpinnerList().getProcessMapDataList("test");
								   for(int i = 0; i < dieList.size(); i++) 
									{
									  
									%>
									<tr>
									
									<td><%= dieList1.get(i).getProcess_id() %></td>
									<td><%= dieList1.get(i).getMachine_id() %></td>
									<td><%= dieList1.get(i).getDie_id()%></td>
									<td><%= dieList1.get(i).getSetup_time()%></td>
									<td><%= dieList1.get(i).getCycle_time()%></td>
									<td><%= dieList1.get(i).getRemark()%></td>
									<td><%= dieList1.get(i).getOutput_hr()%></td>
									<td><%= dieList1.get(i).getOutput_shift()%></td>
									<td><%= dieList1.get(i).getOutput_day()%></td>
									<td><%= dieList1.get(i).getUom_id()%></td>
									<td><%= dieList1.get(i).getCost_rm()%></td>
									<td><%= dieList1.get(i).getRejection() %></td>
									</tr>
									<% 
									}			
								%> 
							   	</tbody>	--%>
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

  <script src="js/duration-picker.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->

               
  <script src="js/demo/datatables-demo.js"></script>

    <script>
        $(function () {
        	$("#duration1").durationPicker();
        	$("#duration2").durationPicker();
        });
    </script>
</body>
</html>