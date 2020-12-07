package com.example.a24802.demo.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.a24802.demo.Model.PagedResults;
import com.example.a24802.demo.Model.User;
import com.example.a24802.demo.Model.UserV2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsersController {

    public static ArrayList<User> Hello() {
        ArrayList<User> usuarios = new ArrayList<User>();
        User persona1 = new User(12, "Cesar");
        User persona2 = new User(11, "Alberto");
        User persona3 = new User(1, "Alba");
        User persona4 = new User(7, "Sara");
        usuarios.add(persona1);
        usuarios.add(persona2);
        usuarios.add(persona3);
        usuarios.add(persona4);

        return usuarios;

    }

    @GetMapping("/v2/users/{id}")
    public User UserById(@PathVariable("id") int id) {
        return findById(id);
    }

    /*
     * @GetMapping("/users/{id}") public ResponseEntity<User>
     * UserById(@PathVariable("id") int id){ try{ return new
     * ResponseEntity<>(findById(id), HttpStatus.OK); }catch(Exception ex){ return
     * new ResponseEntity<>(HttpStatus.NOT_FOUND); }
     */
    /* } */
    /*
     * ArrayList<User> usuarios = Hello(); for(User elemento : usuarios){
     * if(elemento.getId()==id){ return elemento; }
     * 
     * } return null;
     */

    public static User findById(int id) {
            ArrayList<User> usuarios = Hello();

        for (User user : usuarios) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /*
     * @PostMapping("/users") public User Add(@RequestBody User newUser){
     * usuarios.add(newUser); return newUser; }
     */

/*     @PostMapping("/v2/users")
    public User Add(@RequestBody User newUser) {
        usuarios.add(newUser);
        return newUser;
    }
 */

   /*  @PutMapping("/v2/users/{id}")
    public User Update(@RequestBody User updateUser, @PathVariable("id") int id) {
        for (User elemento : usuarios) {
            if (elemento.getId() == id) {
                elemento.setName(updateUser.getName());
                return elemento;
            }
        }
        return null;
    }

    @DeleteMapping("/v2/users/{id}")
    public void Delete(@PathVariable("id") int id) {
        for (User elemento : usuarios) {
            if (elemento.getId() == id) {
                usuarios.remove(elemento);
            }
        }
    } */

    public static List<UserV2> users = Arrays.asList(new UserV2(1, "Usuario 1", "en-US"),
            new UserV2(2, "Usuario 2", "es-ES"), new UserV2(3, "Usuario 3", "en-US"),
            new UserV2(4, "Usuario 4", "es-ES"), new UserV2(5, "Usuario 5", "es-ES")

    );

    @GetMapping("/v2/users")
    public ModelAndView UserV2(){
        ModelAndView mv = new ModelAndView("listUsers");
        mv.addObject("users", users);
        return mv;
    }

    /*
     * @GetMapping("/v1/users") public List<User> Users(){ return new
     * ArrayList<User>(users);
     * 
     * //List<User> users = new ArrayList<User>(); // for (User user : userList) {
     * // users.add(new User(user)); // } // return users; }
     * 
     * @GetMapping("/v2/users") public List<UserV2> UsersV2(){
     * 
     * 
     * 
     * return users; }
     * 
     * @GetMapping("/v2/users/paged/{pageNumber}") public PagedResults<UserV2>
     * UsersV2(@PathVariable("pageNumber") int pageNumber){ return null;// new
     * PagedResults<UserV2>(users, "/v2/users/paged/", pageNumber);
     * 
     * }
     * 
     */
}
