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
@Table(name = "Form_ThongTinHoaDon")
@Subselect("select uuid() as id, TTHD.* FROM Form_ThongTinHoaDon TTHD")
public class FormThongTinHoaDon implements Serializable{
    
    @Id
    private String id;
    private int maPhieuBanHang;
    private Date ngayBanHang;
    private String hoten;
    private int maNhanVien;
    private double tongTien;

    public FormThongTinHoaDon() {}


    public FormThongTinHoaDon(String id, int maPhieuBanHang, Date ngayBanHang, String hoten, int maNhanVien, double tongTien) {
        this.id = id;
        this.maPhieuBanHang = maPhieuBanHang;
        this.ngayBanHang = ngayBanHang;
        this.hoten = hoten;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaPhieuBanHang() {
        return this.maPhieuBanHang;
    }

    public void setMaPhieuBanHang(int maPhieuBanHang) {
        this.maPhieuBanHang = maPhieuBanHang;
    }

    public Date getNgayBanHang() {
        return this.ngayBanHang;
    }

    public void setNgayBanHang(Date ngayBanHang) {
        this.ngayBanHang = ngayBanHang;
    }

    public String getHoten() {
        return this.hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public double getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    

}
