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


        return userService.saveUser(userDomain);
        //@ModelAttribute
    }


//    @PostMapping("/seller")
//    public Map<String, Object> saveSeller(@ModelAttribute Map<String, Object> sellerBusiness){
//
//        UserDomain userDomain = new UserDomain();
//        BusinessDomain businessDomain = new BusinessDomain();
//        Map<String, Object> response = new HashMap<>();
//
//        // Creando datos de Usuario
//
//        userDomain.setUserFirstName(sellerBusiness.get("userFirstName").toString());
//        userDomain.setUserSecondName(sellerBusiness.get("userSecondName").toString());
//        userDomain.setUserMail(sellerBusiness.get("userMail").toString());
//        userDomain.setUserRol(sellerBusiness.get("userRol").toString());
//        userDomain.setUserPhone(sellerBusiness.get("userPhone").toString());
//        userDomain.setUserCity(sellerBusiness.get("userCity").toString());
//        userDomain.setUserPassword(sellerBusiness.get("userPassword").toString());
//
//        if(saveUser(userDomain).getUserId() != null){
//
//            UserDomain newUser = findUserByEmail(userDomain.getUserMail()).get();
//
//            businessDomain.setBusinessArea(sellerBusiness.get("businessArea").toString());
//            businessDomain.setBusinessName(sellerBusiness.get("businessName").toString());
//            businessDomain.setBusinessWebsite(sellerBusiness.get("businessWebsite").toString());
//            businessDomain.setBusinessAbout(sellerBusiness.get("businessAbout").toString());
//            businessDomain.setImageUrl((byte[]) sellerBusiness.get("imageUrl"));
//            businessDomain.setSellerId( String.valueOf(newUser.getUserId()) );
//
//
//            if( !businessService.saveBusiness(businessDomain).getBusinessId().isEmpty() ){
//
//                response.put("response", "Seller: " + userDomain.getUserFirstName() + " Created and Business " + businessDomain.getBusinessName());
//
//            }else{
//                response.put("response", "Problem for create Business");
//            }
//
//
//        }else{
//            response.put("response", "Problem for create Account");
//        }
//
//        // Save User Data
//        return response;
//
//    }

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
