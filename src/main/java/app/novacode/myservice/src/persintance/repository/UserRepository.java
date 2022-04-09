package app.novacode.myservice.src.persintance.repository;

import app.novacode.myservice.src.domain.entity.UserDomain;
import app.novacode.myservice.src.domain.repository.UserDomainRepository;
import app.novacode.myservice.src.persintance.crud.UserCrud;
import app.novacode.myservice.src.persintance.entity.User;
import app.novacode.myservice.src.persintance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepository implements UserDomainRepository {

    @Autowired
    UserCrud userCrud;

    @Autowired
    UserMapper userMapper;



    @Override
    public Optional<UserDomain> findByEmail(String email) {
        return userCrud.findByUsMail(email).map(user -> userMapper.toUserDomain(user));
    }

    @Override
    public Optional<UserDomain> findById(Integer id) {
        return userCrud.findByUsId(id).map(user -> userMapper.toUserDomain(user));
    }


    @Override
    public UserDomain saveUser(UserDomain userDomain) {
        User user = userMapper.toUser(userDomain);
        return userMapper.toUserDomain(userCrud.save(user)) ;
    }


    @Override
    public Integer getTotalUser(){
        return userCrud.getTotalUsers();
    }

    @Override
    public UserDomain getUserById(Integer userId) {
        User user = (User) userCrud.getUserById(userId);
        return userMapper.toUserDomain(user);
    }




}
