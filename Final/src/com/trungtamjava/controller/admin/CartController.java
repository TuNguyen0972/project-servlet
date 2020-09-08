package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.impl.ProductDaoImpl;
import com.trungtamjava.model.BillProduct;
@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet{

   
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		Object obj = session.getAttribute("cart");
	//	List<BillProduct> product = new ArrayList<BillProduct>();
	//	if(obj != null){
		//	Map<String, BillProduct> map = (Map<String, BillProduct>) obj;
	//	}
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/cart/cart.jsp");
		dispatcher.forward(req, resp);
	}
   
}
