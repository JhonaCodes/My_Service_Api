package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.ResetPasswordDomain;
import app.novacode.myservice.src.domain.service.EmailSenderService;
import app.novacode.myservice.src.domain.service.MD5Generator;
import app.novacode.myservice.src.domain.service.ResetPasswordService;
import app.novacode.myservice.src.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/reset_password")
public class ResetPasswordController {


    @Autowired
    ResetPasswordService resetPasswordService;


    @Autowired
    private EmailSenderService emailSenderService;



    @Autowired
    UserService userService;

    @GetMapping("/{code}/{status}")
    public Optional<Boolean> ifCodeActive(@PathVariable("code") String codeReset, @PathVariable("status") String status){
        return resetPasswordService.isCOdeActive(codeReset, status);
    }


    @GetMapping("/info_code/{reset_code}")
    public Optional<ResetPasswordDomain> getCodeInfo(@PathVariable("reset_code") String code){
        return resetPasswordService.getResetCode(code);
    }



    @PostMapping
    public String resetPasswordDomain(@RequestBody ResetPasswordDomain resetPasswordDomain) throws NoSuchAlgorithmException {
        long actualTime = System.nanoTime();

        resetPasswordDomain.setCodeReset(MD5Generator.recoveryCode(actualTime));
        resetPasswordDomain.setCodeStatus("Active");

        ResponseEntity<ResetPasswordDomain> isCreated = new ResponseEntity<ResetPasswordDomain>(resetPasswordService.saveResetPassword(resetPasswordDomain), HttpStatus.CREATED);

        if(userService.getUserByEmail(resetPasswordDomain.getEmailReset()).isPresent()) {

            if (isCreated.getStatusCode() == (HttpStatus.CREATED)) {

                emailSenderService.sendSimpleEmail(
                        resetPasswordDomain.getEmailReset(),
                        "This Is Your Code: \n\n" + resetPasswordDomain.getCodeReset() + "\n\nNova Code Service\nPlease no replay to this email thanks ",
                        "Your Code is " + resetPasswordDomain.getCodeStatus() + " for reset your password");
                return "Recovery Code Sended Suscefull to: " + resetPasswordDomain.getEmailReset() + " Please open your email";

            } else {

                // No se pudo crear
                return "Can't Send Recovery Code to: " + resetPasswordDomain.getEmailReset() ;

            }

        }else{

            // User no existe
            return "The mail: " + resetPasswordDomain.getEmailReset() + " No exist\n Create a new account";

        }


    }



//    @PostMapping("/new")
//    public ResetPasswordDomain create(@RequestBody ResetPasswordDomain resetPasswordDomain){
//        return resetPasswordService.updateResetPassword(resetPasswordDomain);
//    }

    @PutMapping
    public ResetPasswordDomain updateStatusCode(@ModelAttribute ResetPasswordDomain resetPasswordDomain){
        return resetPasswordService.updateResetPassword(resetPasswordDomain);
    }




}
