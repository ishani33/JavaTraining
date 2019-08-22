package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {
}
