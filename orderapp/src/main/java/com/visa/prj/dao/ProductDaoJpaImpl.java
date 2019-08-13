package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
//@Profile("prod")
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getProducts() {
		
		return null;
	}

	@Override
	public Product getProduct(int id) {
		
		return em.find(Product.class, id); // select --> raises [DataAccess Exception] not SQL exception i.e an inbuilt wrapper on top of SQL Exception
	}

	@Override
	public int addProduct(Product p) {
		em.persist(p); // insert
		return p.getId();
	}

}
