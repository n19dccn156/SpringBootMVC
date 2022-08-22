package KhanhVySang.demo.Repositories.ThongTinUuDai;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiKhachHangModel;

@Repository
public interface UuDaiKhachHangRepository extends JpaRepository<UuDaiKhachHangModel, Integer>{
    Optional<UuDaiKhachHangModel> findByMaUuDai(int maUuDai);
    List<UuDaiKhachHangModel> findByPhanTramUuDai(float phanTramUuDai);
    List<UuDaiKhachHangModel> findByNgayBatDau(Date ngayBatDau);
    List<UuDaiKhachHangModel> findByNgayKetThuc(Date ngayKetThuc);
    List<UuDaiKhachHangModel> findByMaNhanVien(int maNhanVien);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblUuDaiKhachHang", outputParameterName = "trangThai")
    public boolean updateUuDaiKhachHang(@Param("maUuDai") int maKhachHang,
                                        @Param("tenUuDai") String tenUuDai,
                                        @Param("phanTramUuDai") float phanTramUuDai,
                                        @Param("moTa") String moTa,
                                        @Param("dieuKien") float dieuKien,
                                        @Param("donGiaToiThieu") float donGiaToiThieu,
                                        @Param("uuDaiToiDa") float uuDaiToiDa,
                                        @Param("ngayBatDau") Date ngayBatDau,
                                        @Param("ngayKetThuc") Date ngayKetThuc) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblUuDaiKhachHang", outputParameterName = "trangThai")
    public boolean insertUuDaiKhachHang(@Param("tenUuDai") String tenUuDai,
                                        @Param("phanTramUuDai") float phanTramUuDai,
                                        @Param("moTa") String moTa,
                                        @Param("dieuKien") float dieuKien,
                                        @Param("donGiaToiThieu") float donGiaToiThieu,
                                        @Param("uuDaiToiDa") float uuDaiToiDa,
                                        @Param("ngayBatDau") Date ngayBatDau,
                                        @Param("ngayKetThuc") Date ngayKetThuc,
                                        @Param("maNhanVien") int maNhanVien) throws Exception;
}

