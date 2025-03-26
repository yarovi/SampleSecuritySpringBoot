package org.yasmani.io.appsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/data")
public class HelloController
{
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/hello")
    public String hello()
    {
        logger.info("Hello World");
        return "Hello World";
    }
}
