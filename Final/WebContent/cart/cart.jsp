<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gio hang</title>
</head>
<body>
      <table>
           <tr>
           <td>Id</td>
           <td>Ten SP</td>
           <td>So luong</td>
           <td>Gia</td>
           <td>Tong tien</td>
           <td>Lua chon</td>
           </tr>
           <c:forEach items="${sessionScope.cart}" var="entry">
           <tr>
           <td>${entry.key}</td>
           <td>${entry.value.product.name}</td>
           <td>${entry.value.quantity}</td>
           <td>${entry.value.unitPrice}</td>
           <td>${entry.value.quantity * entry.value.unitPrice}</td>
           <td><a href="/Final/delete-from-cart?key=${entry.key} ">Xoa</a></td>
           </tr>
           </c:forEach>
         
         
      </table>
      <a href="/Final/client/add-order">Thanh toan</a>
      
</body>
</html>