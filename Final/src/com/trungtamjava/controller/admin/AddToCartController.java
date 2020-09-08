package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.impl.ProductDaoImpl;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartController extends HttpServlet {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pid");
		System.out.println(pId);
		Product product = productDao.get(Integer.parseInt(pId));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session

		if (obj == null) {

			// Tao mat hang
			BillProduct billProduct = new BillProduct();
			billProduct.setProduct(product);
			billProduct.setQuantity(1);
			billProduct.setUnitPrice(product.getPrice());

			// gio hang co nhieu mat hang

			Map<String, BillProduct> map = new HashMap<>();
			map.put(pId, billProduct);// them mat hang vao danh sach
			session.setAttribute("cart", map);// luu tam vao session

		} else {
			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;

			BillProduct billProduct = map.get(pId);

			if (billProduct == null) {
				billProduct = new BillProduct();
				billProduct.setProduct(product);
				billProduct.setQuantity(1);
				billProduct.setUnitPrice(product.getPrice());

				map.put(pId, billProduct);
			} else {

				billProduct.setQuantity(billProduct.getQuantity() + 1);
			}

			session.setAttribute("cart", map);// luu tam vao session
		}

		// chuyen ve trang gio hang
		resp.sendRedirect(req.getContextPath() + "/cart");

	}
}
