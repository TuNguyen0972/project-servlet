<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach san pham</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/Final/css/style1.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/animate.css">

<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/magnific-popup.css">

<link rel="stylesheet" href="/Final/homeclient/feliciano/css/aos.css">

<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/ionicons.min.css">

<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/jquery.timepicker.css">


<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/flaticon.css">
<link rel="stylesheet"
	href="/Final/homeclient/feliciano/css/icomoon.css">
<link rel="stylesheet" href="/Final/homeclient/feliciano/css/style.css">
</head>
<body>

	<div class="container-fluid">

		<div class="row">
			<!-- MENU -->


		</div>
		<div>
			<form action="/Final/client/product/product-list" method="get">
				<input name="name" type="text" placeholder="Tim ten">
				<button type="submit">Tim</button>
			</form>
			<c:forEach items="${productList}" var="p">
				<div class="col-md-12 col-lg-6 d-flex align-self-stretch">
					<div class="menus d-sm-flex ftco-animate align-items-stretch">
						<div class="menu-img img"
							style="background-image: url(${p.image });"></div>
						<div class="text d-flex align-items-center">
							<div>
								<div class="d-flex">
									<div class="one-half">
										<h3>${p.name }</h3>
									</div>
									<div class="one-forth">
										<span class="price">${p.price }</span>
									</div>
								</div>
								<p>
									${p.description }
								</p>
								<p>
									<a href="/Final/add-to-cart?pid=${p.id}" class="btn btn-primary">Order now</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<script src="/Final/homeclient/feliciano/js/jquery.min.js"></script>
		<script
			src="/Final/homeclient/feliciano/js/jquery-migrate-3.0.1.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/popper.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/bootstrap.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/jquery.easing.1.3.js"></script>
		<script src="/Final/homeclient/feliciano/js/jquery.waypoints.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/jquery.stellar.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/owl.carousel.min.js"></script>
		<script
			src="/Final/homeclient/feliciano/js/jquery.magnific-popup.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/aos.js"></script>
		<script
			src="/Final/homeclient/feliciano/js/jquery.animateNumber.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/bootstrap-datepicker.js"></script>
		<script src="/Final/homeclient/feliciano/js/jquery.timepicker.min.js"></script>
		<script src="/Final/homeclient/feliciano/js/scrollax.min.js"></script>
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
		<script src="/Final/homeclient/feliciano/js/google-map.js"></script>
		<script src="/Final/homeclient/feliciano/js/main.js"></script>
</body>
</html>