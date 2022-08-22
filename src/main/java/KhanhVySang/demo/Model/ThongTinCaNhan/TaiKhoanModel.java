package KhanhVySang.demo.Model.ThongTinCaNhan;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblTaiKhoan")
public class TaiKhoanModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTaiKhoan;
    @Column(name = "tenDangNhap", unique = true, nullable = false, length = 100)
    private String tenDangNhap;
    @Column(name = "matKhau", nullable = false, length = 100)
    private String matKhau;
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "ngayTao")
    private Date ngayTao;
    @Column(name = "quyen")
    private String quyen;


    public TaiKhoanModel() {}

    public TaiKhoanModel(String tenDangNhap, String matKhau, String email, 
                        Date ngayTao, String quyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.ngayTao = ngayTao;
        this.quyen = quyen;
    }

    public TaiKhoanModel(String tenDangNhap, String matKhau, String email, 
                        String quyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.quyen = quyen;
    }

    public int getMaTaiKhoan() {
        return this.maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan){
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayTao() {
        return this.ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getQuyen() {
        return this.quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }


}
