package app.novacode.myservice.src.domain.service;


import app.novacode.myservice.src.domain.entity.UserDomain;
import app.novacode.myservice.src.domain.repository.UserDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserDomainRepository userDomainRepository;


    public Optional<UserDomain> getUserByEmail(String email){
        return userDomainRepository.findByEmail(email);
    }



    public Optional<UserDomain> getUserById(Integer id){
        return userDomainRepository.findById(id);
    }




    public UserDomain saveUser(UserDomain userDomain){

        return userDomainRepository.saveUser(userDomain);
    }


    public Integer getTotalUsers(){
        return userDomainRepository.getTotalUser();
    }

    public UserDomain getUserById2(Integer userId){
        return userDomainRepository.getUserById(userId);
    }

}
