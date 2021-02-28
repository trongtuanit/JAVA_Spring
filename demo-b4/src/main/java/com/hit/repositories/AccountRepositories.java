package com.hit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hit.dao.Account;

@Repository
public interface AccountRepositories extends JpaRepository<Account,Integer>{
	
}
