<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Art at its finest</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
<style type="text/css">

.container-fluid {
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}
</style>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="col-sm-offset-3 col-sm-6">
			<form role="search" id="topSearch" action="ItemPage">
				<div class="input-group">
					<select id="select-beast" class="demo-default" placeholder="Find an item..." name="itemId">
						<option value="">Find an item...</option>
						<c:forEach var="entry" items="${ItemMap}" varStatus="indexVar">
							<option value="${entry.value.id}">${entry.value.name}</option>
						</c:forEach>
					</select>
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		$('#select-beast').selectize({
			create : true,
			sortField : 'text'
		});
	</script>
	<div class="container-fluid">
		<c:forEach var="entry" items="${ItemMap}" varStatus="indexVar">
			<c:if test="${indexVar.index % 4 == 0 && indexVar.index > 3}">
				<hr noshade>
			</c:if>
			<div class="col-sm-3">
				<a href="ItemPage?itemId=${entry.value.id}">
					<h3 class="text-center">${entry.value.name}</h3>
				</a>
				<div class="well">
					<p class="text-center">${entry.value.shortDescription}</p>
				</div>
				<a href="ItemPage?itemId=${entry.value.id}"> <img
					src="${entry.value.imageLoc}"
					class="img-rounded img-responsive center-block"
					alt="No Image Found" width="200" height="228">
				</a>

			</div>
			<c:if test="${indexVar.index % 4 == 3}">
				<div class="row"></div>
			</c:if>
		</c:forEach>

	</div>



</body>


</html>




