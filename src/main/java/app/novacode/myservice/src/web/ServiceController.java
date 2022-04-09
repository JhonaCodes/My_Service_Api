package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.ServiceDomain;
import app.novacode.myservice.src.domain.service.ServiceToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class ServiceController {


    @Autowired
    ServiceToService serviceRepository;


    @GetMapping("/{idService}")
    public Optional<ServiceDomain> getServiceById(@PathVariable("idService") Integer serviceID){
        return serviceRepository.findServiceById(serviceID);
    }


    @GetMapping("/business/{businessId}")
    public Optional<List<ServiceDomain>> getServiceByBusinessId(@PathVariable("businessId") String businessId){
        return serviceRepository.findServiceByIdBusiness(businessId);
    }


    @PostMapping
    public ServiceDomain saveService(@ModelAttribute ServiceDomain serviceDomain){
        return serviceRepository.saveService(serviceDomain);
    }


    @PutMapping
    public ServiceDomain updateService(@ModelAttribute ServiceDomain serviceDomain){
        return serviceRepository.updateService(serviceDomain);
    }



    @DeleteMapping
    public boolean deleteSerice(Integer serviceid){

        return serviceRepository.deleteService(serviceid);

    }



}
