package KhanhVySang.demo.Model.Form.UuDai;
import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "TraCuuUuDai")
@Subselect("select uuid() as id, TCUD.* FROM TraCuuUuDai TCUD")
public class TraCuuUuDaiModel implements Serializable{
    
    @Id
    private String id;
    private int maSanPham;
    private int gia;
    private int phanTramUuDai;
    private int giaUuDai;



    public TraCuuUuDaiModel() {
    }

    public TraCuuUuDaiModel(String id, int maSanPham, int gia, int phanTramUuDai, int giaUuDai) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.gia = gia;
        this.phanTramUuDai = phanTramUuDai;
        this.giaUuDai = giaUuDai;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaSanPham() {
        return this.maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getGia() {
        return this.gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getPhanTramUuDai() {
        return this.phanTramUuDai;
    }

    public void setPhanTramUuDai(int phanTramUuDai) {
        this.phanTramUuDai = phanTramUuDai;
    }

    public int getGiaUuDai() {
        return this.giaUuDai;
    }

    public void setGiaUuDai(int giaUuDai) {
        this.giaUuDai = giaUuDai;
    }
    

}
