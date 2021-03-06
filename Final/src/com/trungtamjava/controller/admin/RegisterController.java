package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/dang-ky")
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/client/view/register.jsp");
		dispatcher.forward(req, resp);
	}

	// cho form goi len method=post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String city = req.getParameter("city");
		String gender = req.getParameter("gender");
		String imageName = req.getParameter("imageName");
		
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setUsername(username);
		u.setPassword(password);
		u.setRole(role);
		u.setCity(city);
		u.setGender(gender);
		u.setImageName(imageName);
		
		
	}
}
