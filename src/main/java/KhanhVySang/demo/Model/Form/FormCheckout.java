package KhanhVySang.demo.Model.Form;

public class FormCheckout {
    
    private String ho;
    private String ten;
    private String sdt;
    private String diaChi;


    public FormCheckout() {
    }

    public FormCheckout(String ho, String ten, String sdt, String diaChi) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getHo() {
        return this.ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}
