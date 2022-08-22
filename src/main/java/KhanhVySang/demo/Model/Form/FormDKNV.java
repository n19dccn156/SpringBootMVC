package KhanhVySang.demo.Model.Form;

import java.sql.Date;

public class FormDKNV {
    
    private String tenDangNhap;
    private String matKhau;
    private String nlMatKhau;
    private String email;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String dienThoai;
    private String cccd;
    private Date ngaySinh;
    private boolean trangThai;


    public FormDKNV() {}

    public FormDKNV(String tenDangNhap, String matKhau, String nlMatKhau, String email, String ho, String ten, String gioiTinh, String dienThoai, String cccd, Date ngaySinh, boolean trangThai) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.nlMatKhau = nlMatKhau;
        this.email = email;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.trangThai = trangThai;
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

    public String getNlMatKhau() {
        return this.nlMatKhau;
    }

    public void setNlMatKhau(String nlMatKhau) {
        this.nlMatKhau = nlMatKhau;
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

    public String getCccd() {
        return this.cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isTrangThai() {
        return this.trangThai;
    }

    public boolean getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
