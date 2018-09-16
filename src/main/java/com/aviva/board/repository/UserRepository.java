package com.aviva.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aviva.board.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
