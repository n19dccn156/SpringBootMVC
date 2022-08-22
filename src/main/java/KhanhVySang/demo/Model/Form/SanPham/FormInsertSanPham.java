package KhanhVySang.demo.Model.Form.SanPham;

import org.springframework.web.multipart.MultipartFile;

public class FormInsertSanPham {
 
    private String tenSanPham;
    private String moTa;
    private int gia;
    private MultipartFile hinhAnh;
    private int loaiSanPham;


    public FormInsertSanPham() {
    }

    public FormInsertSanPham(String tenSanPham, String moTa, int gia, MultipartFile hinhAnh, int loaiSanPham) {
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.loaiSanPham = loaiSanPham;
    }

    public String getTenSanPham() {
        return this.tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return this.gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public MultipartFile getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(MultipartFile hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getLoaiSanPham() {
        return this.loaiSanPham;
    }

    public void setLoaiSanPham(int loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

}
