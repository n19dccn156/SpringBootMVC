package KhanhVySang.demo.Repositories.Form.KhachHang;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import KhanhVySang.demo.Model.Form.KhachHang.FormThongTinKhachHang;

@Repository
@Transactional
public interface ViewThongTinKhachHang extends PagingAndSortingRepository<FormThongTinKhachHang, String>{
    
    List<FormThongTinKhachHang> findAll();
    Page<FormThongTinKhachHang> findAll(Pageable pageable);
}
