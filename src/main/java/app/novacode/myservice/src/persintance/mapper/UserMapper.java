package app.novacode.myservice.src.persintance.mapper;


import app.novacode.myservice.src.domain.entity.UserDomain;
import app.novacode.myservice.src.persintance.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface UserMapper {



    @Mappings({

            @Mapping(source = "usId", target = "userId"),
            @Mapping(source = "usName", target = "userFirstName"),
            @Mapping(source = "usSecondName", target = "userSecondName"),
            @Mapping(source = "usCity", target = "userCity"),
            @Mapping(source = "usMail", target = "userMail"),
            @Mapping(source = "usPhone", target = "userPhone"),
            @Mapping(source = "usPassword", target = "userPassword"),
            @Mapping(source = "usRol", target = "userRol")

    })
    UserDomain toUserDomain(User user);


    @InheritInverseConfiguration
    User toUser(UserDomain userDomain);

}
