<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar-menu">
	<div class="logo">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
		</a>
	</div>
	<div class="menu">
		<ul id="menu">
			<c:url value="/admin/user/dashboard" var="dashboard"></c:url>
			<li id="menu-home"><a href="${dashboard}"><i
					class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
			<c:url value="/admin/user/user-list" var="userList"></c:url>
			<li><a href="${userList}"><i class="fa fa-users"></i><span>User</span><span class="fa fa-angle-right" style="float: right"></span></a>
			<ul>
				<li><a href="${userList}"><i class="fa fa-list"></i><span>List
							User</span></a></li>
				<c:url value="/admin/user/add" var="addUser"></c:url>
		        <li><a href="${addUser}"><i class="fa fa-plus-square"></i><span>Add User</span></a></li>
		        </ul>
		        </li>
		    <c:url value="/admin/category/category-list" var="cateList"></c:url>
		    <li><a href="${cateList}"><i class="fa fa-book"></i><span>Category</span><span class="fa fa-angle-right" style="float: right"></span></a>
			<ul>
				<li><a href="${cateList}"><i class="fa fa-list"></i><span>List
							Category</span></a></li>
				<c:url value="/admin/category/add" var="addCate"></c:url>
		        <li><a href="${addCate}"><i class="fa fa-plus-square"></i><span>Add Category</span></a></li>
		    </ul>
			</li>
			 <c:url value="/admin/product/product-list" var="proList"></c:url>
			 <li><a href="${proList}"><i class="fa fa-database"></i><span>Product</span><span class="fa fa-angle-right" style="float: right"></span></a>
			<ul>
				<li><a href="${proList}"><i class="fa fa-list"></i><span>List
							Product</span></a></li>
				<c:url value="/admin/product/add" var="addPro"></c:url>
		        <li><a href="${addPro}"><i class="fa fa-plus-square"></i><span>Add Product</span></a></li>
		    </ul>
			</li>
			 <c:url value="/admin/cart" var="cartList"></c:url>
			 <li><a href="${cartList}"><i class="fa fa-bitcoin"></i><span>Cart</span></a>
			</li>
			</ul>
	</div>
</div>
<div class="clearfix"></div>
</div>