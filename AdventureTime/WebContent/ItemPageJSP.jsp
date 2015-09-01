<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${ItemName}</title>
<jsp:include page="scriptsmeta.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="NavBar.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-offset-3 col-sm-3">
				<h2 class="text-center">${ItemName}</h2>
				<p>${ItemDescription}</p>
				<p>Price: ${ItemPrice}</p>
				<form action="./ShoppingCart" method="get">
					<button name="item" type="submit"
						class="btn ${cartOption == 'Add to Cart' ? 'btn-success' : 'btn-danger'} btn-md"
						value="${ItemId}">${cartOption}</button>
				</form>
			</div>
			<div class="col-sm-3">
				<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:forEach var="entry" items="${ItemImageLocs}" varStatus="indexVar">
							<c:if test="${indexVar.index == 0}">
								<li data-target="#myCarousel" data-slide-to="${indexVar.index}" class="active"></li>
							</c:if>
							<c:if test="${indexVar.index != 0}">
								<li data-target="#myCarousel" data-slide-to="${indexVar.index}"></li>
							</c:if>
						</c:forEach>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<c:forEach var="entry" items="${ItemImageLocs}" varStatus="indexVar">
							<c:if test="${indexVar.index == 0}">
								<div class="item peopleCarouselImg active">
							</c:if>
							<c:if test="${indexVar.index != 0}">
								<div class="item peopleCarouselImg">
							</c:if>
								<img src="${entry}" alt="Chania" width="460" height="345">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>


</html>
