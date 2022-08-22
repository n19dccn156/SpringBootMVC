package KhanhVySang.demo.Repositories.Form.SanPham;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import KhanhVySang.demo.Model.Form.SanPham.FormSanPham;

@Repository
public interface ViewThongTinSanPham extends PagingAndSortingRepository<FormSanPham, String>{
    
    List<FormSanPham> findAll();
    Optional<FormSanPham> findByMaSanPham(int maSanPham);
    List<FormSanPham> findByTenLoaiSanPham(String tenLoaiSanPham);
    List<FormSanPham> findByMaDanhMuc(int maDanhMuc);
    List<FormSanPham> findByMaLoaiSanPham(int maLoaiSanPham);
    List<FormSanPham> findByMaDanhMucAndMaLoaiSanPham(int maDanhMuc, int maLoaiSanPham);

}
