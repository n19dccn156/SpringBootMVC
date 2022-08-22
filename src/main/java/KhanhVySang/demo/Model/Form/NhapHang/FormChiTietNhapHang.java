package KhanhVySang.demo.Model.Form.NhapHang;
import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinChiTietNhapHang")
@Subselect("select uuid() as id, CTPN.* FROM Form_ThongTinChiTietNhapHang CTPN")
public class FormChiTietNhapHang implements Serializable{
    
    @Id
    private String id;
    private int maPhieuNhapHang;
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;


    public FormChiTietNhapHang() {
    }

    public FormChiTietNhapHang(String id, int maPhieuNhapHang, int maSanPham, String tenSanPham, double gia, int soLuong) {
        this.id = id;
        this.maPhieuNhapHang = maPhieuNhapHang;
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
