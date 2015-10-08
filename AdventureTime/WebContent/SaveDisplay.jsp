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
			<h2>Save point   <span class="glyphicon glyphicon-ok"></span></h2>
			<p>
				Here is the number. Write this down, so you can enter it later to reload your current cart: <button style="cursor:auto" type="button" class="btn btn-primary disabled">${saveNumber}</button>
				</p>
		</div>
	</div>


</body>


</html>

