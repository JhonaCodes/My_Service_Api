package app.novacode.myservice.src.domain.entity;


public class RateDomain {

    private Integer rateID;
    private String  businessID;
    private Double rate;
    private String  mailRated;


    public Integer getRateID() {
        return rateID;
    }

    public void setRateID(Integer rateID) {
        this.rateID = rateID;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public String getMailRated() {
        return mailRated;
    }

    public void setMailRated(String mailRated) {
        this.mailRated = mailRated;
    }
}
