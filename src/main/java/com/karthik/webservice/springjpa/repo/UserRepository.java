package com.karthik.webservice.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepo")
public interface UserRepository extends JpaRepository<User, Long> {

}
