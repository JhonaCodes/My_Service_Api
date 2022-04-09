package app.novacode.myservice.src.domain.repository;

import app.novacode.myservice.src.domain.entity.RateDomain;

import java.util.List;
import java.util.Optional;

public interface RateDomainRepository {


    Optional<Double> getTotalQualifierByBusinessId(String BusinessID);
    Optional<Double> getTotalRateByBusinessID(String BusinessID);

    Optional<List<RateDomain>> getListRatesByBusinessId(String BusinessID);
    Optional<RateDomain> getRateByEmail(String email);
    RateDomain saveBusinessId(RateDomain rateDomain);
    RateDomain updateRate(RateDomain rateDomain);


}
