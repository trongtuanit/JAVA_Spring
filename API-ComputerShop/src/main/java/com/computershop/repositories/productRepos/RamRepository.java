package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long>{

}
