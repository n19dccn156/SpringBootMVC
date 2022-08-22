package KhanhVySang.demo.Model.ViewSanPham;

import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "FORM_TOP20_SP_MOI_NHAT")
@Subselect("select uuid() as id, SPMN.* FROM FORM_TOP20_SP_MOI_NHAT SPMN")
public class Top20MoiNhat implements Serializable{
    
    @Id
    private String id;
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;
    private int phanTramUuDai;
    private String hinhAnh;
    private double giaUuDai;

    public Top20MoiNhat() {}


    public Top20MoiNhat(String id, int maSanPham, String tenSanPham, double gia, String hinhAnh, double giaUuDai) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.giaUuDai = giaUuDai;
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

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public int getPhanTramUuDai() {
        return this.phanTramUuDai;
    }

    public void setPhanTramUuDai(int phanTramUuDai) {
        this.phanTramUuDai = phanTramUuDai;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public double getGiaUuDai() {
        return this.giaUuDai;
    }

    public void setGiaUuDai(double giaUuDai) {
        this.giaUuDai = giaUuDai;
    }

    
}