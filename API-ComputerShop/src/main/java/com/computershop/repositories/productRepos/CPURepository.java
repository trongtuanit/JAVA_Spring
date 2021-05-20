package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.CPU;

@Repository
public interface CPURepository extends JpaRepository<CPU, Long>{

}
