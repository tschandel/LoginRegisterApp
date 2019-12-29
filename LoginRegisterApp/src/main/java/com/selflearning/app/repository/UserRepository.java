package com.selflearning.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selflearning.app.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByLoginId(String username);
}
