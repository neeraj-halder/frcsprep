package com.frcsprep.services;

import com.frcsprep.entity.FrcsMem;
import com.frcsprep.pojo.AuthenticationRequest;
import com.frcsprep.pojo.AuthenticationResponse;
import com.frcsprep.pojo.RegisterBody;
import com.frcsprep.repo.FrcsMemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    FrcsMemRepo frcsMemRepo;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public  AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName()
                ,authenticationRequest.getPassword())
        );
        FrcsMem frcsMem = frcsMemRepo.findByUserName(authenticationRequest.getUserName());
        var token = jwtService.generateToken(frcsMem);
        return  AuthenticationResponse.builder().token(token).build();
    }

    public  AuthenticationResponse register(RegisterBody registerBody){
        FrcsMem frcsMem = frcsMemRepo.findByUserName(registerBody.getUserName());
        if(Optional.ofNullable(frcsMem).isPresent()){
            return AuthenticationResponse.builder().token("user already exist!!")
                    .build();
        }


        FrcsMem user = FrcsMem.builder()
                        .userName(registerBody.getUserName())
                                .password(passwordEncoder.encode(registerBody.getPassword()))
                                        .roles("USER")
                                                .isActive(1l)
                .build();
        frcsMemRepo.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token)
                .build();
    }

}
