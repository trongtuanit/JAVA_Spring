package com.server;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
	List<T> getAll();
	Optional<T> get(Integer id);
	
	void save(T t);
    void update(T t);
    void delete(T t);
}
