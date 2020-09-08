package com.trungtamjava.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.UserDaoImpl;
import com.trungtamjava.model.User;
@WebServlet(urlPatterns = "/login-client")
public class ClientLoginController extends HttpServlet{
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String err = req.getParameter("err");
		
		if (err != null) {
			req.setAttribute("errMsg", "Tk hoac mk sai");
		}
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/client/login.jsp");
		// chuyen tiep
		dispatcher.forward(req, resp);
	}

	/// cho form goi len method=post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc gia tri len tu form
		String uname = req.getParameter("username");// ten cua input
		String password = req.getParameter("password");// ten cua input

		// demo login , so sanh voi tai khoan admin/123
		UserDao userDao  = new UserDaoImpl();
		User user = userDao.getByUsername(uname);
		
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("DN thanh cong");
			/// CHUYEN HUONG TRANG REDIRECT
			/// CLIENT SE LAM VIEC NAY
			// THONG QUA GIA TRI CUA RESPONSE TRA VE
			/////LUU SESSION
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
			//req.getContextPath(): tra ve /ten project
			resp.sendRedirect(req.getContextPath() + "/client/dashboard1.jsp");
		} else {
			System.out.println("That bai");
			/// CHUYEN HUONG TRANG REDIRECT
			/// CLIENT SE LAM VIEC NAY
			// THONG QUA GIA TRI CUA RESPONSE TRA VE
			resp.sendRedirect(req.getContextPath() +"/login-client?err=1");
		}
	}
}
