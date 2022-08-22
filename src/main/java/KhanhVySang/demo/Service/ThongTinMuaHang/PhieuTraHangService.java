package KhanhVySang.demo.Service.ThongTinMuaHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuTraHangModel;

@Repository
public interface PhieuTraHangService extends JpaRepository<PhieuTraHangModel, Integer>{
    
    List<PhieuTraHangModel> findAll();
    List<PhieuTraHangModel> findByMaTrangThai(int maTrangThai);
}
