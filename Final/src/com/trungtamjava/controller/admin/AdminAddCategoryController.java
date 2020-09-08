package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;


@WebServlet(urlPatterns = "/admin/category/add")
public class AdminAddCategoryController extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/category/add-category.jsp");
     	dispatcher.forward(req, resp);
     	
    }
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     	String name = req.getParameter("name");
     	
     	
     	Category category = new Category();
     	category.setName(name);
     	
     	
     	// save to database
     	CategoryDao categoryDao = new CategoryDaoImpl();
 		categoryDao.add(category);
 		
 		//chuyen huong
 				
 		resp.sendRedirect(req.getContextPath() + "/admin/category/search");
     	
     	
     	
     }
}
