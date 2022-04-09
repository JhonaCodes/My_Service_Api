package app.novacode.myservice.src.persintance.crud;

import app.novacode.myservice.src.persintance.entity.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceCrud extends CrudRepository<Service, Integer> {


    Optional<List<Service>> findByBussId(String businessId);
    Optional<Service> findByServId(Integer serviceId);



}
