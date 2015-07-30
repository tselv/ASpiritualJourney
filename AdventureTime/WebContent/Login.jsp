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
		<form class="form-horizontal" role="form" action="#">
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="usernameL">Username:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="usernameL"
						placeholder="Enter a username" name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="pwdL">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pwdL"
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
		<jsp:include page="RegisterForm.jsp"></jsp:include>
		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-2">
				<button class="btn btn-default outButton">Back to the Log in stuff</button>
			</div>
		</div>
	</div>


</body>


</html>