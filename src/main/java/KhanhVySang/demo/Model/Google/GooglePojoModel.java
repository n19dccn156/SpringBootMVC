package KhanhVySang.demo.Model.Google;

public class GooglePojoModel {
    
    private String id;
    private String email;
    private boolean verified_email;
    private String picture;
    private String hd;


    public GooglePojoModel() {}

    public GooglePojoModel(String id, String email, boolean verified_email, String picture, String hd) {
        this.id = id;
        this.email = email;
        this.verified_email = verified_email;
        this.picture = picture;
        this.hd = hd;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified_email() {
        return this.verified_email;
    }

    public boolean getVerified_email() {
        return this.verified_email;
    }

    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHd() {
        return this.hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

}
