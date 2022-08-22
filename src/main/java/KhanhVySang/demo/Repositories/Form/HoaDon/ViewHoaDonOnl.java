package KhanhVySang.demo.Repositories.Form.HoaDon;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.HoaDon.FormHoaDonOnl;

@Repository
public interface ViewHoaDonOnl extends PagingAndSortingRepository<FormHoaDonOnl, String>{
    
    List<FormHoaDonOnl> findAll();
    List<FormHoaDonOnl> findByMaTrangThai(int maTrangThai);
    List<FormHoaDonOnl> findByTenTrangThai(String tenTrangThai);
}
