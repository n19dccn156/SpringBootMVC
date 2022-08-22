package KhanhVySang.demo.Model.Form.SanPham;

import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinSanPham")
@Subselect("select uuid() as id, TTSP.* FROM Form_ThongTinSanPham TTSP")
public class FormSanPham implements Serializable{
    
    @Id
    private String id;
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;
    private String tenLoaiSanPham;
    private int maDanhMuc;
    private int maLoaiSanPham;

    public FormSanPham() {}


    public FormSanPham(String id, int maSanPham, String tenSanPham, double gia, int soLuong, String tenLoaiSanPham, int maDanhMuc, int maLoaiSanPham) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.maDanhMuc = maDanhMuc;
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTenLoaiSanPham() {
        return this.tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public int getMaDanhMuc() {
        return this.maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public int getMaLoaiSanPham() {
        return this.maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }


   

}
