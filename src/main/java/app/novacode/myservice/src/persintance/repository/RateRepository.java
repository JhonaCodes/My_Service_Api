package app.novacode.myservice.src.persintance.repository;


import app.novacode.myservice.src.domain.entity.RateDomain;
import app.novacode.myservice.src.domain.repository.RateDomainRepository;
import app.novacode.myservice.src.persintance.crud.RateCrud;
import app.novacode.myservice.src.persintance.entity.Rate;
import app.novacode.myservice.src.persintance.mapper.RateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RateRepository implements RateDomainRepository {


    @Autowired
    RateCrud rateCrud;

    @Autowired
    RateMapper rateMapper;


    @Override
    public Optional<Double> getTotalQualifierByBusinessId(String businessID) {
        return rateCrud.getTotalQualifierByBusinessId(businessID);
    }

    @Override
    public Optional<Double> getTotalRateByBusinessID(String businessID) {
        return rateCrud.getTotalRateByBusinessId(businessID);
    }

    @Override
    public Optional<List<RateDomain>> getListRatesByBusinessId(String businessID) {
        Optional<List<Rate>> rateBusiness =  (Optional<List<Rate>>)  rateCrud.findByRateBusinessId(businessID);
        return rateBusiness.map(businessesMap -> rateMapper.toRateDomainList(businessesMap));
    }

    @Override
    public Optional<RateDomain> getRateByEmail(String email) {
        Optional<Rate> rateDomain = (Optional<Rate>) rateCrud.findByMailQualifier(email);

        return rateDomain.map(rate -> rateMapper.toRateDomain(rate));
    }

    @Override
    public RateDomain saveBusinessId(RateDomain rateDomain) {
        Rate rate = rateMapper.toRate(rateDomain);
        return rateMapper.toRateDomain(rateCrud.save(rate));
    }

    @Override
    public RateDomain updateRate(RateDomain rateDomain) {

        Rate rate = rateMapper.toRate(rateDomain);

        return rateMapper.toRateDomain(rateCrud.save(rate));
    }
}
