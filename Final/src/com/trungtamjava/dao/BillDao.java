package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Bill;

public interface BillDao {

	void add(Bill bill);

	void delete(int id);

	void update(Bill bill);

	Bill getById(int id);

	List<Bill> search(int userId);
	
	List<Bill> getAll();
}
