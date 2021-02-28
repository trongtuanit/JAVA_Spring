package com.hit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hit.dao.AccountDAO;

public interface AccountRepositories extends JpaRepository<AccountDAO, Long> {
	@Query
	AccountDAO findByUsername(String username);
}
