package KhanhVySang.demo.Model.Form;

public class FormDoiMatKhau {

    private String tenDangNhap;
    private String matKhauMoi;
    private String nlMatKhau;


    public FormDoiMatKhau() {}

    public FormDoiMatKhau(String tenDangNhap, String matKhauMoi, String nlMatKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhauMoi = matKhauMoi;
        this.nlMatKhau = nlMatKhau;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhauMoi() {
        return this.matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public String getNlMatKhau() {
        return this.nlMatKhau;
    }

    public void setNlMatKhau(String nlMatKhau) {
        this.nlMatKhau = nlMatKhau;
    }
    
}
