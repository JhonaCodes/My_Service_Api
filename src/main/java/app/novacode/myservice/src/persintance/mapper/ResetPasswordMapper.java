package app.novacode.myservice.src.persintance.mapper;


import app.novacode.myservice.src.domain.entity.ResetPasswordDomain;
import app.novacode.myservice.src.persintance.entity.ResetPassword;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = BusinessMapper.class)
public interface ResetPasswordMapper {

    @Mappings({

            @Mapping(source = "resetID", target = "idReset"),
            @Mapping(source = "resetCR", target = "codeReset"),
            @Mapping(source = "resetSC", target = "codeStatus"),
            @Mapping(source = "resetM", target  = "emailReset")


    })
    ResetPasswordDomain toResetPasswordDomain(ResetPassword resetPassword);

    @InheritInverseConfiguration
    ResetPassword toResetPasword(ResetPasswordDomain resetPasswordDomain);
}
