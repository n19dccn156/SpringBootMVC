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

import KhanhVySang.demo.Model.ThongTinSanPham.DanhMucModel;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucModel, Integer>{
    Optional<DanhMucModel> findByMaDanhMuc(int maDanhMuc);
    Optional<DanhMucModel> findByTenDanhMuc(String tenDanhMuc);
    List<DanhMucModel> findByTrangThai(boolean trangThai);
    
    @Transactional
    @Procedure(procedureName = "SP_Update_tblDanhMuc", outputParameterName = "trangThai")
    public boolean updateDanhMuc(@Param("maDanhMuc") int maDanhMuc,
                                 @Param("tinhTrang") Boolean trangThai,
                                 @Param("tenDanhMuc") String tenDanhMuc);

    // @Transactional
    // @Procedure(procedureName = "SP_Insert_tblDanhMuc", outputParameterName = "trangThai")
    // public boolean insertDanhMuc(@Param("tenDanhMuc") String tenDanhMuc,
    //                              @Param("tinhTrang") boolean trangThai);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tblDanhMuc(tenDanhMuc, hinhAnh, trangThai) values(?1, ?2, ?3)", nativeQuery = true)
    public int insertDanhMuc(String tenDanhMuc, String hinhAnh, boolean trangThai);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tblDanhMuc SET tenDanhMuc = ?1, hinhAnh = ?2, trangThai = ?3 WHERE maDanhMuc = ?4", nativeQuery = true)
    public int updateDanhMuc(String tenDanhMuc, String hinhAnh, boolean trangThai, int maDanhMuc);

}
