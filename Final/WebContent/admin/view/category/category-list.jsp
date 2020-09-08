<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	
	<div class="container">
	
		<div class="row">
			<!-- MENU -->


		</div>
		<div>
			<form action="/Final/admin/category/category-list" method="get">
				<input name="name" type="text" placeholder="Tim ten">
				<button type="submit">Tim</button>
			</form>
			
				<table class="table table-striped custab">
					<thead>

						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Tuychon</th>
							
							
                       </tr>
                     <c:forEach items="${categoryList}" var="c">
                     <tr>
							<td>${c.getId()}</td>
							<td>${c.name}</td>
							
							<td class="text-center"><a class='btn btn-info btn-xs'
							href="/Final/admin/category/update?id=${c.getId()}"><span class="glyphicon glyphicon-edit"></span> Sua</a>
							<a href="/Final/admin/category/delete?id=${c.getId()}" class="btn btn-danger btn-xs"><span
								class="glyphicon glyphicon-remove"></span> Xoa</a></td>
					</tr>
						
						</c:forEach>
					
				</table>
			</div>
		</div>
	
</body>
</html>