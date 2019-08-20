package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

@Controller
@SessionAttributes("user")
public class BookingController {
	
	@Autowired
	private BookingService bs;

	@RequestMapping("search.do")
	public ModelAndView getSearchForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("hotel", new Hotel());
		return mav;
	}
	
	@RequestMapping("hotels.do")
	public ModelAndView getSearchResults(@RequestParam("searchString") String criteria) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		mav.addObject("hotelList", bs.findHotels(criteria));
		return mav;
	}
	
	@RequestMapping("viewHotel.do")
	public ModelAndView getHotelsById(@RequestParam("id") int hotelId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		mav.addObject("hotel", bs.getHotelById(hotelId));
		return mav;
	}
	
	@RequestMapping("bookingForm.do")
	public ModelAndView loginToBookHotel(@RequestParam("id") int hotelId, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userLoginForm.jsp");
		mav.addObject("booking",new Booking());
		HttpSession ses = req.getSession(true);
		ses.setAttribute("hotel", hotelId);
		return mav;
	}
	
	@RequestMapping("login.do")
	public String getBookingForm(@ModelAttribute("booking") Booking b, Model m,HttpServletRequest req) {
		m.addAttribute("user", b.getUser().getEmail());
		HttpSession ses = req.getSession(false);
		Hotel h = bs.getHotelById((int)ses.getAttribute("hotel"));
		b.setHotel(h);
		m.addAttribute("hotel", b.getHotel());
		return "bookingForm.jsp";
	}
	
	@RequestMapping("placeReservation.do")
	public ModelAndView makeBooking(@ModelAttribute("booking") Booking b) {
		ModelAndView mav = new ModelAndView();
		bs.makeBooking(b.getUser(), b.getHotel(), b.getCheckinDate(), b.getCheckoutDate(), b.isSmoking(), b.getBeds());
		mav.setViewName("showBookings.jsp");
		mav.addObject("bookingList", bs.getAllBookingsByUser(b.getUser()));
		return mav;
	}
}
