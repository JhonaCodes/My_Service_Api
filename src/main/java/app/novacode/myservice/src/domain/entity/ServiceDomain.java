package app.novacode.myservice.src.domain.entity;

import app.novacode.myservice.src.persintance.entity.Business;

public class ServiceDomain {

    private Integer idService;
    private String idBusiness;
    private String nameService;
    private String specializationService;
    private Float priceService;
    private String contactService;
    private Business businessData;


    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(String idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getSpecializationService() {
        return specializationService;
    }

    public void setSpecializationService(String specializationService) {
        this.specializationService = specializationService;
    }

    public Float getPriceService() {
        return priceService;
    }

    public void setPriceService(Float priceService) {
        this.priceService = priceService;
    }

    public String getContactService() {
        return contactService;
    }

    public void setContactService(String contactService) {
        this.contactService = contactService;
    }

    public Business getBusinessData() {
        return businessData;
    }

    public void setBusinessData(Business businessData) {
        this.businessData = businessData;
    }
}
