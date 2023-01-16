package com.frcsprep.services;

import com.frcsprep.entity.FrcsMem;
import com.frcsprep.repo.FrcsMemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FrscMemDetailsService implements UserDetailsService {

    @Autowired
    FrcsMemRepo frcsMemRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FrcsMem frscMem = frcsMemRepo.findByUserName(username);
        if (frscMem == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(frscMem.getUserName(), frscMem.getPassword(),
                new ArrayList<>());
    }
}
