package KhanhVySang.demo.Repositories.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangModel, String>{
    
    List<KhachHangModel> findAll();
    Optional<KhachHangModel> findByMaKhachHang(int maKhachHang);
    List<KhachHangModel> findByHo(String ho);
    List<KhachHangModel> findByTen(String ten);
    List<KhachHangModel> findByGioiTinh(String gioiTinh);
    Optional<KhachHangModel> findByDienThoai(String dienThoai);
    List<KhachHangModel> findByNgaySinh(Date ngaySinh);
    Optional<KhachHangModel> findByMaTaiKhoan(int maTaiKhoan);
    
    @Transactional
    @Procedure(procedureName = "SP_Update_tblKhachHang", outputParameterName = "trangThai")
    public boolean updateKhachHang(@Param("ho") String ho,
                                  @Param("ten") String ten,
                                  @Param("gioiTinh") String gioiTinh,
                                  @Param("dienThoai") String dienThoai,
                                  @Param("ngaySinh") Date ngaySinh,
                                  @Param("maTaiKhoan") int maTaiKhoan) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblKhachHang", outputParameterName = "trangThai")
    public boolean InsertKhachHang(@Param("ho") String ho,
                                  @Param("ten") String ten,
                                  @Param("gioiTinh") String gioiTinh,
                                  @Param("dienThoai") String dienThoai,
                                  @Param("ngaySinh") Date ngaySinh,
                                  @Param("maTaiKhoan") int maTaiKhoan) throws Exception;

    // @Query(nativeQuery = true, value = "SELECT * FROM Form_ThongTinKhachHang")
    // public List<FormThongTinKhachHang> getThongTinKhachHang();
                                     
}
