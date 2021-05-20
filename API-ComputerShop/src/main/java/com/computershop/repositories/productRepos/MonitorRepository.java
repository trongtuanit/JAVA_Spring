package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.Monitor;


@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long>{

}
