package KhanhVySang.demo.Model.KhoaChinh;

import java.io.Serializable;

public class GioHangKey implements Serializable{
    
    private int maKhachHang;
    private int maSanPham;


    public GioHangKey() {}

    public GioHangKey(int maKhachHang, int maSanPham) {
        this.maKhachHang = maKhachHang;
        this.maSanPham = maSanPham;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

}
