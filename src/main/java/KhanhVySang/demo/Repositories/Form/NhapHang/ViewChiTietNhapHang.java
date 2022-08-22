package KhanhVySang.demo.Repositories.Form.NhapHang;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.NhapHang.FormChiTietNhapHang;

@Repository
public interface ViewChiTietNhapHang extends PagingAndSortingRepository<FormChiTietNhapHang, String>{
    
    List<FormChiTietNhapHang> findAll();
    List<FormChiTietNhapHang> findByMaPhieuNhapHang(int maPhieuNhapHang);
}
