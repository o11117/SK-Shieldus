package com.rookies4.myspringboot.repository;

import com.rookies4.myspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //customerId로 조회하는 Query 메소드 정의
    Optional<Customer> findByCustomerId(String customerId);
    //customerName으로 조회하는 Query 메소드 정의
    List<Customer> findByCustomerNameContains(String customerName);
}
