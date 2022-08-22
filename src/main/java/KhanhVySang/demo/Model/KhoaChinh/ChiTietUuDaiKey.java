package KhanhVySang.demo.Model.KhoaChinh;

import java.io.Serializable;

public class ChiTietUuDaiKey implements Serializable{

    private int maKhachHang;
    private int maUuDai;


    public ChiTietUuDaiKey() {}

    public ChiTietUuDaiKey(int maKhachHang, int maUuDai) {
        this.maKhachHang = maKhachHang;
        this.maUuDai = maUuDai;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaUuDai() {
        return this.maUuDai;
    }

    public void setMaUuDai(int maUuDai) {
        this.maUuDai = maUuDai;
    }

}
