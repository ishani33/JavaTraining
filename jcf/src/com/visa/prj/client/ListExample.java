package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"HP Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
//		Collections.sort(products, (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
//		for(Product p : products) {
//			System.out.println(p);
//		}
		
//		products.stream().filter(p->p.getCategory().equals("mobile")).forEach(p->System.out.println(p));
		
		List<String> names = products.stream().map(p -> p.getName()).collect(Collectors.toList());
		for(String n : names) {
			System.out.println(n);
		}
		
		double total = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1,v2) -> v1+v2);
		System.out.println(total);
		
		/*
		System.out.println("for each");
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("Iterator");
		Iterator<Product> iter = products.iterator();
		while(iter.hasNext()) {
			Product p = iter.next();
			System.out.println(p);
		}
		System.out.println();
		
		// Advantage ----> for each and iterator locks the List while traversal, so they are FAIL SAFE
		
		System.out.println("Index based: AVOID"); //only use if conditional remove is required 
		for(int i=0; i< products.size(); i++) {
			System.out.println(products.get(i));
		}
		*/
	}

}
