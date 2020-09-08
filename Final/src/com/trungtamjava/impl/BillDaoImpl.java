package com.trungtamjava.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.JDBC.JDBCConnection;
import com.trungtamjava.dao.BillDao;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.User;

public class BillDaoImpl extends JDBCConnection implements BillDao {

	@Override
	public void add(Bill bill) {
		String sql = "INSERT INTO bill( buyer, buyDate, priceTotal) VALUES (?,?, ?)";
		Connection conn = super.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bill.getBuyer().getId());
			statement.setString(2, bill.getBuyDate());
			statement.setLong(3, bill.getPriceTotal());

			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Loi: " + e);
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM bill WHERE bill_id = ?";
		Connection conn = super.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

	}

	@Override
	public void update(Bill bill) {
		String sql = "UPDATE bill SET buyDate  = ?, priceTotal = ? WHERE bill_id = ?";
		Connection conn = super.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bill.getBuyDate());
			statement.setLong(2, bill.getPriceTotal());
			statement.setInt(3, bill.getId());
			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Loi: " + e);
		}

	}

	@Override
	public Bill getById(int id) {
		String sql = "SELECT bill.bill_id , bill.buyDate,bill.priceTotal, user.name,user.id  FROM bill inner join user ON bill.buyer = user.username WHERE bill_id  = ?";
		Connection conn = super.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Bill b = new Bill();
				b.setId(resultSet.getInt("bill_id"));
				b.setBuyDate(resultSet.getString("buyDate"));
				b.setPriceTotal(resultSet.getLong("priceTotal"));

				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));

				b.setBuyer(user);// tao quan he

				return b;
			}
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	@Override
	public List<Bill> search(int userId) {

		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.bill_id , bill.buyDate, bill.priceTotal, user.name  FROM bill inner join user ON bill.buyer = user.username WHERE user.id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("bill_id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buyDate");
				Long pricetotal = rs.getLong("priceTotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}
	@Override
	  public  List<Bill> getAll(){
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.bill_id , bill.buyDate, bill.priceTotal, user.name  FROM bill inner join user ON bill.buyer = user.username";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("bill_id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buyDate");
				Long pricetotal = rs.getLong("priceTotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println(" loi :" + ex);
		}

		return billList;
		
	}

}
