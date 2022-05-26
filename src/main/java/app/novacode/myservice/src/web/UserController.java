package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.domain.entity.UserDomain;
import app.novacode.myservice.src.domain.service.BusinessService;
import app.novacode.myservice.src.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    BusinessService businessService;

    @Autowired
    UserService userService;


    @GetMapping("/account/{mail}")
    Optional<UserDomain> findUserByEmail(@PathVariable("mail") String email){
        return userService.getUserByEmail(email);
    }


    @GetMapping("/login/{mail}/{password}")
    Map<String, Object> isValidUser(@PathVariable("mail") String mail, @PathVariable("password") String password ){
        return userService.isValidUser(mail,password);
    }


    @GetMapping("/{id}")
    Optional<UserDomain> findUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/validate/{mail}")
    Map<String, Object> existEMail(@PathVariable("mail") String mail){
        Map<String, Object> validation = new HashMap<String, Object>();

        validation.put("existMail", userService.getUserByEmail(mail).isPresent());


        return validation;

    }


    @PostMapping("/body")
    public UserDomain saveUser(@RequestBody UserDomain userDomain){


        if(userService.getUserByEmail(userDomain.getUserMail()).isEmpty()){

            return userService.saveUser(userDomain);

        }else{

            return null;
        }


        //@ModelAttribute
    }



    @PutMapping
    public Map<String, String> updatePasswordUser(@RequestBody UserDomain userDomain){

        Map<String, String> susses = new HashMap<>();
        UserDomain newUser = findUserByEmail(userDomain.getUserMail()).get();

        newUser.setUserPassword(userDomain.getUserPassword());

        userDomain = newUser;
        userService.saveUser(userDomain);


        susses.put("statusPassword", "Password Changed Successful :)");

      return susses;
    }










}
