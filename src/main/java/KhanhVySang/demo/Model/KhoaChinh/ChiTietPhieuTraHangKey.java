package KhanhVySang.demo.Model.KhoaChinh;

import java.io.Serializable;

public class ChiTietPhieuTraHangKey implements Serializable{
    
    private int maPhieuTraHang;
    private int maSanPham;


    public ChiTietPhieuTraHangKey() {}

    public ChiTietPhieuTraHangKey(int maPhieuTraHang, int maSanPham) {
        this.maPhieuTraHang = maPhieuTraHang;
        this.maSanPham = maSanPham;
    }

    public int getMaPhieuTraHang() {
        return this.maPhieuTraHang;
    }

    public void setMaPhieuTraHang(int maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    
}
