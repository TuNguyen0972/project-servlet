package com.trungtamjava.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.impl.CategoryDaoImpl;
import com.trungtamjava.impl.ProductDaoImpl;
import com.trungtamjava.impl.UserDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/add")
public class AdminAddProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categorys = categoryDao.search("");

		req.setAttribute("categoryList", categorys);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/product/add-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("D:\\Desktop\\image"));

			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			// danh sach cac truong input tu form client
			List<FileItem> filedList = servletFileUpload.parseRequest(req);
			Product product = new Product();
			for (FileItem item : filedList) {
				System.out.println("1");
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					product.setName(name);
				}
				System.out.println("2");
				if (item.getFieldName().equals("price")) {
					String price = item.getString();
					product.setPrice(Integer.parseInt(price));
				}
				System.out.println("3");
				if (item.getFieldName().equals("description")) {
					String description = item.getString();
					product.setDescription(description);
				}
				System.out.println("4");
				if (item.getFieldName().equals("category_id")) {
					String categoryId = item.getString();

					Category category = new Category();
					category.setId(Integer.parseInt(categoryId));
					product.setCategory(category);
				}
				System.out.println("5");
				if (item.getFieldName().equals("imageFile")) {
					if (item.getSize() > 0) {
						final String UPLOAD_FODER = "D:\\Desktop\\image";

						String fileName = "test.jpg";
						File file = new File(UPLOAD_FODER + File.separator + fileName);
						// ghi du lieu upload len vao file
						item.write(file);

						product.setImage(fileName);// luu lai ten file anh

					}

				}
			}
			ProductDao productDao = new ProductDaoImpl();
			productDao.add(product);

			// chuyen huong
			resp.sendRedirect(req.getContextPath() + "/admin/product/search");
		} catch (Exception e) {
			System.out.println("Loi" + e);
		}

	}
}
