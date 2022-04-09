package app.novacode.myservice.src.domain.service;


import app.novacode.myservice.src.domain.entity.RateDomain;
import app.novacode.myservice.src.domain.repository.RateDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateService {

    @Autowired
    RateDomainRepository rateDomainRepository;

    public Optional<Double> getTotalRates(String businessID){
        return rateDomainRepository.getTotalRateByBusinessID(businessID);
    }

    public Optional<Double> getTotalQualifier(String busionessID){
        return rateDomainRepository.getTotalQualifierByBusinessId(busionessID);
    }

    public Optional<List<RateDomain>> getListRates(String businessID){
        return rateDomainRepository.getListRatesByBusinessId(businessID);
    }

    public Optional<RateDomain> getRateByEmail(String mail){
        return rateDomainRepository.getRateByEmail(mail);
    }

    public RateDomain saveRate(RateDomain rateDomain){
        return rateDomainRepository.saveBusinessId(rateDomain);
    }

    public RateDomain updateRate(RateDomain rateDomain){
        return rateDomainRepository.saveBusinessId(rateDomain);
    }




}
