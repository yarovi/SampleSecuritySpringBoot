package org.yasmani.io.appsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yasmani.io.appsecurity.dto.LoginDTO;
import org.yasmani.io.appsecurity.dto.RegisterDTO;

@RestController
@RequestMapping("api/auth")
public class SecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto)
    {

        logger.info("Registering user {}", dto.getUsername());
        return new ResponseEntity<>("The user was create", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto)
    {
        logger.info("Login user {}", dto.getUsername());
        return new ResponseEntity<>("The user was login", HttpStatus.OK);
    }

}
