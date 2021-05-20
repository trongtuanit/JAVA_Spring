package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long>{

}
