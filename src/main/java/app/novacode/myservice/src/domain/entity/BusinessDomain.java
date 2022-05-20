package app.novacode.myservice.src.domain.entity;


import app.novacode.myservice.src.persintance.entity.User;

import java.sql.Blob;


public class BusinessDomain {

    private String sellerId;
    private String businessId;
    private String businessArea;
    private String businessName;
    private String businessWebsite;
    private String businessAbout;
    private byte[] imageUrl;

    private UserDomain sellerData;


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessWebsite() {
        return businessWebsite;
    }

    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }

    public String getBusinessAbout() {
        return businessAbout;
    }

    public void setBusinessAbout(String businessAbout) {
        this.businessAbout = businessAbout;
    }

    public byte[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserDomain getSellerData() {
        return sellerData;
    }

    public void setSellerData(UserDomain sellerData) {
        this.sellerData = sellerData;
    }
}
