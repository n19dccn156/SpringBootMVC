package KhanhVySang.demo.Service.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Repositories.ThongTinCaNhan.TaiKhoanRepository;

@Service
public class TaiKhoanService {
    
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public List<TaiKhoanModel> findAll(){
        return taiKhoanRepository.findAll();
    }

    public TaiKhoanModel findByMaTaiKhoan(int maTaiKhoan){
        Optional<TaiKhoanModel> oTK = taiKhoanRepository.findByMaTaiKhoan(maTaiKhoan);
        TaiKhoanModel tk = new TaiKhoanModel();
        if(oTK.isEmpty()) return tk;

        return oTK.get();
    }

    public TaiKhoanModel findByTenDangNhap(String tenDangNhap){
        Optional<TaiKhoanModel> oTK = taiKhoanRepository.findByTenDangNhap(tenDangNhap);
        TaiKhoanModel tk = new TaiKhoanModel();
        if(oTK.isEmpty()) return tk;

        return oTK.get();
    }

    public TaiKhoanModel findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau){
        Optional<TaiKhoanModel> oTK = taiKhoanRepository.findByTenDangNhapAndMatKhau(tenDangNhap, matKhau);
        TaiKhoanModel tk = new TaiKhoanModel();
        if(oTK.isEmpty()) return tk;
        return oTK.get();
    }

    public TaiKhoanModel findByEmail(String email) {
        Optional<TaiKhoanModel> oTK = taiKhoanRepository.findByEmail(email);
        TaiKhoanModel tk = new TaiKhoanModel();
        
        if(oTK.isEmpty()) return tk;

        return oTK.get();
    }

    public List<TaiKhoanModel> findByNgayTao(Date ngayTao){
        return taiKhoanRepository.findByNgayTao(ngayTao);
    }

    public List<TaiKhoanModel> findByQuyen(String quyen){
        return taiKhoanRepository.findByQuyen(quyen);
    }

    public boolean updateTaiKhoanByMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi){
        if(matKhauMoi.length() > 20) return false;

        try {
            return taiKhoanRepository.updateTaiKhoan(tenDangNhap, matKhauCu, matKhauMoi);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateTaiKhoan(TaiKhoanModel taiKhoan){
        try {
            return taiKhoanRepository.updateTaiKhoan(taiKhoan.getMaTaiKhoan(), taiKhoan.getMatKhau(), taiKhoan.getEmail());
        } catch (Exception e) {
            return false;
        }
    } 

    public boolean insertTaiKhoan(TaiKhoanModel taiKhoan){
        try {
            return taiKhoanRepository.InsertTaiKhoan(taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getEmail());
        } catch (Exception e) {
            return false;
        }
    }

}
