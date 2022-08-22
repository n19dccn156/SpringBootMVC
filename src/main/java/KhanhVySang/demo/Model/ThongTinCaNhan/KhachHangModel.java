package KhanhVySang.demo.Model.ThongTinCaNhan;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblKhachHang")
public class KhachHangModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;
    @Column(name = "ho", length = 50)
    private String ho;
    @Column(name = "ten", nullable = false, length = 50)
    private String ten;
    @Column(name = "gioiTinh", length = 10)
    private String gioiTinh;
    @Column(name = "dienThoai", length = 20)
    private String dienThoai;
    @Column(name = "ngaySinh")
    private Date ngaySinh;
    @Column(name = "maTaiKhoan", nullable = false)
    private int maTaiKhoan;
    

    public KhachHangModel() {}

    public KhachHangModel(String ho, String ten, String gioiTinh, 
                        String dienThoai, Date ngaySinh, int maTaiKhoan) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
        this.maTaiKhoan = maTaiKhoan;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
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

    public int getMaTaiKhoan() {
        return this.maTaiKhoan;
    }

    public void setTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

}
