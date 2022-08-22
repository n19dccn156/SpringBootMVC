package KhanhVySang.demo.Repositories.ThongTinUuDai;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.KhoaChinh.ChiTietUuDaiKey;
import KhanhVySang.demo.Model.ThongTinUuDai.ChiTietUuDaiModel;

@Repository
public interface ChiTietUuDaiRepository extends JpaRepository<ChiTietUuDaiModel, ChiTietUuDaiKey>{
    
    List<ChiTietUuDaiModel> findByMaUuDai(int maUuDai);
    List<ChiTietUuDaiModel> findByMaKhachHang(int maKhachHang);

    @Transactional
    @Procedure(procedureName = "SP_Delete_tblChiTietUuDaiKhachHang", outputParameterName = "trangThai")
    public boolean deleteCTUDKhachHang(@Param("maKhachHang") int maKhachHang,
                                       @Param("maUuDai") int maUuDai) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Update_tblChiTietUuDaiKhachHang", outputParameterName = "trangThai")
    public boolean updateCTUDKhachHang(@Param("maKhachHang") int maKhachHang,
                                       @Param("maUuDai") int maUuDai,
                                       @Param("soLuong") int soLuong) throws Exception;

    @Transactional
    @Procedure(procedureName = "SP_Insert_tblChiTietUuDaiKhachHang", outputParameterName = "trangThai")
    public boolean insertCTUDKhachHang(@Param("maKhachHang") int maKhachHang,
                                       @Param("maSanPham") int maSanPham,
                                       @Param("soLuong") int soLuong) throws Exception;
}
