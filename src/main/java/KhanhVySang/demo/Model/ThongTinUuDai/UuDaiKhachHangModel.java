package KhanhVySang.demo.Model.ThongTinUuDai;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblUuDaiKhachHang")
public class UuDaiKhachHangModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maUuDai;
    @Column(name = "tenUuDai", nullable = false, length = 50)
    private String tenUuDai;
    @Column(name = "phanTramUuDai", nullable = false)
    private int phanTramUuDai;
    @Column(name = "moTa", length = 300)
    private String moTa;
    @Column(name = "dieuKien", nullable = false)
    private int dieuKien;
    @Column(name = "donGiaToiThieu", nullable = false)
    private int donGiaToiThieu;
    @Column(name = "uuDaiToiDa", nullable = false)
    private int uuDaiToiDa;
    @Column(name = "ngayBatDau", nullable = false)
    private Date ngayBatDau;
    @Column(name = "ngayKetThuc", nullable = false)
    private Date ngayKetThuc;
    @Column(name = "maNhanVien", nullable = false)
    private int maNhanVien;


    public UuDaiKhachHangModel() {}

    public UuDaiKhachHangModel(String tenUuDai, int phanTramUuDai, String moTa, 
                            int dieuKien, int donGiaToiThieu, int uuDaiToiDa, 
                            Date ngayBatDau, Date ngayKetThuc, int maNhanVien) {
        this.tenUuDai = tenUuDai;
        this.phanTramUuDai = phanTramUuDai;
        this.moTa = moTa;
        this.dieuKien = dieuKien;
        this.donGiaToiThieu = donGiaToiThieu;
        this.uuDaiToiDa = uuDaiToiDa;
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

    public int getDieuKien() {
        return this.dieuKien;
    }

    public void setDieuKien(int dieuKien) {
        this.dieuKien = dieuKien;
    }

    public int getDonGiaToiThieu() {
        return this.donGiaToiThieu;
    }

    public void setDonGiaToiThieu(int donGiaToiThieu) {
        this.donGiaToiThieu = donGiaToiThieu;
    }

    public float getUuDaiToiDa() {
        return this.uuDaiToiDa;
    }

    public void setUuDaiToiDa(int uuDaiToiDa) {
        this.uuDaiToiDa = uuDaiToiDa;
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