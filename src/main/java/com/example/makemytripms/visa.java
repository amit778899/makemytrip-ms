package com.example.makemytripms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class visa {
    @GetMapping("/visa")
    public String getData() {return  "Please book visa from 500 to 5000" ; }
}
