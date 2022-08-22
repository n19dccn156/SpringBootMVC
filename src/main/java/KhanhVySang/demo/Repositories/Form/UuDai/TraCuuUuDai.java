package KhanhVySang.demo.Repositories.Form.UuDai;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.UuDai.TraCuuUuDaiModel;

@Repository
public interface TraCuuUuDai extends PagingAndSortingRepository<TraCuuUuDaiModel, String>{
    
    List<TraCuuUuDaiModel> findAll();
    TraCuuUuDaiModel findByMaSanPham(int maSanPham);
    List<TraCuuUuDaiModel> findByPhanTramUuDai(int phanTramUuDai);
    List<TraCuuUuDaiModel> findByOrderByPhanTramUuDaiDesc();
}
