package KhanhVySang.demo.Model.Form.TraHang;
import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinChiTietTraHang")
@Subselect("select uuid() as id, CTTH.* FROM Form_ThongTinChiTietTraHang CTTH")
public class FormChiTietTraHang implements Serializable{
    
    @Id
    private String id;
    private int maPhieuTraHang;
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;

    public FormChiTietTraHang() {}

    public FormChiTietTraHang(String id, int maPhieuTraHang, int maSanPham, String tenSanPham, double gia, int soLuong) {
        this.id = id;
        this.maPhieuTraHang = maPhieuTraHang;
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
