package com.soulcode.vendas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rcontroller {
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String hello() {
        return "Hello World!";
    }
}
