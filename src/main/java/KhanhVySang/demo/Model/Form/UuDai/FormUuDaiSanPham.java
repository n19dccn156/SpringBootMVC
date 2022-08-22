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
@Table(name = "Form_ThongTinUuDaiSanPham")
@Subselect("select uuid() as id, UDSP.* FROM Form_ThongTinUuDaiSanPham UDSP")
public class FormUuDaiSanPham implements Serializable{
    
    @Id
    private String id;
    private int maUuDai;
    private String tenUuDai;
    private double phanTramUuDai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String tenNhanVien;


    public FormUuDaiSanPham() {
    }

    public FormUuDaiSanPham(String id, int maUuDai, String tenUuDai, double phanTramUuDai, Date ngayBatDau, Date ngayKetThuc, String tenNhanVien) {
        this.id = id;
        this.maUuDai = maUuDai;
        this.tenUuDai = tenUuDai;
        this.phanTramUuDai = phanTramUuDai;
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
