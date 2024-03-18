package com.example.makemytripms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class holiday {
    @GetMapping("/holiday")
    public String getData() {return  "Please book holidays package from 500 to 10000" ; }

}