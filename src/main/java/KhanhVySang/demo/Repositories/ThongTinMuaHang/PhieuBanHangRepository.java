package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuBanHangModel;

@Repository
public interface PhieuBanHangRepository extends JpaRepository<PhieuBanHangModel, Integer>{
 
    Optional<PhieuBanHangModel> findByMaPhieuBanHang(int maPhieuBanHang);
    List<PhieuBanHangModel> findByNgayBanHang(Date ngayBanHang);
    Optional<PhieuBanHangModel> findByDienThoai(String SDT);
    List<PhieuBanHangModel> findByMaNhanVien(int maNhanVien);
    List<PhieuBanHangModel> findByMaKhachHang(int maKhachHang);
    List<PhieuBanHangModel> findByMaUuDai(int maUuDai);
    List<PhieuBanHangModel> findByMaTrangThai(int maTrangThai);
    

    @Query(value = "SELECT pbh.maPhieuBanHang FROM tblPhieuBanHang pbh ORDER BY pbh.maPhieuBanHang desc limit 1", nativeQuery = true)
    public int findMaPhieuBanHangNew();

    @Transactional
    @Procedure(procedureName = "SP_Update_tblPhieuBanHang", outputParameterName = "trangThai")
    public boolean updatePhieuBanHang(@Param("maPhieuBanHang") int maPhieuBanHang,
                                      @Param("maTrangThai") int maTrangThai,
                                      @Param("maNhanVien") int maNhanVien);

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblPhieuBanHang", outputParameterName = "trangThai")
    public boolean insertPhieuBanHang(@Param("diaChi") String diaChi,
                                      @Param("dienThoai") String dienThoai,
                                      @Param("maNhanVien") int maNhanVien,
                                      @Param("maKhachHang") int maKhachHang,
                                      @Param("maUuDai") int maUuDai,
                                      @Param("maTrangThai") int maTrangThai);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblPhieuBanHang(diachi, dienthoai, maKhachHang, ho, ten) values(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    public int insertTblPhieuBanHangOnl(String diaChi, String dienThoai, int maKhachHang, String ho, String ten);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblPhieuBanHang(maNhanvien, maTrangTHai) values(?1, ?2)", nativeQuery = true)
    public int insertTblPhieuBanHangOff(int maNhanVien, int maTrangThai);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tblPhieuBanHang set maTrangThai = ?1, maNhanVien = ?2 where maPhieuBanHang = ?3", nativeQuery = true)
    public int updatePhieuBanHangTrangThai(int maTrangThai, int maNhanVien, int maPhieuBanHang);
    
}
