package com.trungtamjava.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.trungtamjava.JDBC.JDBCConnection;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;


public class ProductDaoImpl extends JDBCConnection implements ProductDao{
	@Override
	public void add(Product product) {
     String sql = "INSERT INTO product(name, price, image, description, category_id) VALUES (?, ?, ?, ?, ?);";
			try {
				Connection conn =  super.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setString(1, product.getName());
				preparedStatement.setLong(2, product.getPrice());
				preparedStatement.setString(3, product.getImage());
				preparedStatement.setString(4, product.getDescription());
			    preparedStatement.setInt(5, product.getCategory().getId());
				
				
				preparedStatement.executeUpdate(); // cau lenh tren thu vien de update len sql server

			} catch (Exception e) {
				System.out.println("Loi: " + e);
			}
		}

		@Override
		public void update(Product product) {
			String sql = "UPDATE product SET name = ?, price= ?, image = ?, description = ?, category_id = ? WHERE product_id = ?";
			try {
				Connection conn =  super.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql); // PreparedStatement la 1 doi tuong de chuyen tai len sql

				preparedStatement.setString(1, product.getName());
				preparedStatement.setLong(2, product.getPrice());
				preparedStatement.setString(3, product.getImage());
				preparedStatement.setString(4, product.getDescription());
				preparedStatement.setInt(5, product.getCategory().getId());
				preparedStatement.setInt(6, product.getId());
				

				preparedStatement.executeUpdate();

			} catch (Exception e) {
				System.out.println("Loi: " + e);
			}
		}

		@Override
		public void delete(int id) {
			String sql = "DELETE FROM product WHERE product_id = ?";

			try {
				Connection conn =  super.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setInt(1, id);

				preparedStatement.executeUpdate();

			} catch (Exception e) {
				System.out.println("Loi: " + e);
			}
		}

		@Override
		public Product get(int id) {
			String sql = "SELECT product.product_id, product.name as 'name_product', product.price, product.image,product.description, product.category_id," + 
			" category.name FROM product " +   
					"INNER JOIN category ON product.category_id = category.id WHERE product_id =?";;

			try {
				Connection conn = super.getConnection();

				PreparedStatement preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setInt(1, id);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Product product = new Product();

					product.setId(resultSet.getInt("product_id"));
					product.setName(resultSet.getString("name_product"));
					product.setPrice(resultSet.getLong("price"));
					product.setImage(resultSet.getString("image"));
					product.setDescription(resultSet.getString("description"));
					Category category = new Category();
					category.setId(resultSet.getInt("category_id"));
					product.setCategory(category);
					return product;
				}

			} catch (Exception e) {
				System.out.println("Loi: " + e);
			}

			return null;
		}

		@Override
		public List<Product> search(String name) {
			List<Product> products = new ArrayList<>();

			String sql = "SELECT product.product_id, product.name as 'name_product', product.price, product.image,product.description, product.category_id," + 
			" category.name FROM product " +   
					"INNER JOIN category ON product.category_id = category.id WHERE product.name LIKE ?";
					 
			try {
				Connection conn = super.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
                 
				preparedStatement.setString(1, "%" + name + "%" );

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Product product = new Product();
					
					product.setId(resultSet.getInt("product_id"));
					product.setName(resultSet.getString("name_product"));
					product.setPrice(resultSet.getLong("price"));
					product.setImage(resultSet.getString("image"));
					product.setDescription(resultSet.getString("description"));
					Category category = new Category();
					category.setId(resultSet.getInt("category_id"));
					category.setName(resultSet.getString("name"));
					product.setCategory(category);
				    products.add(product);
				}
			} catch (Exception e) {
				System.out.println("Loi: " + e);
				
			}
			System.out.println(products.size());
			return products;
		}

		

		
		
		

		
	}


