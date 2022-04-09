package app.novacode.myservice.src.persintance.repository;


import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.domain.repository.BusinessDomainRepository;
import app.novacode.myservice.src.persintance.crud.BusinessCrud;
import app.novacode.myservice.src.persintance.entity.Business;
import app.novacode.myservice.src.persintance.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BusinessRepository implements BusinessDomainRepository {


    @Autowired
    BusinessCrud businessCrud;


    @Autowired
    BusinessMapper businessMapper;


    @Override
    public Optional<List<BusinessDomain>> findByArea(String area) {

        Optional<List<Business>> businesses =  (Optional<List<Business>>)  businessCrud.findByBuArea(area);
        return businesses.map(businessesMap -> businessMapper.toBusinessDomainList(businessesMap));
    }

    @Override
    public Optional<List<BusinessDomain>> findByName(String businessName) {

        Optional<List<Business>> businessList = (Optional<List<Business>>) businessCrud.getByNameContains(businessName);

        return businessList.map(businessList1 -> businessMapper.toBusinessDomainList(businessList1));
    }

    @Override
    public Optional<BusinessDomain> findByIdUser(String userId) {

        Optional<Business> businessList = businessCrud.findByUserId(userId);
        return businessList.map(businessList1 -> businessMapper.toBusinessDomain(businessList1));
    }



    @Override
    public Optional<BusinessDomain> findByIdBusiness(String businessId) {
        Optional<Business> businessDomain = (Optional<Business>) businessCrud.findByBusId(businessId);
        return businessDomain.map(business -> businessMapper.toBusinessDomain(business));
    }

    @Override
    public BusinessDomain saveBussiness(BusinessDomain business) {
        Business business1 = businessMapper.toBusiness(business);
        return businessMapper.toBusinessDomain(businessCrud.save(business1));
    }

    @Override
    public void deleteBusiness(String businessId) {
        businessCrud.deleteById(businessId);
    }

    @Override
    public void updateBusiness(String businessId) {

    }
}
