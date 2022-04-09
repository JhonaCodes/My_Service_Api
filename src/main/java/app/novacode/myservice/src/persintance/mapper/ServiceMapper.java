package app.novacode.myservice.src.persintance.mapper;


import app.novacode.myservice.src.domain.entity.ServiceDomain;
import app.novacode.myservice.src.persintance.entity.Service;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = BusinessMapper.class)
public interface ServiceMapper {


    @Mappings({
            @Mapping(source = "servId", target = "idService"),
            @Mapping(source = "bussId", target = "idBusiness"),
            @Mapping(source = "servName", target = "nameService"),
            @Mapping(source = "seSpecification", target = "specializationService"),
            @Mapping(source = "servPrice", target = "priceService"),
            @Mapping(source = "servContact", target = "contactService"),
            @Mapping(source = "businessID", target = "businessData")
    })

    ServiceDomain toServiceDomain(Service service);

    List<ServiceDomain> toServiceDomainList(List<Service> serviceDomainList);

    @InheritInverseConfiguration
    Service toService(ServiceDomain serviceDomain);


}
