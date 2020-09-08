package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/update")
public class AdminUpdateProductController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.get(Integer.parseInt(id));

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/product/update-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String id = req.getParameter("id");

		Product product = new Product();
		product.setId(Integer.parseInt(id));
		product.setName(name);
		product.setPrice(Long.parseLong(price));
		product.setImage(req.getParameter("image"));
		product.setDescription(req.getParameter("description"));
		Category category = new Category();
		category.setId(Integer.parseInt(req.getParameter("category_id")));
		product.setCategory(category);

		/// save to database
		ProductDao productDao = new ProductDaoImpl();
		productDao.update(product);

		// chuyen huong
		resp.sendRedirect(req.getContextPath() + "/admin/product/search");
	}
    
}
