package com.rameshsoft.SpringSecEx.repo;

import com.rameshsoft.SpringSecEx.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
//plain -> hash1 -> hash2