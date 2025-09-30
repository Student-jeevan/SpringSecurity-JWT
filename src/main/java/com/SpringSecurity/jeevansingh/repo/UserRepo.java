package com.SpringSecurity.jeevansingh.repo;

import com.SpringSecurity.jeevansingh.model.Student;
import com.SpringSecurity.jeevansingh.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
