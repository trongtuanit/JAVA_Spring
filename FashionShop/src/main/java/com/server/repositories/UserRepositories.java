package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entities.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {

}
