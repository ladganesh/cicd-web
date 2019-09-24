
<%@page import="com.prodezy.finishedgoods.*"%>
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

  <title>Finished Goods Master</title>

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

<body id="page-top">
        <%@include file="homeScreen.html" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
	      <form action="FinishedgoodsAdd" method="post">
          <div >
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Finished Goods</h6>
                </div>
                                <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                
                <div class="card-body">

 		         <div class="row">
	
    		        <!-- Customer Detail form -->
            		<div class="col-lg-6 mb-4">
	            		<div>
				            <table align="center">
				                 
								<tr>
									<td>Part Code\No</td><td><input type="text" name="partcode" required="required"class="form-control form-control-user" id="partcode" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Part Unique Id</td><td><input type="text" required="required"class="form-control form-control-user" name="partid" id="partid" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Part Name</td><td><input type="text" required="required"class="form-control form-control-user" name="partname" id="partname" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Sales Rate Unit</td><td><input type="text"required="required" class="form-control form-control-user" name="sru" id="sru"  value="" size="45"/></td>
								</tr>
								<tr>
									<td>Net Weight</td><td><input type="text"required="required" class="form-control form-control-user" name="netweight" id="netweight" placeholder="in Grams" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Gross Weight</td><td><input type="text" required="required" class="form-control form-control-user" name="grossweight" id="grossweight" value="" placeholder="in Grams"size="45"/></td>
								</tr>
								<tr>
									<td>Measure</td><td><select name="weekly_off" class="form-control form-control-user" required="required" id="measure">
										<option>cm</option>
										<option>kg</option>
										<option>mg</option>
										<option>mm</option>
										<option>nos</option>
										<option>tons</option>
									</select></td>
								</tr>
								<tr>
									<td>Product Note</td><td><textarea name="productnote" required="required"class="form-control form-control-user" id="productnote" value="" size="45"></textarea></td>
								</tr>
								<tr>
									<td>Category RM/Part</td><td><input type="text"required="required" name="categoryrm" class="form-control form-control-user" id="categoryrm" value="" size="45"/></td>
								</tr>
								<tr>
									<td>Production cost/unit</td><td><input type="text" required="required"	name="productioncost" class="form-control form-control-user" id="productioncost" value="" size="45"/></td>
								</tr>
								<tr>
								<td><input type="hidden" name="id" class="form-control form-control-user" id="id" value="" size="45"/></td>
								</tr>
								
					    </table>         
                	</div>
            </div>

            <div class="col-lg-6 mb-4">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Quality</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
		            <table>
					<tr>
						<td>Quality Param </td><td>Bench Mark</td><td>UOM</td><td>LSL</td><td>USL</td>
					</tr>
					<tr>                
						<td>ID</td> 
						<td><input type="text" class="form-control form-control-user" name="bm1	" id="bm1" placeholder="0.0" value=""  style="width:70px;" /></td>
						<td><select name="uom" class="form-control form-control-user"  id="uom" style="width: 120px;">
										<option>cm</option>
										<option>kg</option>
										<option>mg</option>
										<option>mm</option>
										<option>nos</option>
										<option>tons</option>
									</select></td>
						<td><input type="text" class="form-control form-control-user" name="lsl1" id="lsl1" placeholder="0.0" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="usl1" id="usl1" placeholder="0.0" value="" size="5"/></td>
					</tr>
				<tr>                
						<td>OD</td> 
						<td><input type="text" class="form-control form-control-user" name="bm1	" id="bm1" placeholder="0.0" value=""style="width:70px;"/></td>
						<td><select name="uom" class="form-control form-control-user"  id="uom">
										<option>cm</option>
										<option>kg</option>
										<option>mg</option>
										<option>mm</option>
										<option>nos</option>
										<option>tons</option>
									</select></td>
						<td><input type="text" class="form-control form-control-user" name="lsl1" id="lsl1" placeholder="0.0" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="usl1" id="usl1" placeholder="0.0" value="" size="5"/></td>
					</tr><tr>                
						<td>Thickness</td> 
						<td><input type="text" class="form-control form-control-user" name="bm1	" id="bm1" placeholder="0.0" value="" style="width:70px;"/></td>
						<td><select name="uom" class="form-control form-control-user"  id="uom">
										<option >cm</option>
										<option>kg</option>
										<option>mg</option>
										<option>mm</option>
										<option>nos</option>
										<option>tons</option>
									</select></td>
						<td><input type="text" class="form-control form-control-user" name="lsl1" id="lsl1" placeholder="0.0" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="usl1" id="usl1" placeholder="0.0" value="" size="5"/></td>
					</tr><tr>                
						<td>Surface Finish</td> 
						<td><input type="text" class="form-control form-control-user" name="bm1	" id="bm1" placeholder="0.0" value="" style="width:70px;"/></td>
						<td><select name="uom" class="form-control form-control-user"  id="uom">
										<option>cm</option>
										<option>kg</option>
										<option>mg</option>
										<option>mm</option>
										<option>nos</option>
										<option>tons</option>
									</select></td>
						<td><input type="text" class="form-control form-control-user" name="lsl1" id="lsl1" placeholder="0.0" value=""/><!-- :<input type="text" name="tomintime1" class="form-control form-control-user" id="tomintime1" value="" size="2"/> <select class="form-control form-control-user" name="to_ampm1"><option>AM</option><option>PM</option></select>--></td>
						<td><input type="text" class="form-control form-control-user" name="usl1" id="usl1" placeholder="0.0" value="" size="5"/></td>
					</tr>
				   </table>					
                </div>
              </div>
            </div>         
          </div>      
          <br>
<div align="center">
         <input type="submit" class="btn btn-primary" name="Add_to_Master" value="Add_to_Master" />     
         <input type="submit" class="btn btn-primary" id="btnexcel" name="Export_to_Excel" value="Export_to_Excel" onClick="exportToExcel('dataTable','FinishedGoods_master')"/>    
         <input type="submit" class="btn btn-primary" name="Create_QR_code" value="Create_QR_code" />    
         <input type="reset" class="btn btn-primary" value="Clear" />      
         <input type="submit" class="btn btn-primary" name="Cancel" value="Cancel" />    
         <input type="submit" class="btn btn-primary" name="Add_to_Master" value="Edit_record" />        
</div>
<div class="card-body">

<div class="table-responsive">

  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
	<tr>
		<th>FG_ID</th>
		<th>FG_PART_UNIQUE_ID</th>
		<th>FG_PART_NO</th>
		<th>PART_NAME</th>
		<th>SALES_RATE</th>
		<th>NT_WT</th>
		<th>GRS_WT</th>
		<th>NOTES</th>
		<th>PROD_COST</th>		
		<th>FG_UOM_ID</th>
		<!-- <th>ASSEMBLED</th> -->

	</tr>
	</thead>
	<tbody>
   		<c:forEach items="${Finishgoodslist}" var="data">
         		<tr>
                    <td> ${data.fgid}</td>
                   <td>${data.fgpartuniqueid}</td>
                    <td>${data.fgpartno}</td>
                    <td>${data.partname}</td>
                    <td>${data.salesrate}</td>
                    <td>${data.ntweight}</td>
                    <td>${data.grsweight}</td>
                    <td>${data.notes}</td>
                    <td>${data.prdcost}</td>
                    <td>${data.fguomid}</td>
<%--                     <td>${data.plantcontactno}</td>   
 --%>                  
                     
                               
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
			
				console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${Finishgoodslist}" var="data">
				
					console.log(flag);
		
				if(flag==${data.fgid})
				{
					console.log("here     ............");
	
					document.getElementById("partcode").value="${data.fgpartno}";
					document.getElementById("partid").value="${data.fgpartuniqueid}";
					document.getElementById("partname").value="${data.partname}";
					document.getElementById("sru").value="${data.salesrate}";
					document.getElementById("netweight").value="${data.ntweight}";
					document.getElementById("grossweight").value="${data.grsweight}";
					document.getElementById("productnote").value="${data.notes}";
					document.getElementById("productioncost").value="${data.prdcost}";
					document.getElementById("id").value="${data.fgid}";

					
	
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