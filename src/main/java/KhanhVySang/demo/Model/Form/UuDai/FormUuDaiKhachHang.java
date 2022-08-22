package KhanhVySang.demo.Model.Form.UuDai;
import java.io.Serializable;
import java.sql.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "Form_ThongTinUuDaiKhachHang")
@Subselect("select uuid() as id, UDKH.* FROM Form_ThongTinUuDaiKhachHang UDKH")
public class FormUuDaiKhachHang implements Serializable{
    
    @Id
    private String id;
    private int maUuDai;
    private String tenUuDai;
    private double phanTramUuDai;
    private double dieuKien;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String tenNhanVien;

    public FormUuDaiKhachHang() {
    }

    public FormUuDaiKhachHang(String id, int maUuDai, String tenUuDai, double phanTramUuDai, double dieuKien, Date ngayBatDau, Date ngayKetThuc, String tenNhanVien) {
        this.id = id;
        this.maUuDai = maUuDai;
        this.tenUuDai = tenUuDai;
        this.phanTramUuDai = phanTramUuDai;
        this.dieuKien = dieuKien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tenNhanVien = tenNhanVien;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaUuDai() {
        return this.maUuDai;
    }

    public void setMaUuDai(int maUuDai) {
        this.maUuDai = maUuDai;
    }

    public String getTenUuDai() {
        return this.tenUuDai;
    }

    public void setTenUuDai(String tenUuDai) {
        this.tenUuDai = tenUuDai;
    }

    public double getPhanTramUuDai() {
        return this.phanTramUuDai;
    }

    public void setPhanTramUuDai(double phanTramUuDai) {
        this.phanTramUuDai = phanTramUuDai;
    }

    public double getDieuKien() {
        return this.dieuKien;
    }

    public void setDieuKien(double dieuKien) {
        this.dieuKien = dieuKien;
    }

    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTenNhanVien() {
        return this.tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

}