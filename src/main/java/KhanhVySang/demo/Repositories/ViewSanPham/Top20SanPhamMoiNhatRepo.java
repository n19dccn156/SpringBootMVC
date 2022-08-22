package KhanhVySang.demo.Repositories.ViewSanPham;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.ViewSanPham.Top20MoiNhat;

@Repository
public interface Top20SanPhamMoiNhatRepo extends PagingAndSortingRepository<Top20MoiNhat, String>{
    
    List<Top20MoiNhat> findAll();
}
