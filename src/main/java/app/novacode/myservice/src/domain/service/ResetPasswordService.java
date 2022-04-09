package app.novacode.myservice.src.domain.service;


import app.novacode.myservice.src.domain.entity.ResetPasswordDomain;
import app.novacode.myservice.src.domain.repository.ResetPasswordDomainRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResetPasswordService {

    @Autowired
    ResetPasswordDomainRespository respository;


    public Optional<ResetPasswordDomain> getResetCode(String resetCode){
        return respository.getResetCode(resetCode);
    }


    public Optional<Boolean> isCOdeActive(String codeReset, String statusCode){
        return respository.isCOdeActive(codeReset, statusCode);
    }

    public ResetPasswordDomain saveResetPassword(ResetPasswordDomain resetPasswordDomain){
        return respository.saveResetCode(resetPasswordDomain);
    }

    public ResetPasswordDomain updateResetPassword(ResetPasswordDomain resetPasswordDomain){
        return respository.updateResetCode(resetPasswordDomain);
    }
}
