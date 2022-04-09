package app.novacode.myservice.src.persintance.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ResetPassword")
public class ResetPassword {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "RE_Id")
    private Integer resetID;


    @Column(name = "RE_Code_Reset")
    private String resetCR;

    @Column(name = "RE_Status_Code")
    private String resetSC;

    @Column(name = "RE_Mail")
    private String resetM;


    public Integer getResetID() {
        return resetID;
    }

    public void setResetID(Integer resetID) {
        this.resetID = resetID;
    }

    public String getResetCR() {
        return resetCR;
    }

    public void setResetCR(String resetCR) {
        this.resetCR = resetCR;
    }

    public String getResetSC() {
        return resetSC;
    }

    public void setResetSC(String resetSC) {
        this.resetSC = resetSC;
    }

    public String getResetM() {
        return resetM;
    }

    public void setResetM(String resetM) {
        this.resetM = resetM;
    }
}
