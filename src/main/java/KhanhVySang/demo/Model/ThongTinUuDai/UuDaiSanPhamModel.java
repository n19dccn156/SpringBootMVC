package KhanhVySang.demo.Model.ThongTinUuDai;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblUuDaiSanPham")
public class UuDaiSanPhamModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maUuDai;
    @Column(name = "tenUuDai", unique = true, nullable = false, length = 50)
    private String tenUuDai;
    @Column(name = "phanTramUuDai", nullable = false)
    private Integer phanTramUuDai;
    @Column(name = "moTa", length = 300)
    private String moTa;
    @Column(name = "ngayBatDau", nullable = false)
    private Date ngayBatDau;
    @Column(name = "ngayKetThuc", nullable = false)
    private Date ngayKetThuc;
    @Column(name = "maNhanVien", nullable = false)
    private Integer maNhanVien;

    public UuDaiSanPhamModel(){}

    public UuDaiSanPhamModel(String tenUuDai, int phanTramUuDai, 
                            String moTa, Date ngayBatDau, 
                            Date ngayKetThuc, int maNhanVien) {
        this.tenUuDai = tenUuDai;
        this.phanTramUuDai = phanTramUuDai;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maNhanVien = maNhanVien;
    }

    public int getMaUuDai() {
        return this.maUuDai;
    }

    public void setMaUuDai(int maUuDai) {
        this.maUuDai = maUuDai;
    }

    public String getTenUuDai() {
        return this.tenUuDai;
    }

    public void setTenUuDai(String tenUuDai) {
        this.tenUuDai = tenUuDai;
    }

    public int getPhanTramUuDai() {
        return this.phanTramUuDai;
    }

    public void setPhanTramUuDai(int phanTramUuDai) {
        this.phanTramUuDai = phanTramUuDai;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

}