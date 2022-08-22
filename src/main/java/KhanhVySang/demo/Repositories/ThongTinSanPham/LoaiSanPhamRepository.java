package KhanhVySang.demo.Repositories.ThongTinSanPham;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinSanPham.LoaiSanPhamModel;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPhamModel, Integer>{
    Optional<LoaiSanPhamModel> findByMaLoaiSanPham(int maLoaiSanPham);
    Optional<LoaiSanPhamModel> findByTenLoaiSanPham(String tenLoaiSanPham);
    List<LoaiSanPhamModel> findByTrangThai(boolean trangThai);
    List<LoaiSanPhamModel> findByMaDanhMuc(int maDanhMuc);
    List<LoaiSanPhamModel> findByMaDanhMucAndTrangThai(int maDanhMuc, boolean trangThai);

    // @Transactional
    // @Procedure(procedureName = "SP_Update_tblLoaiSanPham", outputParameterName = "trangThai")
    // public boolean updateLoaiSanPham(@Param("maLoaiSanPham") int maLoaiSanPham,
    //                                  @Param("tenLoaiSanPham") String tenLoaiSanpham,
    //                                  @Param("tinhTrang") Boolean trangThai,
    //                                  @Param("maDanhMuc") int maDanhMuc);

    // @Transactional
    // @Procedure(procedureName = "SP_Insert_tblLoaiSanPham", outputParameterName = "trangThai")
    // public boolean insertLoaiSanPham(@Param("tenLoaiSanPham") String tenLoaiSanpham,
    //                                  @Param("tinhTrang") Boolean trangThai,
    //                                  @Param("maDanhMuc") int maDanhMuc);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblLoaiSanPham(tenLoaiSanPham, trangThai, maDanhMuc) values(?1, ?2, ?3)", nativeQuery = true)
    public int insertLoaiSanPham(String tenLoaiSanPham, boolean trangThai, int maDanhMuc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tblLoaiSanPham SET tenLoaiSanPham = ?1, trangThai = ?2, maDanhMuc = ?3 WHERE maLoaiSanPham = ?4", nativeQuery = true)
    public int updateLoaiSanPham(String tenLoaiSanPham, boolean trangThai, int maDanhMuc, int maLoaiSanPham);


}
