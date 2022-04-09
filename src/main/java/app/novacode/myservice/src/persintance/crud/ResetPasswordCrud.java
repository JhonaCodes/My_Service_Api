package app.novacode.myservice.src.persintance.crud;

import app.novacode.myservice.src.persintance.entity.ResetPassword;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResetPasswordCrud extends CrudRepository<ResetPassword, Integer> {

    Optional<ResetPassword> findByResetCR(String codeReset);
    Optional<Boolean> findByResetCRAndResetSC(String codeReset, String statusCode);

}
