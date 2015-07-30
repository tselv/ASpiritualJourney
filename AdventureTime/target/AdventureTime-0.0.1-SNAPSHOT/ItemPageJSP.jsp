<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/primary.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

<div id="header">
<h1>Reading is Cool</h1>
</div>

<div id="nav">
<a href="./ItemPage?itemId=1">Servlets and JSPs</a><br>
<a href="./ItemPage?itemId=2">Java SCJP certification</a>
<a href="./ItemPage?itemId=3">Harry Potter</a><br>
</div>

<div id="section">
<h2><%= request.getAttribute("ItemName") %></h2>
<img src="<%= request.getAttribute("ItemImageLoc") %>"  style="width:200px;height:228px;">
<p>
<%= request.getAttribute("ItemDescription") %>
</p>
<form action="./ShoppingCart" method="get">
<button name="item" type="submit" value="<%= request.getAttribute("ItemId") %>"><%= request.getAttribute("cartOption") %></button>
</form>
</div>

<div id="footer">
<a href="./Save" >Get a code for your cart</a><br>
<a href="./LoadDisplay.jsp">Enter a code to load a previous cart</a>
</div>


</body>
</html>
