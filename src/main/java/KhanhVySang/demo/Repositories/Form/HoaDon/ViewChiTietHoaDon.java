package KhanhVySang.demo.Repositories.Form.HoaDon;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.HoaDon.FormChiTietHoaDon;

@Repository
public interface ViewChiTietHoaDon extends PagingAndSortingRepository<FormChiTietHoaDon, String>{
    
    List<FormChiTietHoaDon> findAll();
     List<FormChiTietHoaDon> findByMaHoaDon(int maHoaDon);
}
