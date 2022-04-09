package app.novacode.myservice.src.persintance.crud;

import app.novacode.myservice.src.persintance.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrud extends CrudRepository<User, String> {

    Optional<User> findByUsMail(String email);
    Optional<User> findByUsId(Integer userId);
    @Query(value = "SELECT COUNT(*) FROM User", nativeQuery = true)
    Integer getTotalUsers();

    @Query(value = "SELECT U_Id FROM User WHERE U_Id = ?", nativeQuery = true)
    User getUserById(Integer userId);
}
