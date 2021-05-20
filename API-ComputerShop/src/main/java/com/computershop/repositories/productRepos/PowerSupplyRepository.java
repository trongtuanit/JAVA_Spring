package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.PowerSupply;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long>{

}
