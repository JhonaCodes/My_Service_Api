package app.novacode.myservice.src.persintance.mapper;


import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.persintance.entity.Business;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessMapper {


    @Mappings({
            @Mapping(source = "busId", target = "businessId"),
            @Mapping(source = "buArea", target = "businessArea"),
            @Mapping(source = "buName", target = "businessName"),
            @Mapping(source = "buWebsite", target = "businessWebsite"),
            @Mapping(source = "buAbout", target = "businessAbout"),
            @Mapping(source = "buImageUrl", target = "imageUrl"),
            @Mapping(source = "userId", target = "sellerId"),
            @Mapping(source = "dataUser", target = "sellerData"),
            @Mapping(target = "imageByte", ignore = true)
    })

    BusinessDomain toBusinessDomain(Business business);

    List<BusinessDomain> toBusinessDomainList(List<Business> businessList);


    @InheritInverseConfiguration
    Business toBusiness(BusinessDomain businessDomain);



}
