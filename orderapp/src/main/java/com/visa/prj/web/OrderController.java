package com.visa.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService os;
	
	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req, Model m) {
		String[] prds = req.getParameterValues("prds");
		HttpSession ses = req.getSession(false);
		
		List<Item> items = new ArrayList<>();
		for(String id:prds) {
			Product p = os.getById(Integer.parseInt(id));
			Item i = os.createItem(p);
			items.add(i);
		}
		String userEmail = (String)ses.getAttribute("user");
		Customer c = new Customer();
		c.setEmail(userEmail);
		Order o = os.createOrder(items, c);
		os.placeOrder(o);
		m.addAttribute("msg", "Order placed successfully");
		return "index.jsp";
	}
}