package com.trungtamjava.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.trungtamjava.JDBC.JDBCConnection;
import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao{

	@Override
	public void add(Category category) {
		String sql = "INSERT INTO category(name) VALUES (?);";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, category.getName());
			
			
			
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public void update(Category category) {
		String sql = "UPDATE category SET name = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category.getId());
			

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE id = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
		
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM category WHERE id = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();

				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				
				
				return category;
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	@Override
	public List<Category> search(String name) {
		List<Category> categorys = new ArrayList<>();

		String sql = "SELECT * FROM category WHERE name LIKE ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, "%" + name + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();

				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				
				

				categorys.add(category);
			}
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return categorys;
	}

}
