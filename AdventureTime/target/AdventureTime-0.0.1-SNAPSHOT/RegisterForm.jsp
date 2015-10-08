<script type="text/javascript">
	function checkUserName() {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "UserNameCheck", false);
		xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var str = "userName=" + document.getElementById("username").value;
		str += "&email=" + document.getElementById("email").value;
		str += "&password=" + document.getElementById("pwd").value;
		str += "&name=" + document.getElementById("name").value;
		console.log(str);
		xmlHttp.send(str);
		if(xmlHttp.responseText == "1") {
			var url = "gallery.jsp";    
			$(location).attr('href',url);
			return false;
		}	
		document.getElementById("failedUser").innerHTML='<p class="text-danger">That username was already taken</p>';
		return false;
	}
</script>
<h3 class="text-center">Sign Up</h3>
		<div class="row">
			<div class="alert alert-danger fade in col-sm-offset-4 col-sm-5">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				By the way, dont enter your actual information here. I have
				basically no security on this site right now
			</div>
		</div>

		<form class="form-horizontal" role="form" action="#">
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="username"
						placeholder="Enter a username" name="username" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter a password" name="password" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="email"
						placeholder="Enter your email" name="email" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name"
						placeholder="Enter your name" name="name" required />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button class="btn btn-success" onClick="return checkUserName();">Register</button>
				</div>
			</div>
		</form>