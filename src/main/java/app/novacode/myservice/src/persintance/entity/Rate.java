package app.novacode.myservice.src.persintance.entity;


import javax.persistence.*;

@Entity
@Table(name = "Rate")
public class Rate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_Id")
    private Integer rateId;

    @Column(name = "Business_B_Id")
    private String rateBusinessId;

    @Column(name = "R_Rate")
    private Double rateBusiness;

    @Column(name = "R_Qualifier_Mail")
    private String mailQualifier;

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public String getRateBusinessId() {
        return rateBusinessId;
    }

    public void setRateBusinessId(String rateBusinessId) {
        this.rateBusinessId = rateBusinessId;
    }

    public Double getRateBusiness() {
        return rateBusiness;
    }

    public void setRateBusiness(Double rateBusiness) {
        this.rateBusiness = rateBusiness;
    }

    public String getMailQualifier() {
        return mailQualifier;
    }

    public void setMailQualifier(String mailQualifier) {
        this.mailQualifier = mailQualifier;
    }
}
