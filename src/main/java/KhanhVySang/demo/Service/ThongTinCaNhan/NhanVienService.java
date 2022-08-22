package KhanhVySang.demo.Service.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.Form.NhanVien.FormNhanVien;
import KhanhVySang.demo.Model.ThongTinCaNhan.NhanVienModel;
import KhanhVySang.demo.Repositories.Form.NhanVien.ViewThongTinNhanVien;
import KhanhVySang.demo.Repositories.ThongTinCaNhan.NhanVienRepository;

@Service
public class NhanVienService {
    
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ViewThongTinNhanVien viewThongTinNhanVien;
    
    public List<NhanVienModel> findAll(){
        return nhanVienRepository.findAll();
    }

    public NhanVienModel findByMaTaiKhoan(int maTaiKhoan){
        return nhanVienRepository.findByMaTaiKhoan(maTaiKhoan).isPresent() ?
            nhanVienRepository.findByMaTaiKhoan(maTaiKhoan).get() : new NhanVienModel();
    }

    public Optional<NhanVienModel> findByMaNhanVien(int maNhanvien){
        return nhanVienRepository.findByMaNhanVien(maNhanvien);
    }

    public List<NhanVienModel> findByHo(String ho) {
        return nhanVienRepository.findByHo(ho);
    }

    public List<NhanVienModel> findByTen(String ten) {
        return nhanVienRepository.findByHo(ten);
    }

    public List<NhanVienModel> findByGioiTinh(String gioiTinh) {
        return nhanVienRepository.findByHo(gioiTinh);
    }

    public Optional<NhanVienModel> findBySDT(String SDT) {
        return nhanVienRepository.findByDienThoai(SDT);
    }

    public Optional<NhanVienModel> findByCMNDHoacCCCD(String cccd) {
        return nhanVienRepository.findByCCCD(cccd);
    }
    public List<NhanVienModel> findByNgaySinh(Date ngaySinh) {
        return nhanVienRepository.findByNgaySinh(ngaySinh);
    }

    public List<FormNhanVien> findAllByForm(){
        return viewThongTinNhanVien.findAll();
    }

    public List<FormNhanVien> findFormByTrangThai(boolean trangThai){
        return viewThongTinNhanVien.findByTrangThai(trangThai);
    }

    public boolean InsertNhanVien(NhanVienModel nhanVien){
        try {
            return nhanVienRepository.InsertNhanVien(nhanVien.getHo(),
                                                    nhanVien.getTen(), 
                                                    nhanVien.getGioiTinh(), 
                                                    nhanVien.getDienThoai(), 
                                                    nhanVien.getCCCD(),
                                                    nhanVien.getNgaySinh(), 
                                                    nhanVien.getMaTaiKhoan());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateNhanVien(NhanVienModel nhanVien){
        try {
            return nhanVienRepository.updateNhanVien(nhanVien.getHo(),
                                                    nhanVien.getTen(), 
                                                    nhanVien.getGioiTinh(), 
                                                    nhanVien.getDienThoai(), 
                                                    nhanVien.getCCCD(),
                                                    nhanVien.getNgaySinh(), 
                                                    nhanVien.getMaTaiKhoan());
        } catch (Exception e) {
            return false;
        }
    }

}
