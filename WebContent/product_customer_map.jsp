<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="webcall.*" %>
        <%@page import="com.prodezy.utility.*" %>
    
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.*" %>
<%@page import="model.*" %>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
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

	  
</head>
<body id="page-top">

	<%@include file="homeScreen.html"%>
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
		  <form action="${pageContext.request.contextPath}/Customermapadd"method="post" name="FC">
          	<div>
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Product Customer Map Master</h6>
                </div>
                <p id="demo1" style="color:red;" align="center">${errorMessage}</p>
                <div class="card-body">
					<p id="demo" style="color:red;">${param.loginMsg}</p>

								<table align="center">
									<tr>
									<td><input type="hidden" id="fgc_id" name="fgc_id"></td></tr><tr>
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
								   					 %>  	
												<option value="<%= id %>"><%= option %>
											</option>
											<%	}
										
											%> 
									</select>
									</td>

										<td width=30></td>

									
								</tr>
								<tr>
									<td>Customer</td>
									<td><select id="customer" name="customer" class="form-control form-control-user"	onkeypress="isKeyPressed(event)" >
											<%   	
											
												out.print("chk");
						                    ArrayList<String[]> customerlist = new SpinnerList().getCustomerlist();
											out.print(customerlist.size());
		
							   				for(int i = 0; i < customerlist.size(); i++) 
							   				{
												String id=(String)customerlist.get(i)[0];
							   					String option = (String)customerlist.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
											<% 
											}
							   				%> 
									</select></td>

										<td width=30></td></tr>
										<tr>

								<td>Sales Rate</td>
									<td><input type="text" class="form-control form-control-user" name="sales_rate" id="sales_rate" ></td><td>per Nos</td>									
								</tr>
																</table>
					<br>
					<div align="center">
						<button class="btn btn-primary" type="submit" name="Add_to_Master" value="Add_to_Master">Add</button>  
<!-- 						<button class="btn btn-primary" type="submit" name="add" value="Load Map" onClick="removeRequired(this.form)">Load Map</button>	
 -->						<button class="btn btn-primary" type="submit" name="Add_to_Master" value="edit_record">Update</button>	
 						<button class="btn btn-primary"  type="submit" name="Add_to_Master" value="delete_record">Delete</button> 
 						<button class="btn btn-primary" type="reset" name="reset" value="Reset">Reset</button>	
						<button class="btn btn-primary" type="submit" name="excel" value="excel">Export</button>	
						<button class="btn btn-primary" type="submit" name="cancel" value="cancel">Cancel</button> 
					</div>
					<br>
			<div class="card-body">
					<div class="table-responsive">
							  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
									<td style="visibility:hidden;"> </td>
										<th>Part</th>
										<th>Customer</th>
										<th>Selling Rate</th>
										<th>Unit</th>
											
									</tr>
								</thead>
								<tbody>
   		<c:forEach items="${product_customer_list}" var="data">
         		<tr>
         		  <td style="visibility:hidden;">${data.fg_c_id}</td>
                  <td>${data.part_name}</td> 
                  <td>${data.customer_name}</td>
                  <td>${data.sales_rate}</td>
                   <td>${data.uom}</td>
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
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave</h5>
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
<script type="text/javascript">

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				//console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${product_customer_list}" var="data">
				
					console.log(flag);
		
				if(flag==${data.fg_c_id})
				{
/* 					console.log("here     ............");
 */				
					
						document.getElementById("fgc_id").value="${data.fg_c_id}";
						document.getElementById("isFg").value="${data.m_fg_id}";
		  				document.getElementById("customer").value="${data.m_cust_id}";
		  				document.getElementById("sales_rate").value="${data.sales_rate}";


	
				}
				</c:forEach>
		};
	}  
	
		


	
 </script>
     
   
</body>
</html>