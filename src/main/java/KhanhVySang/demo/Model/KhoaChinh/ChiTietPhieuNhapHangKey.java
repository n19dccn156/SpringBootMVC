package KhanhVySang.demo.Model.KhoaChinh;

import java.io.Serializable;

public class ChiTietPhieuNhapHangKey implements Serializable{
    
    private int maPhieuNhapHang;
    private int maSanPham;


    public ChiTietPhieuNhapHangKey() {}


    public ChiTietPhieuNhapHangKey(int maPhieuNhapHang, int maSanPham) {
        this.maPhieuNhapHang = maPhieuNhapHang;
        this.maSanPham = maSanPham;
    }

    public int getMaPhieuNhapHang() {
        return this.maPhieuNhapHang;
    }

    public void setMaPhieuNhapHang(int maPhieuNhapHang) {
        this.maPhieuNhapHang = maPhieuNhapHang;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    

}
