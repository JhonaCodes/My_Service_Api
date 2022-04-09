package app.novacode.myservice.src.persintance.mapper;


import app.novacode.myservice.src.domain.entity.RateDomain;
import app.novacode.myservice.src.persintance.entity.Rate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mappings({
            @Mapping(source = "rateId", target = "rateID"),
            @Mapping(source = "rateBusinessId", target = "businessID"),
            @Mapping(source = "rateBusiness", target = "rate"),
            @Mapping(source = "mailQualifier", target = "mailRated")
    })
    RateDomain toRateDomain(Rate rate);


    List<RateDomain> toRateDomainList(List<Rate> rateList);

    @InheritInverseConfiguration
    Rate toRate(RateDomain rateDomain);
}
