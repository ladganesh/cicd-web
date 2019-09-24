
<%@page import="com.prodezy.plantmaster.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 --%><html>
<head>	

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<!-- <script>
		function isKeyPressed(event) {
  			var text = "";
 		    document.getElementById("demo1").innerHTML = text;
		}
		
</script>  -->
  <title>Prod-Ezy Supplier</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
 <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
 
 <!-- <script>
   function previewFile(){
       var preview = document.querySelector('img'); //selects the query named img
       var file    = document.querySelector('input[type=file]').files[0]; //sames as here
       var reader  = new FileReader();

       reader.onloadend = function () {
           preview.src = reader.result;
       }

       if (file) {
           reader.readAsDataURL(file); //reads the data as a URL
       } else {
           preview.src = "";
       }
  }

  previewFile();  //calls the function named previewFile()
  </script> -->	
</head>           
<script src="jquery-2.1.4.js"></script>
<script lang="javascript" src="xlsx.full.min.js"></script>

<body id="page-top">
  	
        <%@include file="homeScreen.html" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
	      <form action="PlantMasterAdd" method="post" >
          <div >
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Supplier</h6>
                </div>
                <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                <div class="card-body">

 		         <div class="row">
	
    		        <!-- Customer Detail form -->
            		<div class="col-lg-6 mb-4">
	            		<div>
				            <table align="center">
				                 
								<tr>
									<td>Company Name</td><td><input type="text" name="company_name" class="form-control form-control-user" id="company_name" value="" size="45" /></td>
								</tr>
								<tr>
									<td>Plant Code</td><td><input type="text" class="form-control form-control-user" name="plant_code" id="plant_code" value="" size="45" /></td>
								</tr>
								<tr>
									<td>GST No</td><td><input type="text" class="form-control form-control-user" name="gst_no" id="gst_no" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Plant Contact No</td><td><input type="text"  class="form-control form-control-user" name="plt_cont_no" id="plt_cont_no"  value="" size="45"/></td>
								</tr>
								<tr>
									<td>Plant Email Address</td><td><input type="text" class="form-control form-control-user" name="plt_email_addr" id="plt_email_addr" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Weekly Off</td><td><select name="weekly_off" class="form-control form-control-user"  id="weekly_off">
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
									<td>Plant Name</td><td><input type="text"  " name="plt_name" class="form-control form-control-user" id="plt_name" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Contact Person Name</td><td><input type="text" name="cont_person_nm" class="form-control form-control-user" id="cont_person_nm" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Contact No</td><td><input type="text" name="cont_no" class="form-control form-control-user" id="cont_no" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Email Address</td><td><input type="text" name="email_addr" class="form-control form-control-user" id="email_addr" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Plant Address</td><td><input type="text"  name="plt_addr" class="form-control form-control-user" id="plt_addr" value="" size="45"/></td>
								</tr>
								<tr>
									<td><input type="hidden" name="plt_id" class="form-control form-control-user" id="plt_id" value="" size="45"/></td>
								</tr>					    </table>         
                	</div>
            </div>

            <div class="col-lg-6 mb-4">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Shifts</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
		            <table>
					<tr>
						<td>Shift Title </td><td>From Time</td><td>To Time</td><td>Break Duration</td>
					</tr>
					<tr>   
					             
						<td><input type="text" class="form-control form-control-user" name="shift1" id="shift1" value="" size="10"/></td> 
						<td><input type="time" class="form-control form-control-user" name="frmhrtime1" id="frmhrtime1" value=""/><!--:<input type="text"  name="frmmintime1" id="frmmintime1" value="" size="1"/> <select name="frm_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="time" class="form-control form-control-user" name="tohrtime1" id="tohrtime1" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="brk_time1" id="brk_time1" value="" size="5"/></td>
						<td><input type="hidden" class="form-control form-control-user" name="shiftid1" id="shiftid1" value="" size="10"/></td> 
					
					</tr>
					<tr>
						<td><input type="text" class="form-control form-control-user" name="shift2" id="shift2" value="" size="10"/></td>
						<td><input type="time" class="form-control form-control-user" name="frmhrtime2" id="frmhrtime2" value=""/><!--:<input type="text"  name="frmmintime1" id="frmmintime1" value="" size="1"/> <select name="frm_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="time" class="form-control form-control-user" name="tohrtime2" id="tohrtime2" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="brk_time2" id="brk_time2"  value="" size="5" /></td>
						<td><input type="hidden" class="form-control form-control-user" name="shiftid2" id="shiftid2" value="" size="10"/></td> 
					
					</tr>
					<tr>
						<td><input type="text" class="form-control form-control-user" name="shift3" id="shift3" value="" size="10"/></td>
						<td><input type="time" class="form-control form-control-user" name="frmhrtime3" id="frmhrtime3" value=""/><!--:<input type="text"  name="frmmintime1" id="frmmintime1" value="" size="1"/> <select name="frm_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="time" class="form-control form-control-user" name="tohrtime3" id="tohrtime3" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="brk_time3" id="brk_time3"  value="" size="5"/></td>			
						<td><input type="HIDDEN" class="form-control form-control-user" name="shiftid3" id="shiftid3" value="" size="10"/></td> 
					
					</tr>
					<tr>
						<td><input type="text" class="form-control form-control-user" name="shift4" id="shift4" value="" size="10"/></td>
						<td><input type="time" class="form-control form-control-user" name="frmhrtime4" id="frmhrtime4" value=""/><!--:<input type="text"  name="frmmintime1" id="frmmintime1" value="" size="1"/> <select name="frm_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="time" class="form-control form-control-user" name="tohrtime4" id="tohrtime4" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="brk_time4" id="brk_time4"  value="" size="5"/></td>
						<td><input type="HIDDEN" class="form-control form-control-user" name="shiftid4" id="shiftid4" value="" size="10"/></td> 
					
					</tr>
				   </table>					
                </div>
              </div>
            </div>         
          </div>      
          <br>
<div align="center">
         <input type="submit" class="btn btn-primary" name="Add_to_Plant_Master" value="Add_to_Plant_Master" />        
         <input type="submit" class="btn btn-primary" id="btnexcel" name="Export_to_Excel" value="Export_to_Excel" onclick=" exportToExcel('dataTable','plant_master')" />    
<!-- 		<input type="submit" class="btn btn-primary" id="btnimport" name="Add_to_Plant_Master" value="Import_to_Excel"  />    
 -->         
         <input type="submit" class="btn btn-primary" name="Create_QR_code" value="Create_QR_code" />    
         <input type="reset" class="btn btn-primary" value="Clear" />      
         <input type="submit" class="btn btn-primary" name="Cancel" value="Cancel" />    
         <input type="submit" class="btn btn-primary" name="Add_to_Plant_Master" value="Edit_record" /> 
         <input type="submit" class="btn btn-primary" name="Add_to_Plant_Master" value="Delete_record" />     
<!--          <input type="file" id="input-excel" name="input-excel" value="choose excel file to import"/>   
 -->                
</div>
<script>
 $(document).ready(
   function() {	
    $("form").submit(
      function(event) {
       event.preventDefault();
       var formData = new FormData(this);
       $.ajax({
        url : "upload",
        type : 'POST',
        data : formData,
        success : function(data) {
         var row = data;
         for(i =0 ; i < row.length ; i++){
             var column = row[i];
             var eachrow = "<tr>";
             for(j =0 ; j < column.length ; j ++){    
              eachrow = eachrow + "<td>"  + column[j] + "</td>";       
             }
             eachrow = eachrow + "</td>";
             $('#tbody').append(eachrow);
         }
        },
        cache : false,
        contentType : false,
        processData : false
       });

      });
   });
</script>
<div class="card-body">

<div class="table-responsive">

  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
	<tr>
				<th style ="visibility:hidden;"> </th>
		
		<th>Plant_Name</th>
		<th>Code</th>
		<th>Gst_No</th>
		<th>Plant_Address</th>
		<th>Week_off</th>
		<th>Contact_Person_Name</th>		
		<th>Contact_Person_No</th>
		<th>Contact_Person_Email</th>
		<th>Company_Name</th>
		<th>Plant_Contact_No</th>		

	</tr>
	</thead>
	<tbody>
   		<c:forEach items="${plantlist}" var="data">
         		<tr>
                  <td style ="visibility:hidden;">${data.plantid}</td> 
         		
                   <td> ${data.plantname}</td>
                    <td>${data.plantcode}</td>
                    <td>${data.gstno}</td>
                    <td>${data.plantaddress}</td>
                    <td>${data.plantweekoff}</td>
                    <td>${data.plantcpname}</td>
                    <td>${data.plantcpno}</td>
                    <td>${data.plantcpemail}</td>
                    <td>${data.companyname}</td>
                    <td>${data.plantcontactno}</td>   
                  
                     
                               
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
				var sentence,array,counter=0;
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${plantlist}" var="data">
				
					console.log(flag);
		
				if(flag==${data.plantid})
				{
/* 					console.log("here     ............");
 */	
					document.getElementById("company_name").value="${data.companyname}";
					document.getElementById("plant_code").value="${data.plantcode}";
					document.getElementById("gst_no").value="${data.gstno}";
					document.getElementById("plt_cont_no").value="${data.plantcontactno}";
					document.getElementById("plt_email_addr").value="${data.plantemail}";
					document.getElementById("weekly_off").value="${data.plantweekoff}";
					document.getElementById("plt_name").value="${data.plantname}";
					document.getElementById("cont_person_nm").value="${data.plantcpname}";
					document.getElementById("cont_no").value="${data.plantcpno}";
					document.getElementById("email_addr").value="${data.plantcpemail}";
					document.getElementById("plt_addr").value="${data.plantaddress}";
					document.getElementById("plt_id").value="${data.plantid}";

					
				
                     
	
				}
				</c:forEach>
				
				
				
				<c:forEach items="${shiftlist}" var="data">
				
				console.log(flag);
	
			if(flag==${data.refplantid})
			{
/* 					console.log("here     ............");
*/				
				counter=counter+1;
				if(counter==1)
				{
					document.getElementById("shiftid1").value="${data.shiftid}";

					document.getElementById("shift1").value="${data.shifttitle}";
					 sentence="${data.shiftfromtime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("frmhrtime1").value=array[1];
	
					sentence="${data.shifttotime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("tohrtime1").value=array[1];
	
					document.getElementById("brk_time1").value="${data.shiftduration}";
				}
			else if(counter==2)
				{
	
				document.getElementById("shiftid2").value="${data.shiftid}";

					document.getElementById("shift2").value="${data.shifttitle}";
					 sentence="${data.shiftfromtime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("frmhrtime2").value=array[1];
	
					sentence="${data.shifttotime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("tohrtime2").value=array[1];
	
					document.getElementById("brk_time2").value="${data.shiftduration}";
				}
			else if(counter==3)
				{
				document.getElementById("shiftid3").value="${data.shiftid}";

					document.getElementById("shift3").value="${data.shifttitle}";
					 sentence="${data.shiftfromtime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("frmhrtime3").value=array[1];
	
					sentence="${data.shifttotime}";
					 array=sentence.split(" ");
					console.log(array[1]);
					document.getElementById("tohrtime3").value=array[1];
	
					document.getElementById("brk_time3").value="${data.shiftduration}";	
					
				}
			else if(counter==4)
				{

				document.getElementById("shiftid4").value="${data.shiftid}";
				 sentence="${data.shiftfromtime}";
				 array=sentence.split(" ");
				console.log(array[1]);
				document.getElementById("frmhrtime4").value=array[1];

				sentence="${data.shifttotime}";
				 array=sentence.split(" ");
				console.log(array[1]);
				document.getElementById("tohrtime4").value=array[1];

				document.getElementById("brk_time4").value="${data.shiftduration}";
				}
	
   			}
			</c:forEach>
				
		};
	}  
	
		


	
 </script>
     
<script type="text/javascript">
function exportToExcel(tableID, filename='')
{
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