<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<h3 class="text-center">Sign Up</h3>
		<div class="row">
			<div class="alert alert-danger fade in col-sm-offset-4 col-sm-5">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				By the way, dont enter your actual information here. I have
				basically no security on this site right now
			</div>
		</div>

		<form class="form-horizontal" role="form" action="register">
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="username"
						placeholder="Enter a username" name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter a password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="email"
						placeholder="Enter your email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name"
						placeholder="Enter your name" name="name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-default">Register</button>
				</div>
			</div>
		</form>


	</div>


</body>


</html>