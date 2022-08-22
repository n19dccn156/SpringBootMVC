package KhanhVySang.demo.Repositories.ViewSanPham;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ViewSanPham.Top20BanNhieu;

@Repository
public interface Top20SanPhamBanNhieuRepo extends PagingAndSortingRepository<Top20BanNhieu, String>{
    
    List<Top20BanNhieu> findAll();
}
