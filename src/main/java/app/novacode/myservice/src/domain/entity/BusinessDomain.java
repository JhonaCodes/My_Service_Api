package app.novacode.myservice.src.domain.entity;


import app.novacode.myservice.src.persintance.entity.User;

public class BusinessDomain {

    private String sellerId;
    private String businessId;
    private String businessArea;
    private String businessName;
    private String businessWebsite;
    private String businessAbout;
    private String imageUrl;
    private User sellerData;


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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getSellerData() {
        return sellerData;
    }

    public void setSellerData(User sellerData) {
        this.sellerData = sellerData;
    }
}
