package KhanhVySang.demo.Model.Form.Catalog;

public class FormInsertLoaiSanPham {
    
    private String tenLoaiSanPham;
    private boolean trangThai;
    private int maDanhMuc;


    public FormInsertLoaiSanPham() {}

    public FormInsertLoaiSanPham(String tenLoaiSanPham, boolean trangThai, int maDanhMuc) {
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.trangThai = trangThai;
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenLoaiSanPham() {
        return this.tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
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

}
