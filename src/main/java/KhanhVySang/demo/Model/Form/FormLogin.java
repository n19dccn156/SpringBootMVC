package KhanhVySang.demo.Model.Form;


public class FormLogin {
    
    private String tenDangNhap;
    private String matKhau;
    private String luuDangNhap;


    public FormLogin() {}

    public FormLogin(String tenDangNhap, String matKhau, String luuMatKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.luuDangNhap = luuMatKhau;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getLuuDangNhap(){
        return this.luuDangNhap;
    }

    public void setLuuDangNhap(String trangThai) {
        this.luuDangNhap= trangThai;
    }


}
