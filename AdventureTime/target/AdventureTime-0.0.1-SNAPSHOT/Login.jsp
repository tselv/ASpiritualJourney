<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log in</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
<script type="text/javascript">
var slideDuration = 900;
	$(function() {
		$(".inButton").click(function() {
		    $('.log').fadeOut({ duration: slideDuration, queue: false }).css('display', 'inherit').slideUp(slideDuration);
		    $('.reg').fadeIn({ duration: slideDuration, queue: false }).css('display', 'none').slideDown(slideDuration);
		});
		$(".outButton").click(function() {
			$('.log').fadeIn({ duration: slideDuration, queue: false }).css('display', 'none').slideDown(slideDuration);
		    $('.reg').fadeOut({ duration: slideDuration, queue: false }).css('display', 'inherit').slideUp(slideDuration);
		});
	});
	function accLog() {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "LogInCheck", false);
		xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var str = "userName=" + document.getElementById("usernameL").value;
		str += "&password=" + document.getElementById("pwdL").value;
		console.log(str);
		xmlHttp.send(str);
		if(xmlHttp.responseText == "1") {
			var url = "gallery.jsp";    
			$(location).attr('href',url);
			return false;
		}	
		document.getElementById("failedLog").innerHTML='<p class="text-danger">The username or password provided was incorrect</p>';
		return false;
	}
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
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-success" onclick="return accLog();">Log In</button>
				</div>
			</div>
		</form>
		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-2">
				<button class="btn btn-default inButton">Don't have an account? Click here</button>
			</div>
		</div>
		
		<div id="failedLog"></div>

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