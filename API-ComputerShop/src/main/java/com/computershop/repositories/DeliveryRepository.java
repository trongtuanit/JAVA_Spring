package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
