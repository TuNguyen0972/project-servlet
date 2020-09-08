package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.impl.CategoryDaoImpl;


@WebServlet(urlPatterns = "/admin/category/delete")
public class AdminDeleteCategoryController extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	///docdu lieutuURL
 		///  
 		String id = req.getParameter("id");
 		CategoryDao categoryDao = new CategoryDaoImpl();
 		categoryDao.delete(Integer.parseInt(id));
 		//chuyen huong
 		resp.sendRedirect(req.getContextPath() + "/admin/category/search");
 	}
    
}
