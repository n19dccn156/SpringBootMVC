package KhanhVySang.demo.Model.Form.HoaDon;
import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Table(name = "Form_ThongTinChiTietHoaDon")
@Subselect("select uuid() as id, CTHD.* FROM Form_ThongTinChiTietHoaDon CTHD")
public class FormChiTietHoaDon implements Serializable{
    
    @Id
    private String id;
    private int maHoaDon;
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;

    public FormChiTietHoaDon() {}

    public FormChiTietHoaDon(String id, int maHoaDon, int maSanPham, String tenSanPham, double gia, int soLuong) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaHoaDon() {
        return this.maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return this.tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGia() {
        return this.gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
