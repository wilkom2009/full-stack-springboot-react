package com.wilkom.udemycourses.restfultodowebservices.jwt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtUserDetailsJpaRepository extends CrudRepository<JwtUserDetailsJpa, Long> {
	JwtUserDetailsJpa findByUsername(String username);
}
