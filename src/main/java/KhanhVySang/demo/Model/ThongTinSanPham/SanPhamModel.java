package KhanhVySang.demo.Model.ThongTinSanPham;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblSanPham")
public class SanPhamModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSanPham;
    @Column(name = "tenSanPham", nullable = false, unique = true, length = 50)
    private String tenSanPham;
    @Column(name = "gia", nullable = false)
    private int gia;
    @Column(name = "soLuong")
    private int soLuong;
    @Column(name = "moTa", length = 30)
    private String moTa;
    @Column(name = "hinhAnh", nullable = false, length = 150)
    private String hinhAnh;
    @Column(name = "maLoaiSanPham", nullable = false)
    private int maLoaiSanPham;
    @Column(name = "maUuDai", nullable = true)
    private Integer maUuDai;

    public SanPhamModel() {}

    public SanPhamModel(int maSanPham, String tenSanPham, int gia, int soLuong, String moTa, String hinhAnh, int maLoaiSanPham, Integer maUuDai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.maLoaiSanPham = maLoaiSanPham;
        this.maUuDai = maUuDai;
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

    public int getGia() {
        return this.gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getMaLoaiSanPham() {
        return this.maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public Integer getMaUuDai() {
        return this.maUuDai;
    }

    public void setMaUuDai(Integer maUuDai) {
        this.maUuDai = maUuDai;
    }


}
