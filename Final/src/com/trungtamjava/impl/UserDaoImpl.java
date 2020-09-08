package com.trungtamjava.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.JDBC.JDBCConnection;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void add(User user) {
		String sql = "INSERT INTO user(name, username, password,role, city, gender, imageName) VALUES (?, ?, ?, ?, ?,?,?);";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImageName());
			
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET name = ?, username = ?, password = ?,role = ?, city = ?, gender = ?, imageName = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImageName());
			preparedStatement.setInt(8, user.getId());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM user WHERE id = ?";

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
	public User get(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();

				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
				user.setGender(resultSet.getString("gender"));
				user.setImageName(resultSet.getString("imageName"));
				return user;
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	@Override
	public List<User> search(String name) {
		List<User> users = new ArrayList<>();

		String sql = "SELECT * FROM user WHERE name LIKE ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, "%" + name + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();

				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
				user.setGender(resultSet.getString("gender"));
				user.setImageName(resultSet.getString("imageName"));

				users.add(user);
			}
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return users;
	}

	@Override
	public User getByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();

				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
				user.setGender(resultSet.getString("gender"));
				user.setImageName(resultSet.getString("imageName"));
				return user;
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

}
