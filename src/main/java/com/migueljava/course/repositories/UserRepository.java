package com.migueljava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.migueljava.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
