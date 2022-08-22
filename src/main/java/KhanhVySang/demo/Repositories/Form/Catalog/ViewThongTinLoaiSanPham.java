package KhanhVySang.demo.Repositories.Form.Catalog;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.Form.Catalog.FormThongTinLoaiSanPham;

@Repository
@Transactional
public interface ViewThongTinLoaiSanPham extends PagingAndSortingRepository<FormThongTinLoaiSanPham, String>{
    
    List<FormThongTinLoaiSanPham> findAll();
    List<FormThongTinLoaiSanPham> findByMaDanhMuc(int maDanhMuc);
    List<FormThongTinLoaiSanPham> findByTrangThai(Boolean trangThai);
}
