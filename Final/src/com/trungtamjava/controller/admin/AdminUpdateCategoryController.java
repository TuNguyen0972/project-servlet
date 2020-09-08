package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.CategoryDaoImpl;
import com.trungtamjava.impl.UserDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.User;
@WebServlet(urlPatterns = "/admin/category/update")
public class AdminUpdateCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDao categoryDao = new CategoryDaoImpl();
		Category category = categoryDao.get(Integer.parseInt(id));

		req.setAttribute("category", category);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/category/update-category.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		Category category = new Category();
		category.setName(name);
		category.setId(Integer.parseInt(id));
		/// save to database
				CategoryDao categoryDao = new CategoryDaoImpl();
				categoryDao.update(category);

				// chuyen huong
				resp.sendRedirect(req.getContextPath() + "/admin/category/search");
	}
}
