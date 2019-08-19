package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

public interface OrderDao {

	void placeOrder(Order o);
	List<Order> getOrders(Customer c);
//	List<Order> getOrdersOfCustomer(Customer c);
}
