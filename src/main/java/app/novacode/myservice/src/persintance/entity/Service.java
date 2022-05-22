package app.novacode.myservice.src.persintance.entity;


import javax.persistence.*;

@Entity
@Table(name = "Service")
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_Id")
    private Integer servId;

    @Column(name = "B_Id")
    private String bussId;

    @Column(name = "S_Name")
    private String servName;

    @Column(name = "S_Specification")
    private String seSpecification;

    @Column(name = "S_Price")
    private float servPrice;

    @Column(name = "S_Contract")
    private String servContact;

    @ManyToOne
    @JoinColumn(name = "Business_B_Id", updatable = false, insertable = false)
    private Business businessID;

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer seId) {
        this.servId = seId;
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String seName) {
        this.servName = seName;
    }

    public String getSeSpecification() {
        return seSpecification;
    }

    public void setSeSpecification(String seSpecification) {
        this.seSpecification = seSpecification;
    }

    public float getServPrice() {
        return servPrice;
    }

    public void setServPrice(float sePrice) {
        this.servPrice = sePrice;
    }

    public String getServContact() {
        return servContact;
    }

    public void setServContact(String seContact) {
        this.servContact = seContact;
    }

    public Business getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Business businessID) {
        this.businessID = businessID;
    }
}
