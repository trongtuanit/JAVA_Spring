package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
