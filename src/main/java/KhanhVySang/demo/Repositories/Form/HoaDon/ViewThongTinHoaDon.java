package KhanhVySang.demo.Repositories.Form.HoaDon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.HoaDon.FormThongTinHoaDon;

@Repository
public interface ViewThongTinHoaDon extends PagingAndSortingRepository<FormThongTinHoaDon, String>{
    
    List<FormThongTinHoaDon> findAll(); 
    Optional<FormThongTinHoaDon> findByMaPhieuBanHang(int maPhieuBanHang);
}
