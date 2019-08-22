package com.visa.prj.rest;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RunWith(SpringRunner.class)//creates a Spring container which is good enough for testing
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@MockBean
	private OrderService service; //since we only have to test ProductController, we create a "mock OrderService" 
	
	@Autowired
	private MockMvc mockMvc; //because while testing this, we aren't starting the server, so we create a mock MVC where spring would keep DispatcherServlet and HandlerMappings ready
	
	@Test
	public void getProductsTest() throws Exception {
		List<Product> products = Arrays.asList(new Product(1,"a","c1",500.00,100),
				new Product(2,"b","c2",1500.00,100));
		//mocking
		when(service.getProducts()).thenReturn(products);
		
		// @formatter:off
		mockMvc.perform(get("/products"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].name", is("a")))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].name", is("b")));
	     // @formatter:on
	     verify(service, times(1)).getProducts();
	     verifyNoMoreInteractions(service);
	}
	
	@Test
	public void addProductTest() throws Exception{
		Product p = new Product(0,"b","c2",1500.00,100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p); // get JSON for Product p
		
		//mocking if Product type is passed to service  he should return a PK 10
		when(service.saveProduct(Mockito.any(Product.class))).thenReturn(10); //p is in the form of json, we can't pass it directly to saveProduct here, on server Spring(ContentNegotiationHandlers) does that for us
		
		mockMvc.perform(post("/products")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		verify(service, times(1)).saveProduct(Mockito.any(Product.class));
	}
	
}
