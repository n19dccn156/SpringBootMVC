package KhanhVySang.demo.Model.Form;

import java.sql.Date;

public class FormDangKy {
    private String tenDangNhap;
    private String matKhau;
    private String nlMatKhau;
    private String email;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String dienThoai;
    private Date ngaySinh;

    public FormDangKy() {}

    public FormDangKy(String tenDangNhap, String matKhau, String nhapLaiMatKhau, String email, String ho, String ten, String gioiTinh, String dienThoai, Date ngaySinh) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.nlMatKhau = nhapLaiMatKhau;
        this.email = email;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
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

    public String getNhapLaiMatKhau() {
        return this.nlMatKhau;
    }

    public void setNhapLaiMatKhau(String nhapLaiMatKhau) {
        this.nlMatKhau = nhapLaiMatKhau;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

}
