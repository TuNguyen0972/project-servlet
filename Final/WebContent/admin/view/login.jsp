<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/Final/css/style.css">

</head>
<body>
	<div class="container">
		<p>${errMsg}</p>
		<div class="login-page">
  <div class="form">
    
    <form action="/Final/login-admin" method="post">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
	</div>
</body>
</html>