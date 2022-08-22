package KhanhVySang.demo.Repositories.Form.TraHang;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.TraHang.FormChiTietTraHang;

@Repository
public interface ViewChiTietTraHang extends PagingAndSortingRepository<FormChiTietTraHang, String>{
    
    List<FormChiTietTraHang> findAll();
    List<FormChiTietTraHang> findByMaPhieuTraHang(int maPhieuTraHang);
}
