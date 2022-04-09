package app.novacode.myservice.src.domain.repository;

import app.novacode.myservice.src.domain.entity.UserDomain;

import java.util.Optional;

public interface UserDomainRepository {

    Optional<UserDomain> findByEmail(String email);
    Optional<UserDomain> findById(Integer id);
    UserDomain saveUser(UserDomain userDomain);
    Integer getTotalUser();
    UserDomain getUserById(Integer userId);



}
