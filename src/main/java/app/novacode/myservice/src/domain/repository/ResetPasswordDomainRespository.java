package app.novacode.myservice.src.domain.repository;

import app.novacode.myservice.src.domain.entity.ResetPasswordDomain;

import java.util.Optional;

public interface ResetPasswordDomainRespository {

    Optional<ResetPasswordDomain> getResetCode(String resetCode);
    Optional<Boolean> isCOdeActive(String codeReset, String statusCode);
    ResetPasswordDomain saveResetCode(ResetPasswordDomain resetPasswordDomain);
    ResetPasswordDomain updateResetCode(ResetPasswordDomain resetPasswordDomain);

}
