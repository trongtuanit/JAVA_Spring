package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.Manufacture;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long>{

}
