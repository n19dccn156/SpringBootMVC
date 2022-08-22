package KhanhVySang.demo.Repositories.ThongTinMuaHang;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.ThongTinMuaHang.TrangThaiGiaoHangModel;

@Repository
public interface TrangThaiGiaoHangRepository extends JpaRepository<TrangThaiGiaoHangModel, Integer>{
    
    List<TrangThaiGiaoHangModel> findAll();
    Optional<TrangThaiGiaoHangModel> findByMaTrangThai(int maTrangThai); 
    Optional<TrangThaiGiaoHangModel> findByTenTrangThai(int tenTrangThai);

    @Transactional
    @Procedure(procedureName = "SP_Update_tblTrangThaiGiaoHang", outputParameterName = "trangThai")
    public boolean updateTrangThaiGiaoHang(@Param("maTrangThai") int maDanhMuc,
                                           @Param("tenTrangThai") String tenTrangThai);

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblTrangThaiGiaoHang", outputParameterName = "trangThai")
    public boolean insertTrangThaiGiaoHang(@Param("tenTrangThai") String tenTrangThai);
}
