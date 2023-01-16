package com.frcsprep.resources;

import com.frcsprep.pojo.AuthenticationRequest;
import com.frcsprep.pojo.AuthenticationResponse;
import com.frcsprep.pojo.RegisterBody;
import com.frcsprep.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frscprep/auth")
public class AuthResource {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterBody requestBody
    ){
       return ResponseEntity.ok(authenticationService.register(requestBody));
    }

    @RequestMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody AuthenticationRequest authRequest
    ){
        return  ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }

}
