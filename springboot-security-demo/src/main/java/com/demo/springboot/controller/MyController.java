package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

    private static final String PREFIX = "pages/";

    @GetMapping
    public String index() {
        return "welcome";
    }

    @GetMapping("/userlogin")
    public String loginPage() {
        return PREFIX.concat("login");
    }

    @GetMapping("/level1/{path}")
    public String level1(@PathVariable String path) {
        return PREFIX.concat("level1/").concat(path);
    }

    @GetMapping("/level2/{path}")
    public String level2(@PathVariable String path) {
        return PREFIX.concat("level2/").concat(path);
    }

    @GetMapping("/level3/{path}")
    public String level3(@PathVariable String path) {
        return PREFIX.concat("level3/").concat(path);
    }

}
