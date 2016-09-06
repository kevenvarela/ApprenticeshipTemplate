package com.tenpines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {

        return "test";
    }

    @RequestMapping(value = "/home")
    public String page1() {

        return "test2";
    }
}