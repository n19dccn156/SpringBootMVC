package KhanhVySang.demo.Model.Form.NhanVien;

public class FormThemNhanVien {
    
    private String ho;
    private String ten;
    private String gioiTinh;
    private String dienThoai;
    private String cccd;
    private String ngaySinh;
    private String tenDangNhap;
    private String email;
    private String chucVu;


    public FormThemNhanVien() {
    }

    public FormThemNhanVien(String ho, String ten, String gioiTinh, String dienThoai, String cccd, String ngaySinh, String tenDangNhap, String email, String chucVu) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.tenDangNhap = tenDangNhap;
        this.email = email;
        this.chucVu = chucVu;
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

    public String getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return this.chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }


}
