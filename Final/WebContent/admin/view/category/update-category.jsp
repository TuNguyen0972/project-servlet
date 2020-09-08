<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
<link rel="stylesheet" href="/Final/admin/css/style.css">
</head>
<body>
	<div class="container">
		<form class="form-group" action="/Final/admin/category/update" method="post">
			<div>
				<label>ID:</label> 
				<input type="text" name="id" value="${category.getId()}">
			</div>
			<div>
				<label>Name:</label> 
				<input type="text" name="name" value="${category.getName()}">
			
			
				<button type="submit">Sua</button>
			</div>
		</form>
	</div>
</body>
</html>