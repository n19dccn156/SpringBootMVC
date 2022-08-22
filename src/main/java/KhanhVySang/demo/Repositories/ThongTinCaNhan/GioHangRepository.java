package KhanhVySang.demo.Repositories.ThongTinCaNhan;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.KhoaChinh.GioHangKey;
import KhanhVySang.demo.Model.ThongTinCaNhan.GioHangModel;

@Repository
public interface GioHangRepository extends JpaRepository<GioHangModel, GioHangKey>{
   
    List<GioHangModel> findByMaKhachHang(int maKhachHang);
    List<GioHangModel> findByMaSanPham(int maSanPham);
    List<GioHangModel> findAll();
    Optional<GioHangModel> findByMaKhachHangAndMaSanPham(int maKhachHang, int maSanPham);
    // void insertGioHang(GioHangModel gioHang) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tblGioHang gh where gh.maKhachHang = ?1 and gh.maSanPham = ?2", nativeQuery = true)
    public int delete1SPGioHang(int maKhachHang, int maSanPham);
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tblGioHang gh where gh.maKhachHang = ?1", nativeQuery = true)
    public int deleteGioHang(int maKhachHang);


    // @Transactional
    // @Procedure(procedureName = "SP_Delete_tblGioHang", outputParameterName = "trangThai")
    // public boolean deleteGioHang(@Param("maKhachHang") int maKhachHang,
    //                              @Param("maSanPham") int maSanPham) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblGioHang", outputParameterName = "trangThai")
    public boolean updateGioHang(@Param("maKhachHang") int maKhachHang,
                                 @Param("maSanPham") int maSanPham,
                                 @Param("soLuong") int soLuong) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblGioHang", outputParameterName = "trangThai")
    public boolean insertGioHang(@Param("maKhachHang") int maKhachHang,
                                 @Param("maSanPham") int maSanPham,
                                 @Param("soLuong") int soLuong) throws Exception;
}
