<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shopping Cart</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
	<h2 class="text-center">Your Shopping Cart</h2>
	<div class="col-sm-offset-1 col-sm-10">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>Item Id</th>
					<th>Description</th>
					<th style="text-align: right">Price</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${items}">
					<tr>

						<td><c:out value="${item.name}" /></td>
						<td><c:out value="${item.id}" /></td>
						<td><c:out value="${item.shortDescription}" /></td>
						<td style="text-align: right"><c:out value="${item.price}" /></td>

					</tr>
				</c:forEach>
				<tr class="Total">
					<td>Total</td>
					<td></td>
					<td></td>
					<td style="text-align: right"><%=request.getAttribute("Cost")%></td>
				</tr>

			</tbody>
		</table>
	</div>

	</div>


</body>


</html>