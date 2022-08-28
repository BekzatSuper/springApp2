package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model){
        System.out.println(name+" "+surname);
        model.addAttribute("message",name+" "+surname);
        return "first/hello_world";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,@RequestParam("b") int b, @RequestParam("action") String action, Model model){
        double result=0;

        switch (action){
            case "mult":
                result=a*b;
                break;
            case "div":
                result=a/b;
                break;
            case "sub":
                result=a-b;
                break;
            case "add":
                result=a+b;
                break;
        }
        model.addAttribute("result", result);

        return "/first/calculator";
    }
}
