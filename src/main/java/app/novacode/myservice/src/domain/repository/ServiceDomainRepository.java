package app.novacode.myservice.src.domain.repository;

import app.novacode.myservice.src.domain.entity.ServiceDomain;

import java.util.List;
import java.util.Optional;

public interface ServiceDomainRepository {


    Optional<ServiceDomain> findServiceById(Integer serviceId);
    Optional<List<ServiceDomain>> findServiceByBusinessId(String businessId);
    ServiceDomain saveService(ServiceDomain serviceDomain);
    ServiceDomain updateService(ServiceDomain serviceDomain);
    void deleteService(Integer idService);



}
