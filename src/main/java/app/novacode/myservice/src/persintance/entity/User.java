package app.novacode.myservice.src.persintance.entity;


import javax.persistence.*;

@Entity
@Table(name ="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_Id")
    private Integer usId;

    @Column(name = "U_First_Name")
    private String usName;

    @Column(name = "U_Second_Name")
    private String usSecondName;

    @Column(name = "U_City")
    private String usCity;

    @Column(name = "U_Mail")
    private String usMail;

    @Column(name = "U_Phone")
    private String usPhone;

    @Column(name = "U_Password")
    private String usPassword;

    @Column(name = "U_Rol")
    private String usRol;


    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsSecondName() {
        return usSecondName;
    }

    public void setUsSecondName(String usSecondName) {
        this.usSecondName = usSecondName;
    }

    public String getUsCity() {
        return usCity;
    }

    public void setUsCity(String usCity) {
        this.usCity = usCity;
    }

    public String getUsMail() {
        return usMail;
    }

    public void setUsMail(String usMail) {
        this.usMail = usMail;
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsRol() {
        return usRol;
    }

    public void setUsRol(String usRol) {
        this.usRol = usRol;
    }
}

