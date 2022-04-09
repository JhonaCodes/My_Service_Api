package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.UserDomain;
import app.novacode.myservice.src.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping("/account/{mail}")
    Optional<UserDomain> findUserByEmail(@PathVariable("mail") String email){
        return userService.getUserByEmail(email);
    }



    @GetMapping("/{id}")
    Optional<UserDomain> findUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }





    @PostMapping
    public UserDomain saveUser(@RequestBody UserDomain userDomain){

        return userService.saveUser(userDomain);
        //@ModelAttribute


    }









}
