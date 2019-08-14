package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class HotelClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService os = ctx.getBean("bookingService", BookingService.class);
		User user = os.getUser("ishani@gmail.com", "ish");
		
		List<Booking> bookingsByUser = os.getAllBookingsByUser(user);
		for(Booking b : bookingsByUser) {
			System.out.println(b.getDescription());
		}
		
		System.out.println("HOTELS BY CRITERIA");
		List<Hotel> hotels = os.findHotels("NY");
		for(Hotel h : hotels) {
			System.out.println(h.getName() + ": " + h.getAddress()+", "+h.getCity()+", "+h.getState()+", "+h.getCountry()+", "+h.getZip()+".");
		}
		
		System.out.println();
		System.out.println("HOTEL BY ID");
		Hotel h = os.getHotelById(220);
		System.out.println(h.getName() + ": " + h.getAddress()+", "+h.getCity()+", "+h.getState()+", "+h.getCountry()+", "+h.getZip()+".");
	}

}
