package com.example.a24802.demo.API;

import java.util.ArrayList;

import com.example.a24802.demo.Model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostViewController {
    @GetMapping("/posts")
    public ModelAndView GetAll(@RequestParam( name="userId", required=false,defaultValue="0") int userId){
        ArrayList<Post> result = PostController.getPostsByUserId(userId);
        
        ModelAndView mv = new ModelAndView("listPosts");
        mv.addObject("posts", result);
        return mv;
    }
}
