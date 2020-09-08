package com.trungtamjava.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.JDBC.JDBCConnection;
import com.trungtamjava.dao.BillProductDao;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Product;

public class BillProductDaoImpl extends JDBCConnection implements BillProductDao {
	@Override
	public void add(BillProduct billProduct) {
		Connection conn = super.getConnection();

		try {

			String sql = "INSERT INTO bill_product(unitPrice, quantity,bill_id,product_id) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setLong(1, billProduct.getUnitPrice());
			st.setInt(2, billProduct.getQuantity());
			st.setLong(3, billProduct.getBill().getId());
			st.setLong(4, billProduct.getProduct().getId());

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(BillProduct p) {
		try {
			String sql = "update bill_product SET unitPrice = ? , quantity = ?, bill_id = ?,product_id = ? WHERE bill_product_id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, p.getUnitPrice());
			ps.setInt(2, p.getQuantity());
			ps.setInt(3, p.getBill().getId());
			ps.setInt(4, p.getProduct().getId());

			ps.setInt(5, p.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill_product WHERE bill_product_id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public BillProduct getById(int id) {
		try {
			// lay tat cot cua billproduct va vai cot cua product
			String sql = "SELECT bill_product.*, product.name, product.image, product.id from bill_product inner join product on bill_product.product_id = product.product_id WHERE bill_product_id=?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unitPrice"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getInt("product_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				return billProduct;
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return null;
	}

	@Override
	public List<BillProduct> search(int billId) {
		List<BillProduct> billList = new ArrayList<BillProduct>();

		try {
			String sql = "SELECT bill_product.*, product.name, product.image, product.id  from bill_product inner join product on bill_product.product_id = product.product_id WHERE bill_product.bill_id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, billId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unitPrice"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getInt("product_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				billList.add(billProduct);
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return billList;
	}

}