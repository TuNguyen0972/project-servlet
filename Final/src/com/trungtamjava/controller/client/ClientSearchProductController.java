package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.impl.ProductDaoImpl;
import com.trungtamjava.model.Product;
@WebServlet(urlPatterns = "/client/product/product-list")
public class ClientSearchProductController extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	// DAY DU LIEU VAO REQ de chuyen tiep qua VIEW
	 		String name = req.getParameter("name");
	 		// neu ko truyen gi thi mac dinh search ""
	 		if (name == null) {
	 			name = "";
	 		}

	 		ProductDao productDao = new ProductDaoImpl();
	 		List<Product> products = productDao.search(name);

	 		req.setAttribute("productList", products);
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("/client/view/product-list.jsp");
	 		dispatcher.forward(req, resp);
	 	}

	 	@Override
	 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 		doGet(req, resp);
	 	}
}
