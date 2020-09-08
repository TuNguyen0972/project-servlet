package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;

public interface ProductDao {
	void add(Product product);

	void update(Product product);

	void delete(int id);

	Product get(int id);
	
    List<Product> search(String name);
    
    
}
