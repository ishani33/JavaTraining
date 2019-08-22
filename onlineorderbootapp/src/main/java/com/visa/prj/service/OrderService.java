package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrder(){
		return orderDao.findAll();
	}
	
	@Transactional
	public int placeOrder(Order o) {
		orderDao.save(o);
		double total = 0.0;
		List<Item> items = o.getItems();
		for(Item i : items) {
			total += i.getAmount();
			Product p = getById(i.getProduct().getId());
			p.setCount(p.getCount() - i.getQty()); // dirty checking will update product count
		}
		o.setTotal(total);
		return o.getOid();
	}
	
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	
	public List<Product> getProductsByPrice(double price){
		return productDao.getByPriceGreaterThan(price);
	}
	
	public List<Product> getCategory(String category){
		return productDao.findByCategory(category);
	}
	
	@Transactional
	public int saveProduct(Product p) {
		productDao.save(p);
		return p.getId();
	}
	
	public Product getById(int id) {
//		return productDao.getOne(id); // this is LAZY LOADING --> only works with client code
		return productDao.findById(id).get(); //THIS IS EAGER FETCHING // .get() is used since the return type is Optional --> Optional is just a wrapper to avoid nullpointer exception
	}
	
	public List<Customer> getCustomers(){
		return customerDao.findAll();
	}
	
	public Customer getByEmail(String email) {
		return customerDao.findById(email).get();
	}
	
	@Transactional
	public String saveCustomer(Customer c) {
		customerDao.save(c);
		return c.getEmail();
	}
	
	
}
