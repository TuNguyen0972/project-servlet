package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.BillProductDao;
import com.trungtamjava.impl.BillDaoImpl;
import com.trungtamjava.impl.BillProductDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
@WebServlet(urlPatterns = "/client/bill-product")  // ?billid = 11
public class ClientBillProductController extends HttpServlet {
	BillProductDao billProductDao = new BillProductDaoImpl();
	BillDao billDao = new BillDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String billId = req.getParameter("billid");
		
		Bill bill = billDao.getById(Integer.parseInt(billId));
		req.setAttribute("bill", bill);
		
		List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billId));
		req.setAttribute("billProducts", billProducts);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/bill/bill-product.jsp");
		dispatcher.forward(req, resp);
    }
}
