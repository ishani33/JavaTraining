package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String jpql = "from Hotel h where h.name like :criteria or h.address like :criteria or h.city like :criteria or h.state like :criteria or h.country like :criteria or h.zip like :criteria";
		TypedQuery<Hotel> query = em.createQuery(jpql,Hotel.class);
		query.setParameter("criteria", criteria);
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email=:arg1 and u.password=:arg2";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("arg1", email);
		query.setParameter("arg2", password);
		return query.getResultList().get(0);
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return booking.getId();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "select b from Booking b where b.user=:arg1";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("arg1", user);
		return query.getResultList();
	}

}
