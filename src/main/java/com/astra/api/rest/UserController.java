package com.astra.api.rest;

import com.astra.api.exception.UsernameAlreadyTaken;
import com.astra.api.exception.UsernameMustBeFilled;
import com.astra.core.dto.user.UserCreateEdit;
import com.astra.security.authority.Role;
import com.astra.security.config.SecurityConfiguration;
import com.astra.core.service.UserService;
import com.astra.security.jwt.JwtUser;
import com.astra.security.jwt.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService service;
    private final SecurityConfiguration securityService;

    public UserController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService service, SecurityConfiguration securityService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.service = service;
        this.securityService = securityService;
    }

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody UserCreateEdit request) {
        request.setRole(Role.USER);
        service.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authentication (@RequestBody JwtUser jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid Username or Password");
        }
        return ResponseEntity.ok(jwtUtil.generateToken(jwtRequest.getUsername()));
    }




}