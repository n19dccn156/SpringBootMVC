package KhanhVySang.demo.Model.ThongTinMuaHang;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietPhieuBanHangKey;


@Entity
@Table(name = "tblChiTietPhieuBanHang")
@IdClass(ChiTietPhieuBanHangKey.class)
public class ChiTietPhieuBanHangModel implements Serializable{
    
    @Id
    @Column(name = "maPhieuBanHang", nullable = false)
    private int maPhieuBanHang;
    @Id
    @Column(name = "maSanPham", nullable = false)
    private int maSanPham;
    @Column(name = "soLuong", nullable = false)
    private int soLuong;
    @Column(name = "gia", nullable = false)
    private float gia;


    public ChiTietPhieuBanHangModel() {}

    public ChiTietPhieuBanHangModel(int maPhieuBanHang, int maSanPham, int soLuong) {
        this.maPhieuBanHang = maPhieuBanHang;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
    }

    public int geMaPhieuBanHang() {
        return this.maPhieuBanHang;
    }

    public void setMaPhieuBanHang(int maPhieuBanHang) {
        this.maPhieuBanHang = maPhieuBanHang;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return this.gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

}
