package KhanhVySang.demo.Repositories.Form.UuDai;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.UuDai.FormUuDaiSanPham;

@Repository
public interface ViewUuDaiSanPham extends PagingAndSortingRepository<FormUuDaiSanPham, String>{
    
    List<FormUuDaiSanPham> findAll();
    Optional<FormUuDaiSanPham> findByMaUuDai(int maUuDai);
}
