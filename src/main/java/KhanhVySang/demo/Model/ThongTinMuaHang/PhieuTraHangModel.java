package KhanhVySang.demo.Model.ThongTinMuaHang;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblPhieuTraHang")
public class PhieuTraHangModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieuTraHang;
    @Column(name = "ngayTraHang", nullable = false)
    private Date ngayTraHang;
    @Column(name = "maTrangThai", nullable = false)
    private int maTrangThai;
    @Column(name = "maNhanVien", nullable = true)
    private Integer maNhanVien;

    public PhieuTraHangModel() {}

    public PhieuTraHangModel(Date ngayTraHang, int maTrangThai, int maNhanVien) {
        this.ngayTraHang = ngayTraHang;
        this.maTrangThai = maTrangThai;
        this.maNhanVien = maNhanVien;
    }

    public int getMaPhieuTraHang() {
        return this.maPhieuTraHang;
    }

    public void setMaPhieuTraHang(int maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public Date getNgayTraHang() {
        return this.ngayTraHang;
    }

    public void setNgayTraHang(Date ngayTraHang) {
        this.ngayTraHang = ngayTraHang;
    }

    public int getMaTrangThai() {
        return this.maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public Integer getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

}
