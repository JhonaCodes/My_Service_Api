package app.novacode.myservice.src.persintance.crud;

import app.novacode.myservice.src.persintance.entity.Business;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BusinessCrud extends CrudRepository<Business, String> {

    Optional<List<Business>> findByBuArea(String buArea);
    Optional<Business> findByUserId(String userId);


    @Query(value = "SELECT * FROM Business WHERE B_Name LIKE %?% ", nativeQuery = true)
    Optional<List<Business>> getByNameContains(String buName);

    Optional<Business> findByBusId(String buId);



}
