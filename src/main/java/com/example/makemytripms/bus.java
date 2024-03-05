package com.example.makemytripms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bus {
    @GetMapping("/bus")
    public String getData() {return  "Please book bus from 900 to 5000:" ; }
}
