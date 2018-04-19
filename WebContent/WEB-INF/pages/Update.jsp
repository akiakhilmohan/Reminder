<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
   
  });
</script>
<script>
$(document).ready(function(){
    $('#timepicker').timepicker({ timeFormat: 'HH:mm' });
});
</script>
  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Reminder</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/change">
Id:<input type="text" name="id" value="${Aid}">
<input type="submit" name="b1" value="Search"><br>

Content:<input type="text" name="content1" value="${Acontent}"><br>
Date:<input type="text" name="remind_date" id="datepicker" value="${ARemind_date}"><br>
Time:<input type="text" name="remind_time" id="timepicker" value="${ARemind_time}"><br>

<input type="submit" name="b2" value="Change">
</form>

</body>
</html>