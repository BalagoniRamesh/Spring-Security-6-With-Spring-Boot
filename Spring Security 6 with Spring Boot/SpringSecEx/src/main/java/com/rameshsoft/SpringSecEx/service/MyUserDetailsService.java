package com.rameshsoft.SpringSecEx.service;

import com.rameshsoft.SpringSecEx.model.UserPrincipal;
import com.rameshsoft.SpringSecEx.model.Users;
import com.rameshsoft.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw  new UsernameNotFoundException("user not found exception");
        }
        return new UserPrincipal(user);
    }
}
