package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.GraphicCard;

@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCard, Long>{

}
