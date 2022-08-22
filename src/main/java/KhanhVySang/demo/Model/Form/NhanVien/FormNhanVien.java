package KhanhVySang.demo.Model.Form.NhanVien;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinNhanVien")
@Subselect("select uuid() as id, TTNV.* FROM Form_ThongTinNhanVien TTNV")
public class FormNhanVien implements Serializable{
    
    @Id
    private String id;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String dienThoai;
    private Date ngaySinh;
    private String CCCD;
    private String email;
    private boolean trangThai;

    public FormNhanVien() {}


    public FormNhanVien(String ho, String ten, String gioiTinh, String dienThoai, Date ngaySinh, String cccd, String email, boolean trangThai ){
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
        this.CCCD = cccd;
        this.email = email;
        this.trangThai = trangThai;
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

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCCCD() {
        return this.CCCD;
    }

    public void setCCCD(String cccd) {
        this.CCCD = cccd;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
