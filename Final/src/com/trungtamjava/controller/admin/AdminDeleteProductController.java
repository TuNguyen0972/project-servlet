package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.impl.ProductDaoImpl;

@WebServlet(urlPatterns = "/admin/product/delete")
public class AdminDeleteProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/// docdu lieutuURL
		///
		String id = req.getParameter("id");
		ProductDao productDao = new ProductDaoImpl();
		productDao.delete(Integer.parseInt(id));
		// chuyen huong
		resp.sendRedirect(req.getContextPath() + "/admin/product/search");
	}

}
