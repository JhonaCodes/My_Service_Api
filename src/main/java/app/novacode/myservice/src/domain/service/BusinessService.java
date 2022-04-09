package app.novacode.myservice.src.domain.service;


import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.domain.repository.BusinessDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {


    @Autowired
    BusinessDomainRepository businessDomainRepository;


    public Optional<BusinessDomain> findByBusinessId(String businessID){
        return businessDomainRepository.findByIdBusiness(businessID);
    }


    public Optional<List<BusinessDomain>> findByBusinessArea(String businessArea){
        return businessDomainRepository.findByArea(businessArea);
    }

    public Optional<BusinessDomain> findByUserId(String userId){
        return businessDomainRepository.findByIdUser(userId);
    }


    public Optional<List<BusinessDomain>> findByName(String businessName){
        return businessDomainRepository.findByName(businessName);
    }


    public BusinessDomain saveBusiness(BusinessDomain businessDomain){
        return businessDomainRepository.saveBussiness(businessDomain);
    }

    public boolean deleteBusiness(String businessId){
        return findByBusinessId(businessId).map(businessDeletrDomain -> {
            businessDomainRepository.deleteBusiness(businessId);
            return true;
        }).orElse(false);
    }


}
