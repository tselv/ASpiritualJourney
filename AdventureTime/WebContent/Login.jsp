<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log in</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
<script type="text/javascript">
var slideDuration = 2000;
	$(function() {
		$(".inButton").click(function() {
		    $('.log').fadeOut({ duration: 4000, queue: false }).css('display', 'inherit').slideUp(4000);
		    $('.reg').fadeIn({ duration: slideDuration, queue: false }).css('display', 'none').slideDown(slideDuration);
		});
		$(".outButton").click(function() {
			$('.log').fadeIn({ duration: slideDuration, queue: false }).css('display', 'none').slideDown(slideDuration);
		    $('.reg').fadeOut({ duration: slideDuration, queue: false }).css('display', 'inherit').slideUp(slideDuration);
		});
	});

</script>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid log">
		<h3 class="text-center">Log in</h3>
		<form class="form-horizontal" role="form" action="login">
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
			<div class="checkbox col-sm-offset-4 col-sm-4">
				<label><input type="checkbox"> Remember me (I haven't gotten around to implementing this)</label>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-success">Log In</button>
				</div>
			</div>
		</form>
		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-2">
				<button class="btn btn-default inButton" onclick="fin()">Don't have an account? Click here</button>
			</div>
		</div>

	</div>
	<div class="container-fluid reg" style="display:none">
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
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</div>
		</form>

		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-2">
				<button class="btn btn-default outButton">Back to the Log in stuff</button>
			</div>
		</div>
	</div>


</body>


</html>