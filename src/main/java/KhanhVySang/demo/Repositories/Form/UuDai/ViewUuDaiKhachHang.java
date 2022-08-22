package KhanhVySang.demo.Repositories.Form.UuDai;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.UuDai.FormUuDaiKhachHang;

@Repository
public interface ViewUuDaiKhachHang extends PagingAndSortingRepository<FormUuDaiKhachHang, String>{
    
    List<FormUuDaiKhachHang> findAll();
    Optional<FormUuDaiKhachHang> findByMaUuDai(int maUuDai);
}
