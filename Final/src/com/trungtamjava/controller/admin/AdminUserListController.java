package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.UserDaoImpl;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
@WebServlet(urlPatterns = "/admin/user/user-list")
public class AdminUserListController extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
        	// DAY DU LIEU VAO REQ de chuyen tiep qua VIEW
     		String name = req.getParameter("name");
     		// neu ko truyen gi thi mac dinh search ""
     		if (name == null) {
     			name = "";
     		}
     		UserDao userDao = new UserDaoImpl();
     		List<User> users = userDao.search(name);

     		req.setAttribute("userList", users);
     		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/user/user-list.jsp");
        	dispatcher.forward(req, resp);
        }
        
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	doGet(req, resp);
        }
}
