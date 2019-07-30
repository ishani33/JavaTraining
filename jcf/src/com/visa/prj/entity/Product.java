package com.visa.prj.entity;

public class Product implements Comparable<Product>{
	private int id;
	private String name;
	private double price;
	private String category;
	private int count;
	
	public Product() {
	}

	public Product(int id, String name, double price, String category, int count) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.id, o.id);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
