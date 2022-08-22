package KhanhVySang.demo.Model.Form.Catalog;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinLoaiSanPham")
@Subselect("select uuid() as id, LSP.* FROM Form_ThongTinLoaiSanPham LSP")
public class FormThongTinLoaiSanPham {
    
    @Id
    private String id;
    private int maLoaiSanPham;
    private String tenLoaiSanPham;
    private boolean trangThai;
    private int maDanhMuc;
    private String tenDanhMuc;


    public FormThongTinLoaiSanPham() {
    }

    public FormThongTinLoaiSanPham(String id, int maLoaiSanPham, String tenLoaiSanPham, boolean trangThai, int maDanhMuc, String tenDanhMuc) {
        this.id = id;
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.trangThai = trangThai;
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaLoaiSanPham() {
        return this.maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return this.tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public boolean isTrangThai() {
        return this.trangThai;
    }

    public boolean getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaDanhMuc() {
        return this.maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return this.tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
    

}
