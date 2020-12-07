package com.example.a24802.demo.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {



    
    @GetMapping("/testHtml")
    public String Test(){
        return "test";
    }   

    @GetMapping("/testHtml2")
    public String Test2(){
        return "test2";
    }   

    @GetMapping("/testHtml3")
    public String Test3(){
        return "test3";
    }   

}
