package KhanhVySang.demo.Model.ThongTinCaNhan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import KhanhVySang.demo.Model.KhoaChinh.GioHangKey;



@Entity
@Table(name = "tblGioHang")
@IdClass(GioHangKey.class)
public class GioHangModel implements Serializable{

    @Id
    @Column(name = "maKhachHang")
    private int maKhachHang;
    @Id
    @Column(name = "maSanPham")
    private int maSanPham;
    @Column(name = "soLuong", nullable = false)
    private int soLuong;

    public GioHangModel() {}

    public GioHangModel(int maSanPham, int maKhachHang, int soLuong) {
        this.maSanPham = maSanPham;
        this.maKhachHang = maKhachHang;
        this.soLuong = soLuong;
        
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
