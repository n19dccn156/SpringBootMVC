package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietPhieuBanHangKey;
import KhanhVySang.demo.Model.ThongTinMuaHang.ChiTietPhieuTraHangModel;

@Repository
public interface ChiTietPhieuTraHangRepository extends JpaRepository<ChiTietPhieuTraHangModel, ChiTietPhieuBanHangKey>{
    
    List<ChiTietPhieuTraHangModel> findByMaPhieuTraHang(int maPhieuTraHang);
    List<ChiTietPhieuTraHangModel> findByMaSanPham(int maSanPham);

    @Transactional
    @Procedure(procedureName = "SP_Delete_tblChiTietPhieuTraHang", outputParameterName = "trangThai")
    public boolean deleteCTPhieuTraHang(@Param("maPhieuTraHang") int maPhieuTraHang,
                                       @Param("maSanPham") int maSanPham) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblChiTietPhieuTraHang", outputParameterName = "trangThai")
    public boolean updateCTPhieuTraHang(@Param("maPhieuTraHang") int maPhieuTraHang,
                                        @Param("maSanPham") int maSanPham,
                                        @Param("soLuong") int soLuong,
                                        @Param("lyDo") String lyDo) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblChiTietPhieuTraHang", outputParameterName = "trangThai")
    public boolean insertCTPhieuTraHang(@Param("maPhieuTraHang") int maPhieuTraHang,
                                        @Param("maSanPham") int maSanPham,
                                        @Param("soLuong") int soLuong,
                                        @Param("lyDo") String lyDo) throws Exception;
}
