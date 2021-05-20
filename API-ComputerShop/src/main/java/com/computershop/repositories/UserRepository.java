package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
