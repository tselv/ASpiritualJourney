<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Load-a-Cart</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="col-sm-offset-4 col-sm-4">
			<h2>Loading Screen</h2>
			<div class="progress">
				<div class="progress-bar progress-bar-striped active"
					role="progressbar" aria-valuenow="60" aria-valuemin="0"
					aria-valuemax="100" style="width: 60%"></div>
			</div>
			<form action="./Load">
				Enter that one number you were suppose to write down earlier: <input name="saveNumber">
				<button>Load Factor</button>
			</form>
		</div>
	</div>


</body>


</html>

