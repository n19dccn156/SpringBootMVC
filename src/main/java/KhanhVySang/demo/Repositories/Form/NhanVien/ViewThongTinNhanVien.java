package KhanhVySang.demo.Repositories.Form.NhanVien;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.Form.NhanVien.FormNhanVien;

@Repository
@Transactional
public interface ViewThongTinNhanVien extends PagingAndSortingRepository<FormNhanVien, String>{
    
    List<FormNhanVien> findAll();

    List<FormNhanVien> findByTrangThai(Boolean trangThai);

    
}
