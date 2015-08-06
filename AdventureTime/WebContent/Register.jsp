<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<jsp:include page="RegisterForm.jsp"></jsp:include>
		<div class="col-sm-offset-5 col-sm-2" id="failedUser"></div>
	</div>


</body>


</html>