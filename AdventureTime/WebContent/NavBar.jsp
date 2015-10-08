<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Compound Interest</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="gallery.jsp">Gallery</a></li>
				<li><a href="ShoppingCartPrinter">View Shopping Cart</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Cart Options<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Save">Save current cart</a></li>
						<li><a href="LoadDisplay.jsp">Load a saved cart</a></li>
					</ul>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:if test="${saveNumber != null}">
				<li><a href="#">Hey ${clientName}, welcome back!</a></li>
					<li><a href="LogOut"><span
							class="glyphicon glyphicon-log-out"></span> Log out</a></li>
				</c:if>
				<c:if test="${saveNumber == null}">
					<li><a href="Register.jsp"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>
