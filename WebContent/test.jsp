<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link href="css/sb-admin-2.min.css" rel="stylesheet">
 


</head>
<body>
    <div class="container">
        <div class="row">

            <div class="col-md-offset-3 col-md-6">
                <form>
                    <div class="form-group">
                        <label>Duration</label>
                        <input type="text" class="form-control" id="duration1">
                    </div>
                </form>
            </div>
	
                        <label>Duration with seconds</label>
                        <input type="text" class="form-control" id="duration2">
            </div>
        </div>
    </div>

    <script>
        $(function () {
        	$("#duration1").durationPicker();
        	$("#duration2").durationPicker();

//            $('#duration2').durationPicker({ showDays:false,showSeconds: true, checkRanges: true, totalMax: 259200000 /* 3 days */ });
  //          $('#duration3').durationPicker({ showDays:false,showSeconds: true, checkRanges: true, totalMax: 259200000 /* 3 days */ });
        });
    </script>

</body>
</html>