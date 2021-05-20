package com.computershop.repositories.productRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.product.HardDisk;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long>{

}
