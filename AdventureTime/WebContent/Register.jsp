<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
<script type="text/javascript">
	function checkUserName() {

		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "UserNameCheck", false);
		xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var str = "userName=" + document.getElementById("username").value;
		xmlHttp.send(str);
		if(xmlHttp.responseText == "1")
			return false;

		document.getElementById("failedUser").innerHTML='<p class="text-danger">That Username was already taken</p>';
		return false;
	}
</script>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<jsp:include page="RegisterForm.jsp"></jsp:include>
		<div class="col-sm-offset-5 col-sm-2" id="failedUser"></div>
	</div>


</body>


</html>