package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuTraHangModel;

@Repository
public interface PhieuTraHangRepository extends JpaRepository<PhieuTraHangModel, Integer>{
    
    Optional<PhieuTraHangModel> findByMaPhieuTraHang(int maPhieuTraHang);
    List<PhieuTraHangModel> findByNgayTraHang(Date ngayTraHang);
    List<PhieuTraHangModel> findByMaNhanVien(int maNhanVien);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblPhieuTraHang", outputParameterName = "trangThai")
    public boolean updatePhieuTraHang(@Param("maPhieuTraHang") int maPhieuTraHang,
                                      @Param("maTrangThai") int maTrangThai,
                                      @Param("maNhanVien") int maNhanVien);

    // @Transactional
    // @Procedure(procedureName = "SP_Insert_tblPhieuTraHang", outputParameterName = "trangThai")
    // public boolean insertPhieuTraHang(@Param("maTrangThai") int maTrangThai,
    //                                   @Param("maHoaDon") int maHoaDon,
    //                                   @Param("maNhanVien") int maNhanVien);
}
