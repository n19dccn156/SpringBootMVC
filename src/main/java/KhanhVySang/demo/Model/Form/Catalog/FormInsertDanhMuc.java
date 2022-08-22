package KhanhVySang.demo.Model.Form.Catalog;

import org.springframework.web.multipart.MultipartFile;

public class FormInsertDanhMuc {

    private String tenDanhMuc;
    private MultipartFile hinhAnh;
    private String trangThai;


    public FormInsertDanhMuc() {
    }

    public FormInsertDanhMuc(String tenDanhMuc, MultipartFile hinhAnh, String trangThai) {
        this.tenDanhMuc = tenDanhMuc;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public String getTenDanhMuc() {
        return this.tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public MultipartFile getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(MultipartFile hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }


}
