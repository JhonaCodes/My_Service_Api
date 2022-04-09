package app.novacode.myservice.src.persintance.repository;


import app.novacode.myservice.src.domain.entity.ResetPasswordDomain;
import app.novacode.myservice.src.domain.repository.ResetPasswordDomainRespository;
import app.novacode.myservice.src.persintance.crud.ResetPasswordCrud;
import app.novacode.myservice.src.persintance.entity.ResetPassword;
import app.novacode.myservice.src.persintance.mapper.ResetPasswordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ResetPasswordRepository implements ResetPasswordDomainRespository {

    @Autowired
    ResetPasswordCrud resetPasswordCrud;


    @Autowired
    ResetPasswordMapper resetPasswordMapper;


    @Override
    public Optional<ResetPasswordDomain> getResetCode(String resetCode) {

        Optional<ResetPassword> resetPassword = (Optional<ResetPassword>) resetPasswordCrud.findByResetCR(resetCode);

        return resetPassword.map(resetPassword1 -> resetPasswordMapper.toResetPasswordDomain(resetPassword1));
    }

    @Override
    public Optional<Boolean> isCOdeActive(String codeReset, String statusCode) {

        if(resetPasswordCrud.findByResetCRAndResetSC(codeReset, statusCode).isEmpty()) {
            return Optional.of(false);

        }else {
            return Optional.of(true);
        }

    }

    @Override
    public ResetPasswordDomain saveResetCode(ResetPasswordDomain resetPasswordDomain) {



        ResetPassword resetPassword = (ResetPassword) resetPasswordMapper.toResetPasword(resetPasswordDomain);

        return resetPasswordMapper.toResetPasswordDomain(resetPasswordCrud.save(resetPassword));
    }

    @Override
    public ResetPasswordDomain updateResetCode(ResetPasswordDomain resetPasswordDomain) {
        ResetPassword resetPassword = (ResetPassword) resetPasswordMapper.toResetPasword(resetPasswordDomain);
        return resetPasswordMapper.toResetPasswordDomain(resetPasswordCrud.save(resetPassword));
    }

}
