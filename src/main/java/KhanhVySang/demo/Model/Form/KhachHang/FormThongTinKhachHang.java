package KhanhVySang.demo.Model.Form.KhachHang;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinKhachHang")
@Subselect("select uuid() as id, TTKH.* FROM Form_ThongTinKhachHang TTKH")
public class FormThongTinKhachHang implements Serializable{

    @Id
    private String id;
    private String ho;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String dienThoai;
    private String email;

    public FormThongTinKhachHang() {}

    public FormThongTinKhachHang(String ho, String ten, String gioiTinh, Date ngaySinh, String dienThoai, String email) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public String getHo() {
        return this.ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
