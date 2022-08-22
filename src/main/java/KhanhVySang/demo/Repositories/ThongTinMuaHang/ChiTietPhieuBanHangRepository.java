package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietPhieuBanHangKey;
import KhanhVySang.demo.Model.ThongTinMuaHang.ChiTietPhieuBanHangModel;

@Repository
public interface ChiTietPhieuBanHangRepository extends JpaRepository<ChiTietPhieuBanHangModel, ChiTietPhieuBanHangKey>{
 
    List<ChiTietPhieuBanHangModel> findByMaPhieuBanHang(int maPhieuBanHang);
    List<ChiTietPhieuBanHangModel> findByMaSanPham(int maSanPham);

    @Transactional
    @Procedure(procedureName = "SP_Delete_tblChiTietPhieuBanHang", outputParameterName = "trangThai")
    public boolean deleteCTPhieuBanHang(@Param("maPhieuBanHang") int maPhieuBanHang,
                                        @Param("maSanPham") int maSanPham) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblChiTietPhieuBanHang", outputParameterName = "trangThai")
    public boolean updateCTPhieuBanHang(@Param("maPhieuBanHang") int maPhieuBanHang,
                                         @Param("maSanPham") int maSanPham,
                                         @Param("soLuong") int soLuong,
                                         @Param("gia") float gia) throws Exception;

    // @Transactional
    // @Procedure(procedureName = "SP_Insert_tblChiTietPhieuBanHang", outputParameterName = "trangThai")
    // public boolean insertCTPhieuBanHang(@Param("maPhieuBanHang") int maPhieuBanHang,
    //                                      @Param("maSanPham") int maSanPham,
    //                                      @Param("soLuong") int soLuong,
    //                                      @Param("gia") int gia) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblChiTietPhieuBanHang values(?1, ?2, ?3, ?4)", nativeQuery = true)
    public int insertCTPhieuBanHang(@Param("maPhieuBanHang") int maPhieuBanHang, 
                                    @Param("maSanPham") int maSanPham,
                                    @Param("soLuong") int soLuong,
                                    @Param("gia") int gia);

}
