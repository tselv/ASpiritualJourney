<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Art at its finest</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<c:forEach var="entry" items="${ItemMap}" varStatus="indexVar">
			<div class="col-sm-3">
				<a href="ItemPage?itemId=${entry.value.id}"> <img
					src="${entry.value.imageLoc}"
					class="img-rounded img-responsive center-block"
					alt="No Image Found" width="200" height="228">
				</a> <a href="ItemPage?itemId=${entry.value.id}">
					<h3 class="text-center">${entry.value.name}</h3>
				</a>
				<div class="well"><p class="text-center">${entry.value.shortDescription}</p></div>
			</div>
			<c:if test="${indexVar.index % 4 == 3}">
				</div><div class="row">
			</c:if>
		</c:forEach>
		</div>
	</div>

	</div>


</body>


</html>




