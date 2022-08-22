package KhanhVySang.demo.Model.ThongTinMuaHang;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblPhieuBanHang")
public class PhieuBanHangModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieuBanHang;
    @Column(name = "ngayBanHang")
    private Date ngayBanHang;
    @Column(name = "diaChi", length = 100)
    private String diaChi;
    @Column(name = "dienThoai", length = 20)
    private String dienThoai;
    @Column(name = "maNhanVien")
    private Integer maNhanVien;
    @Column(name = "maUuDai")
    private Integer maUuDai;
    @Column(name = "maKhachHang")
    private int maKhachHang;
    @Column(name = "maTrangThai")
    private int maTrangThai;
    @Column(name = "ho", length = 30)
    private String ho;
    @Column(name = "ten", length = 20)
    private String ten;

    public PhieuBanHangModel() {}


    public PhieuBanHangModel(int maPhieuBanHang, Date ngayBanHang, String diaChi, String dienThoai, Integer maNhanVien, Integer maUuDai, int maKhachHang, int maTrangThai, String ho, String ten) {
        this.maPhieuBanHang = maPhieuBanHang;
        this.ngayBanHang = ngayBanHang;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.maNhanVien = maNhanVien;
        this.maUuDai = maUuDai;
        this.maKhachHang = maKhachHang;
        this.maTrangThai = maTrangThai;
        this.ho = ho;
        this.ten = ten;
    }


    public int getMaPhieuBanHang() {
        return this.maPhieuBanHang;
    }

    public void setMaPhieuBanHang(int maPhieuBanHang) {
        this.maPhieuBanHang = maPhieuBanHang;
    }

    public Date getNgayBanHang() {
        return this.ngayBanHang;
    }

    public void setNgayBanHang(Date ngayBanHang) {
        this.ngayBanHang = ngayBanHang;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public int getMaTrangThai() {
        return this.maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai= maTrangThai;
    }

    public int getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang= maKhachHang;
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

}
