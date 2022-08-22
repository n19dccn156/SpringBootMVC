package KhanhVySang.demo.Service.ThongTinMuaHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuBanHangModel;
import KhanhVySang.demo.Repositories.ThongTinMuaHang.PhieuBanHangRepository;

@Service
public class PhieuBanHangService {

    @Autowired 
    private PhieuBanHangRepository phieuBanHangRepository;
    
    public PhieuBanHangModel findByMaPhieuBanHang(int maPhieuBanHang){
        return phieuBanHangRepository.findByMaPhieuBanHang(maPhieuBanHang).isPresent() ?
            phieuBanHangRepository.findByMaPhieuBanHang(maPhieuBanHang).get() :
            new PhieuBanHangModel();
    }

    public List<PhieuBanHangModel> findByMaTrangThai(int maTrangThai){
        return phieuBanHangRepository.findByMaTrangThai(maTrangThai);
    }

    public List<PhieuBanHangModel> findByMaKhachHang(int maKhachHang){
        return phieuBanHangRepository.findByMaKhachHang(maKhachHang);
    }

    public int insertPhieuBanHangOnl(String diaChi, String dienThoai, int maKhachHang, String ho, String ten){
        return phieuBanHangRepository.insertTblPhieuBanHangOnl(diaChi, dienThoai, maKhachHang, ho, ten);
    }

    public int findMaPhieuBanHangNew(){
        return phieuBanHangRepository.findMaPhieuBanHangNew();
    }

    // public int insertPhieuBanHangOnl(String diaChi, String sdt, int maKhachHang, Object object, String ho, String ten) {
    //     return 0;
    // }

    public int updatePhieuBanHangTrangThai(int maTrangThai, int maNhanvien, int maPhieuBanHang) {
        try {
            return phieuBanHangRepository.updatePhieuBanHangTrangThai(maTrangThai, maNhanvien, maPhieuBanHang);
        } catch (Exception e) {
            return 0;
        }
    }
}
