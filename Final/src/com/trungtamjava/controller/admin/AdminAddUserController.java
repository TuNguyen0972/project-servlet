package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/admin/user/add")
public class AdminAddUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/user/add-user.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
System.out.println(name);
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));
		user.setCity(req.getParameter("city"));
		user.setGender(req.getParameter("gender"));
		user.setImageName(req.getParameter("imageName"));

		// save to database
		UserDao userDao = new UserDaoImpl();
		userDao.add(user);

		// chuyen huong

		resp.sendRedirect(req.getContextPath() + "/admin/user/search");

	}
}
