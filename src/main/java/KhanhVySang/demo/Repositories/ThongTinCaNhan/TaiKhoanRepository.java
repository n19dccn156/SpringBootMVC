package KhanhVySang.demo.Repositories.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanModel, Integer>{
    
    Optional<TaiKhoanModel> findByMaTaiKhoan(int maTaiKhoan);
    Optional<TaiKhoanModel> findByTenDangNhap(String tenDangNhap);
    Optional<TaiKhoanModel> findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
    Optional<TaiKhoanModel> findByEmail(String email);
    List<TaiKhoanModel> findByMatKhau(String email);
    List<TaiKhoanModel> findByNgayTao(Date ngayTao);
    List<TaiKhoanModel> findByQuyen(String quyen);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblTaiKhoan_ByMatKhau", outputParameterName = "trangThai")
    public boolean updateTaiKhoan(@Param("tenDangNhap") String tenDangNhap, 
                                  @Param("matKhauCu") String matKhauCu,
                                  @Param("matKhauMoi") String matKhauMoi) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblTaiKhoan", outputParameterName = "trangThai")
    public boolean updateTaiKhoan(@Param("maTaiKhoan") int maTaiKhoan,
                                  @Param("matKhau") String matKhau,
                                  @Param("email") String email) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblTaiKhoan", outputParameterName = "trangThai")
    public boolean InsertTaiKhoan(@Param("tenDangNhap") String tenDangNhap,
                                  @Param("matKhau") String matKhau,
                                  @Param("email") String email) throws Exception;
}
