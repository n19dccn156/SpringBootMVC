package KhanhVySang.demo.Model.ThongTinSanPham;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblLoaiSanPham")
public class LoaiSanPhamModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiSanPham;
    @Column(name = "tenLoaiSanPham", nullable = false, unique = true, length = 50)
    private String tenLoaiSanPham;
    @Column(name = "trangThai", nullable = false)
    private boolean trangThai;
    @Column(name = "maDanhMuc", nullable = false)
    private int maDanhMuc;

    public LoaiSanPhamModel() {}

    public LoaiSanPhamModel(String tenLoaiSanPham, boolean trangThai, 
                            int maDanhMuc) {
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.trangThai = trangThai;
        this.maDanhMuc= maDanhMuc;
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

    public int getMaDanhMuc(){
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
}
