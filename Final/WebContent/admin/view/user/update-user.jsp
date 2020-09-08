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
		<form class="form-group" action="/Final/admin/user/update" method="post">
			<div>
				<label>ID:</label> 
				<input type="text" name="id" value="${user.getId()}">
			</div>
			<div>
				<label>Name:</label> 
				<input type="text" name="yourname" value="${user.name}">
			</div>
			<div>
				<label>Username:</label> 
				<input type="text" name="username" value="${user.username}">
			</div>
			<div>
				<label>Password:</label> 
				<input type="password" name="password" value="${user.password}">
			</div>
			<div>
				<label>Gender:</label> 
				<input type="radio" name="gender" value="M" ${user.gender == 'M' ? 'checked':''}>Nam 
				<input type="radio" name="gender" value="F" ${user.gender == 'F' ? 'checked':''}>Nu
			</div>
			<div>
				<label>Noi sinh:</label> 
				<select name="city" value="${user.city}">
					<option value="Hanoi">Hanoi</option>
					<option value="TP.HCM">TP.HCM</option>
					<option value="Hai Phong">Hai Phong</option>
				</select>
			</div>
			<div>
				<label>Vai tro:</label> 
				<select name="role" value="${user.role}">
					<option value="ADMIN">ROLE_ADMIN</option>
					<option value="MEMBER">THANH VIEN</option>
				</select>
			</div>
			<div>
				<label>Link Anh:</label> 
				<input type="text" name="imageName">
			</div>
			<div>
				<button type="submit">Them</button>
			</div>
		</form>
	</div>
</body>
</html>