package KhanhVySang.demo.Repositories.ThongTinUuDai;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiSanPhamModel;

@Repository
public interface UuDaiSanPhamRepository extends JpaRepository<UuDaiSanPhamModel, Integer>{
    List<UuDaiSanPhamModel> findAll();
    Optional<UuDaiSanPhamModel> findByMaUuDai(int maUuDai);
    Optional<UuDaiSanPhamModel> findByTenUuDai(String tenUuDai);
    List<UuDaiSanPhamModel> findByNgayBatDau(Date ngayBatDau);
    List<UuDaiSanPhamModel> findByNgayKetThuc(Date ngayKetThuc);
    List<UuDaiSanPhamModel> findByMaNhanVien(int maNhanVien);
    List<UuDaiSanPhamModel> findByPhanTramUuDai(float phanTramUuDai);
    @Query(value = "SELECT * FROM tblUuDaiSanPham where maUuDai = :maUuDai and ngayKetThuc > now()", nativeQuery = true)
    UuDaiSanPhamModel findByMaUuDaiSuDung(@Param("maUuDai") int maUuDai) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblUuDaiSanPham", outputParameterName = "trangThai")
    public boolean updateUuDaiSanPham(@Param("maUuDai") int maKhachHang,
                                      @Param("tenUuDai") String tenUuDai,
                                      @Param("phanTramUuDai") float phanTramUuDai,
                                      @Param("moTa") String moTa,
                                      @Param("ngayBatDau") Date ngayBatDau,
                                      @Param("ngayKetThuc") Date ngayKetThuc) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblUuDaiSanPham", outputParameterName = "trangThai")
    public boolean insertUuDaiSanPham(@Param("tenUuDai") String tenUuDai,
                                      @Param("phanTramUuDai") float phanTramUuDai,
                                      @Param("moTa") String moTa,
                                      @Param("ngayBatDau") Date ngayBatDau,
                                      @Param("ngayKetThuc") Date ngayKetThuc,
                                      @Param("maNhanVien") int maNhanVien) throws Exception;
}
