package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.Mainboard;

@Repository
public interface MainboardRepository extends JpaRepository<Mainboard, Long>{

}
