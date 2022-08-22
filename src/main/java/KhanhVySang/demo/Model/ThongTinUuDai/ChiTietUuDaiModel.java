package KhanhVySang.demo.Model.ThongTinUuDai;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietUuDaiKey;

@Entity
@Table(name = "tblChiTietUuDai")
@IdClass(ChiTietUuDaiKey.class)
public class ChiTietUuDaiModel implements Serializable{

    @Id
    @Column(name = "maKhachHang", nullable = false)
    private int maKhachHang;
    @Id
    @Column(name = "maUuDai", nullable = false)
    private int maUuDai;
    @Column(name = "SoLuong", nullable = false)
    private int soLuong;


    public ChiTietUuDaiModel() {}

    public ChiTietUuDaiModel(int maUuDai, int maKhachHang, int soLuong) {
        this.maUuDai = maUuDai;
        this.maKhachHang = maKhachHang;
        this.soLuong = soLuong;
    }

    public int getMaUuDai() {
        return this.maUuDai;
    }

    public void setMaUuDai(int maUuDai) {
        this.maUuDai= maUuDai;
    }

    public int getKhachHang() {
        return this.maKhachHang;
    }

    public void setKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}