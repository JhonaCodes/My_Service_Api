package app.novacode.myservice.src.persintance.repository;


import app.novacode.myservice.src.domain.entity.ServiceDomain;
import app.novacode.myservice.src.domain.repository.ServiceDomainRepository;
import app.novacode.myservice.src.persintance.crud.ServiceCrud;
import app.novacode.myservice.src.persintance.entity.Service;
import app.novacode.myservice.src.persintance.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiceRepository implements ServiceDomainRepository {

    @Autowired
    ServiceCrud serviceCrud;

    @Autowired
    ServiceMapper serviceMapper;

    @Override
    public Optional<ServiceDomain> findServiceById(Integer serviceId) {

        Optional<Service> service = (Optional<Service>) serviceCrud.findByServId(serviceId);

        return service.map(service1 -> serviceMapper.toServiceDomain(service1));
    }

    @Override
    public Optional<List<ServiceDomain>> findServiceByBusinessId(String businessId) {
        Optional<List<Service>> serviceList = (Optional<List<Service>>) serviceCrud.findByBussId(businessId);
        return serviceList.map(services -> serviceMapper.toServiceDomainList(services));
    }

    @Override
    public ServiceDomain saveService(ServiceDomain serviceDomain) {
        Service service = (Service) serviceMapper.toService(serviceDomain);
        return serviceMapper.toServiceDomain(serviceCrud.save(service)) ;
    }

    @Override
    public ServiceDomain updateService(ServiceDomain serviceDomain) {
        Service service  = (Service) serviceMapper.toService(serviceDomain);

        return serviceMapper.toServiceDomain(serviceCrud.save(service));
    }

    @Override
    public void deleteService(Integer idService) {

        serviceCrud.deleteById(idService);

    }



}
