package app.novacode.myservice.src.domain.service;


import app.novacode.myservice.src.domain.entity.ServiceDomain;
import app.novacode.myservice.src.domain.repository.ServiceDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceToService {


    @Autowired
    ServiceDomainRepository serviceDomainRepository;


    public Optional<ServiceDomain> findServiceById(Integer serviceId){
        return serviceDomainRepository.findServiceById(serviceId);
    }



    public Optional<List<ServiceDomain>> findServiceByIdBusiness(String businessId){
        return serviceDomainRepository.findServiceByBusinessId(businessId);
    }


    public ServiceDomain saveService(ServiceDomain serviceDomain){
        return serviceDomainRepository.saveService(serviceDomain);
    }

    public  ServiceDomain updateService(ServiceDomain serviceDomain){
        return serviceDomainRepository.updateService(serviceDomain);
    }

   public boolean deleteService(Integer serviceId){
        return findServiceById(serviceId).map(serviceDomain -> {
            serviceDomainRepository.deleteService(serviceId);
            return true;
        }).orElse(false);
    }

}
