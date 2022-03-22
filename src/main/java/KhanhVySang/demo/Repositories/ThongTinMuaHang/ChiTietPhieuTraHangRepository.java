package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ThongTinMuaHang.ChiTietPhieuTraHangModel;

@Repository
public interface ChiTietPhieuTraHangRepository extends JpaRepository<ChiTietPhieuTraHangModel, Integer>{
    
}