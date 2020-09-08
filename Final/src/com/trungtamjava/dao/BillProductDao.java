package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.BillProduct;



public interface BillProductDao {
	
	void add(BillProduct billproduct);

	void delete(int id);

	void update(BillProduct billproduct);

	BillProduct getById(int id);

	List<BillProduct> search(int id);
}
