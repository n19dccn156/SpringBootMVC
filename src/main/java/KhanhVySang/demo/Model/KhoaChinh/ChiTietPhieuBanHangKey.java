package KhanhVySang.demo.Model.KhoaChinh;

import java.io.Serializable;


public class ChiTietPhieuBanHangKey implements Serializable{
    
    private int maPhieuBanHang;
    private int maSanPham;

    public ChiTietPhieuBanHangKey() {}


    public ChiTietPhieuBanHangKey(int maPhieuBanHang, int maSanPham) {
        this.maPhieuBanHang = maPhieuBanHang;
        this.maSanPham = maSanPham;
    }

    public int getMaPhieuBanHang() {
        return this.maPhieuBanHang;
    }

    public void setMaPhieuMuaHang(int maPhieuBanHang) {
        this.maPhieuBanHang = maPhieuBanHang;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }




}
