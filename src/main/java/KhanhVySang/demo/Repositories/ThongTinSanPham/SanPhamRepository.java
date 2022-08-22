package KhanhVySang.demo.Repositories.ThongTinSanPham;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamModel, Integer>{
    List<SanPhamModel> findAll();
    Optional<SanPhamModel> findByMaSanPham(int maSanPham);
    Optional<SanPhamModel> findByTenSanPham(String tenSanPham);

    @Query(value = "SELECT sp.* FROM tblSanPham sp where sp.maLoaiSanPham = ?1 order by gia asc limit 10", nativeQuery = true)
    List<SanPhamModel> findByMaLoaiSanPhamLimit10Asc(int maLoaiSanPham);
    @Query(value = "SELECT sp.* FROM tblSanPham sp where sp.maLoaiSanPham = ?1 order by gia desc limit 10", nativeQuery = true)
    List<SanPhamModel> findByMaLoaiSanPhamLimit10Desc(int maLoaiSanPham);

    @Query(value = "SELECT sp.* FROM tblSanPham sp order by sp.gia desc limit 1", nativeQuery = true)
    SanPhamModel findTop1ByGiaDesc();
    @Query(value = "SELECT sp.* FROM tblSanPham sp order by sp.gia asc limit 1", nativeQuery = true)
    SanPhamModel findTop1ByGiaAsc();

    List<SanPhamModel> findByGiaLessThanEqual(int gia);
    List<SanPhamModel> findByGiaLessThanEqualOrderByGiaDesc(int gia);
    List<SanPhamModel> findByGiaLessThanEqualOrderByGiaAsc(int gia);
    @Query(value = "SELECT sp.* FROM tblSanPham sp, (select maSanPham, phanTramUudai from traCuuUudai) ud where ud.maSanPham = sp.maSanPham and sp.gia <= ?1 order by ud.phantramUudai desc", nativeQuery = true)
    List<SanPhamModel> findByGiaLessThanOrderByPTUD(int gia);

    // @Query(value = "SELECT sp.* from tblSanPham sp where sp.maLoaiSanPham in (select maLoaiSanPham from tblLoaiSanPham where maDanhMuc = ?1)", nativeQuery = true)
    // List<SanPhamModel> findByMaDanhMuc(int maDanhMuc);
    @Query(value = "SELECT sp.* from tblSanPham sp where sp.maLoaiSanPham in (select maLoaiSanPham from tblLoaiSanPham where maDanhMuc = ?1) and sp.gia <= ?2", nativeQuery = true)
    List<SanPhamModel> findByMaDanhMucAndGiaLessThan(int maDanhMuc, int gia);
    @Query(value = "SELECT sp.* FROM tblSanPham as sp, (select maSanPham, phanTramUudai from traCuuUudai) as ud where sp.maLoaiSanPham in (select maLoaiSanPham from tblLoaiSanPham where maDanhMuc = ?1) and ud.maSanPham = sp.maSanPham and gia <= ?2 order by ud.phantramUudai desc", nativeQuery = true)
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByPTUD(int maDanhMuc, int gia);
    @Query(value = "SELECT sp.* from tblSanPham sp where sp.maLoaiSanPham in (select maLoaiSanPham from tblLoaiSanPham where maDanhMuc = ?1) and sp.gia <= ?2 order by sp.gia desc", nativeQuery = true)
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByGiaDesc(int maDanhMuc, int gia);
    @Query(value = "SELECT sp.* from tblSanPham sp where sp.maLoaiSanPham in (select maLoaiSanPham from tblLoaiSanPham where maDanhMuc = ?1) and sp.gia <= ?2 order by sp.gia asc", nativeQuery = true)
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByGiaAsc(int maDanhMuc, int gia);

    // List<SanPhamModel> findByMaLoaiSanPham(int maLoaiSanPham);
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanEqual(int maLoaiSanPham, int gia);
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaAsc(int maLoaiSanPham, int gia);
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaDesc(int maLoaiSanPham, int gia);
    @Query(value = "SELECT sp.* FROM tblSanPham as sp, (select maSanPham, phanTramUudai from traCuuUudai) as ud where sp.maLoaiSanPham = ?1 and ud.maSanPham = sp.maSanPham and gia <= ?2 order by ud.phantramUudai desc", nativeQuery = true)
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByPTUD(int maLoaiSanPham, int gia);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblSanPham", outputParameterName = "trangThai")
    public boolean updateSanPham(@Param("maSanPham") int maSanPham,
                                 @Param("tenSanPham") String tenSanpham,
                                 @Param("gia") int i,
                                 @Param("moTa") String moTa,
                                 @Param("hinhAnh") String hinhAnh,
                                 @Param("maLoaiSanPham") Integer maLoaiSanpham,
                                 @Param("maUuDai") int maUuDai);

    // @Transactional
    // @Procedure(procedureName = "SP_Insert_tblSanPham", outputParameterName = "trangThai")
    // public boolean insertSanPham(@Param("tenSanPham") String tenSanpham,
    //                              @Param("gia") int i,
    //                              @Param("moTa") String moTa,
    //                              @Param("hinhAnh") String hinhAnh,
    //                              @Param("maLoaiSanPham") Integer maLoaiSanpham,
    //                              @Param("maUuDai") int maUuDai);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblSanPham(tenSanPham, gia, moTa, hinhAnh, maloaiSanPham) values(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    public int insertSanPham(String tenSanPham, int gia, String moTa, String hinhAnh, int maloaiSanPham);
                                     
}
