package com.example.a24802.demo.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.a24802.demo.Model.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private static ArrayList<Post> posts = new ArrayList<Post>(Arrays.asList(
        new Post(12,1,"Post con foto"),
        new Post(1,2,"Post con video"),
        new Post(1,1,"Post con todo"),
        new Post(12,3,"Post Especial"),
        new Post(1,4,"Post de Juego")


    ));

        public static ArrayList<Post> getPostsByUserId(int userId){
            ArrayList<Post> result = posts;
            if(userId!=0){
                result = new ArrayList<Post>();
                for(Post post : posts){
                    if(post.getUserId()==userId)
                    result.add(post);

                }
            }


            return result;
        }
       
       //GET/{ID}//
       @GetMapping("/posts/{id}")
       public Post findById(@PathVariable("id") int id){
           for(Post element : posts){
               if(element.getId()==id){
                   return element;
               }
           }
           return null;
       }
     
    }






