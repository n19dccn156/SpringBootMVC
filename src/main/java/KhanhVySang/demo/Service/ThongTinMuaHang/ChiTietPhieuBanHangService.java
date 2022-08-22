package KhanhVySang.demo.Service.ThongTinMuaHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Repositories.ThongTinMuaHang.ChiTietPhieuBanHangRepository;

@Service
public class ChiTietPhieuBanHangService {
    
    @Autowired
    private ChiTietPhieuBanHangRepository chiTietPhieuBanHangRepository;

    public int insertCTPhieuBanHang(int maPhieuBanHang, int maSanPham, int soLuong, int gia){
        try {
            return chiTietPhieuBanHangRepository.insertCTPhieuBanHang(maPhieuBanHang, maSanPham, soLuong, gia);
        } catch (Exception e) {
            return 0;
        }
    }
}
