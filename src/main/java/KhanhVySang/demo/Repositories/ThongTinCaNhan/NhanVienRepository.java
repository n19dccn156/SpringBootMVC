package KhanhVySang.demo.Repositories.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinCaNhan.NhanVienModel;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienModel, Integer>{
    
    Optional<NhanVienModel> findByMaNhanVien(int maNhanVien);
    List<NhanVienModel> findByHo(String ho);
    List<NhanVienModel> findByTen(String ten);
    List<NhanVienModel> findByGioiTinh(String gioiTinh);
    Optional<NhanVienModel> findByDienThoai(String SDT);
    Optional<NhanVienModel> findByCCCD(String cccd);
    List<NhanVienModel> findByNgaySinh(Date ngaySinh);
    Optional<NhanVienModel> findByMaTaiKhoan(int maTaiKhoan);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblNhanVien", outputParameterName = "trangThai")
    public boolean updateNhanVien(@Param("ho") String ho,
                                  @Param("ten") String ten,
                                  @Param("gioiTinh") String gioiTinh,
                                  @Param("dienThoai") String dienThoai,
                                  @Param("cccd") String cccd,
                                  @Param("ngaySinh") Date ngaySinh,
                                  @Param("maTaiKhoan") int maTaiKhoan) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblNhanVien", outputParameterName = "trangThai")
    public boolean InsertNhanVien(@Param("ho") String ho,
                                  @Param("ten") String ten,
                                  @Param("gioiTinh") String gioiTinh,
                                  @Param("dienThoai") String dienThoai,
                                  @Param("cccd") String cccd,
                                  @Param("ngaySinh") Date ngaySinh,
                                  @Param("maTaiKhoan") int maTaiKhoan) throws Exception;
}
