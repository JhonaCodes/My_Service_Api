package app.novacode.myservice.src.domain.entity;

public class ResetPasswordDomain {

    private Integer idReset;
    private String codeReset;
    private String codeStatus;
    private String emailReset;

    public Integer getIdReset() {
        return idReset;
    }

    public void setIdReset(Integer idReset) {
        this.idReset = idReset;
    }

    public String getCodeReset() {
        return codeReset;
    }

    public void setCodeReset(String codeReset) {
        this.codeReset = codeReset;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getEmailReset() {
        return emailReset;
    }

    public void setEmailReset(String emailReset) {
        this.emailReset = emailReset;
    }
}
