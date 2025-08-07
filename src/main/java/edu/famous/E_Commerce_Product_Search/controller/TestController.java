package edu.famous.E_Commerce_Product_Search.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping
public class TestController {
    @GetMapping("test")
    public String hello() {
        log.info("Hello endpoint was called");
        return "Hello, World!";
    }
}
