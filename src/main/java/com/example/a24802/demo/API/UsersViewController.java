package com.example.a24802.demo.API;

import java.util.Locale;
import java.util.ResourceBundle;

import com.example.a24802.demo.Model.User;
import com.example.a24802.demo.Model.UserV2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class UsersViewController {
    @GetMapping("/test")
    public String Test(Locale locale) {
        var messages = ResourceBundle.getBundle("i18n\\messages", locale);
        return messages.getString("Main.Hello");

    }

    @GetMapping("/users")
    public ModelAndView UsersV2(){
        ModelAndView mv = new ModelAndView("listUsers");
        mv.addObject("users", UsersController.users);
        return mv;
    }

    @GetMapping("/users/new")
    public ModelAndView CreateUser(){
        ModelAndView mv = new ModelAndView("detailUsers");
        mv.addObject("user", new UserV2());
        return mv;
    }

    @PostMapping("/v2/users")
    public String Add(@RequestBody UserV2 newUser){
        UsersController.users.add(new UserV2(newUser.getId(),newUser.getName(), "es-ES"));
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView EditUser(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("detailUsers");
        mv.addObject("user", UsersController.findById(id));
        return mv;
    }
    @PutMapping("/v2/users/{id}")
    public User Update(@RequestBody User UpdateUser,
                        @PathVariable("id") int id){

                                User u = UsersController.findById(id);
                                u.setName(UpdateUser.getName());
                                return u;
                        }
        
}
