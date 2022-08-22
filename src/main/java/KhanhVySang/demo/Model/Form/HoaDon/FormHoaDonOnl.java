package KhanhVySang.demo.Model.Form.HoaDon;
import java.io.Serializable;
import java.sql.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Table(name = "Form_ThongTinHoaDonOnl")
@Subselect("select uuid() as id, HDONL.* FROM Form_ThongTinHoaDonOnl HDONL")
public class FormHoaDonOnl implements Serializable{
    
    @Id
    private String id;
    private int maHoaDon;
    private Date ngayLapPhieu;
    private String diaChi;
    private String SDT;
    private String tenKhachHang;
    private int maTrangThai;
    private String tenTrangThai;
    private int tongTien;

    public FormHoaDonOnl() {}


    public FormHoaDonOnl(String id, int maHoaDon, Date ngayLapPhieu, String diaChi, String SDT, String tenKhachHang, int maTrangThai, String tenTrangThai, int tongTien) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.ngayLapPhieu = ngayLapPhieu;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.tenKhachHang = tenKhachHang;
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
        this.tongTien = tongTien;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaHoaDon() {
        return this.maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapPhieu() {
        return this.ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return this.SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTenKhachHang() {
        return this.tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getMaTrangThai() {
        return this.maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return this.tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public int getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    

}
