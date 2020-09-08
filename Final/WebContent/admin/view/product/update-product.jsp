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
		<form class="form-group" action="/Final/admin/product/update" method="post">
			<div>
				<label>ID:</label> 
				<input type="text" name="id" value="${product.getId()}">
			</div>
			<div>
				<label>Name:</label> 
				<input type="text" name="name" value="${product.name}">
			</div>
			<div>
				<label>Price:</label> 
				<input type="text" name="price" value="${product.price}">
			</div>
			<div>
				<label>Image:</label> 
				<input type="text" name="image" value="${product.image} ">
			</div>
			<div>
				<label>Description:</label> 
				<input type="text" name="description" value="${product.description}" >
				</div>
			<div>
				<label>Category:</label> 
				<input name="category_id" value="${product.getCategory().getId()}">
					
				
			</div>
			
			<div>
				<button type="submit">Them</button>
			</div>
		</form>
	</div>
</body>
</html>