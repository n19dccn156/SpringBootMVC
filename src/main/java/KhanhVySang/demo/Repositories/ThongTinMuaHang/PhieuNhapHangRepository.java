package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuNhapHangModel;

@Repository
public interface PhieuNhapHangRepository extends JpaRepository<PhieuNhapHangModel, Integer>{
    
    Optional<PhieuNhapHangModel> findByMaPhieuNhapHang(int maPhieuNhapHang);
    List<PhieuNhapHangModel> findByNgayNhapHang(Date ngayNhapHang);
    List<PhieuNhapHangModel> findByMaNhanVien(int maNhanVien);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblPhieuNhapHang", outputParameterName = "trangThai")
    public boolean updatePhieuNhapHang(@Param("maPhieuNhapHang") int maPhieuNhapHang,
                                       @Param("maTrangThai") int maTrangThai,
                                       @Param("maNhanVien") int maNhanVien);

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblPhieuNhapHang", outputParameterName = "trangThai")
    public boolean insertPhieuNhapHang(@Param("maNhanVien") int maNhanVien);
}
