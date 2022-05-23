package app.novacode.myservice.src.persintance.entity;


import javax.persistence.*;

@Entity
@Table(name = "Business")
public class Business {


    @Id
    @Column(name = "B_Id")
    private String busId;


    @Column(name = "User_U_Id")
    private String userId;

    @Column(name="B_Area")
    private String buArea;

    @Column(name = "B_Name")
    private String buName;

    @Column(name = "B_Website")
    private String buWebsite;

    @Column(name="B_About")
    private String buAbout;

    @Column(name ="B_Image_Url")
    private String buImageUrl;


    @OneToOne
    @JoinColumn(name ="User_U_Id", updatable = false, insertable = false)
    private User dataUser;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getDataUser() {
        return dataUser;
    }

    public void setDataUser(User dataUser) {
        this.dataUser = dataUser;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String buId) {
        this.busId = buId;
    }


    public String getBuArea() {
        return buArea;
    }

    public void setBuArea(String buArea) {
        this.buArea = buArea;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buNrea) {
        this.buName = buNrea;
    }

    public String getBuWebsite() {
        return buWebsite;
    }

    public void setBuWebsite(String buWebsite) {
        this.buWebsite = buWebsite;
    }

    public String getBuAbout() {
        return buAbout;
    }

    public void setBuAbout(String buAbout) {
        this.buAbout = buAbout;
    }

    public String getBuImageUrl() {
        return buImageUrl;
    }

    public void setBuImageUrl(String buImageUrl) {
        this.buImageUrl = buImageUrl;
    }
}
