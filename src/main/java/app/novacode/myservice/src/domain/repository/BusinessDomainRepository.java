package app.novacode.myservice.src.domain.repository;

import app.novacode.myservice.src.domain.entity.BusinessDomain;

import java.util.List;
import java.util.Optional;

public interface BusinessDomainRepository {


    Optional<List<BusinessDomain>> findByArea(String area);
    Optional<BusinessDomain> findByIdUser(String userId);
    Optional<List<BusinessDomain>> findByName(String businessName);
    Optional<BusinessDomain> findByIdBusiness(String businessId);

    BusinessDomain saveBussiness(BusinessDomain business);
    void deleteBusiness(String businessId);
    void updateBusiness(String businessId);


}
