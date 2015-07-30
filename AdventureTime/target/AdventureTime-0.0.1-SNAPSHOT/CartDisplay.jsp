<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1>Let's see how much this is going to cost you, shall we?</h1>
</div>

<div id="nav">
<a href="./WebPages/main.html">Home Page</a><br>
<a href="./ItemPage?itemId=1">Servlets and JSPs</a><br>
<a href="./ItemPage?itemId=2">Java SCJP certification</a>
<a href="./ItemPage?itemId=3">Harry Potter</a><br>
</div>

<div id="section">
<h2>Shopping Cart</h2>
<p><%= request.getAttribute("ItemsInCart") %></p>
<p>The total cost of the items in your cart are: <%= request.getAttribute("Cost") %></p>

<c:forEach var="item" items="${items}">
    <c:out value="${item.name}"/> 
</c:forEach>

</div>

<div id="footer">
<a href="./Save" >Get a code for your cart</a><br>
<a href="./LoadDisplay.jsp">Enter a code to load a previous cart</a>
</div>

</body>
</html>
