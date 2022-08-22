package KhanhVySang.demo.Service.ThongTinMuaHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuNhapHangModel;

@Repository
public interface PhieuNhapHangService extends JpaRepository<PhieuNhapHangModel, Integer>{
    
    List<PhieuNhapHangModel> findAll();
}
