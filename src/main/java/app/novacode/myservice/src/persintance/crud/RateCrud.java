package app.novacode.myservice.src.persintance.crud;

import app.novacode.myservice.src.persintance.entity.Rate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface RateCrud extends CrudRepository<Rate, Integer> {

    // Sumar Calificaciones dependiendo del Business ID
    @Query(value = "SELECT SUM(R_Rate) FROM Rate WHERE Business_B_Id = ?", nativeQuery = true)
    Optional<Double> getTotalQualifierByBusinessId(String businessID);


    // Contar Calificaciones Dependiendo del BUsiness ID
    @Query(value = "SELECT COUNT(R_Rate) FROM Rate WHERE Business_B_Id = ?", nativeQuery = true)
    Optional<Double> getTotalRateByBusinessId(String businessID);


    // BUscar Calificaciones dependiendo del BUsinessID
    Optional<List<Rate>> findByRateBusinessId(String businessId);


    // Busar Un Rate Para Modificar
    Optional<Rate> findByMailQualifier(String mail);

}
