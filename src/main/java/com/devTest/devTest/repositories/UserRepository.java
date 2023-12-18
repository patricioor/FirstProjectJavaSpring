package com.devTest.devTest.repositories;

import com.devTest.devTest.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
