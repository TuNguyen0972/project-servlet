package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;


@WebServlet(urlPatterns ="/admin/category/category-list")
public class AdminCategoryListController extends HttpServlet{
	 @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     	
     	// DAY DU LIEU VAO REQ de chuyen tiep qua VIEW
  		String name = req.getParameter("name");
  		// neu ko truyen gi thi mac dinh search ""
  		if (name == null) {
  			name = "";
  		}
  		CategoryDao categoryDao = new CategoryDaoImpl();
  		List<Category> categorys = categoryDao.search(name);

  		req.setAttribute("categoryList", categorys);
  		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/category/category-list.jsp");
     	dispatcher.forward(req, resp);
     }
     
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     	doGet(req, resp);
     }
}
