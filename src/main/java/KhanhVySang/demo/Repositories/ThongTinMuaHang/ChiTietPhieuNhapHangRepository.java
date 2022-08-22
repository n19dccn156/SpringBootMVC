package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietPhieuNhapHangKey;
import KhanhVySang.demo.Model.ThongTinMuaHang.ChiTietPhieuNhapHangModel;

@Repository
public interface ChiTietPhieuNhapHangRepository extends JpaRepository<ChiTietPhieuNhapHangModel, ChiTietPhieuNhapHangKey>{
    
    List<ChiTietPhieuNhapHangModel> findByMaPhieuNhapHang(int maPhieuNhapHang);
    List<ChiTietPhieuNhapHangModel> findByMaSanPham(int maSanPham);

    @Transactional
    @Procedure(procedureName = "SP_Delete_tblChiTietPhieuNhapHang", outputParameterName = "trangThai")
    public boolean deleteCTPhieuNhapHang(@Param("maPhieuNhapHang") int maPhieuNhapHang,
                                        @Param("maSanPham") int maSanPham) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblChiTietPhieuNhapHang", outputParameterName = "trangThai")
    public boolean updateCTPhieuNhapHang(@Param("maPhieuNhapHang") int maPhieuNhapHang,
                                         @Param("maSanPham") int maSanPham,
                                         @Param("soLuong") int soLuong,
                                         @Param("gia") float gia) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblChiTietPhieuNhapHang", outputParameterName = "trangThai")
    public boolean insertCTPhieuNhapHang(@Param("maPhieuNhapHang") int maPhieuNhapHang,
                                         @Param("maSanPham") int maSanPham,
                                         @Param("soLuong") int soLuong,
                                         @Param("gia") float gia) throws Exception;
}
