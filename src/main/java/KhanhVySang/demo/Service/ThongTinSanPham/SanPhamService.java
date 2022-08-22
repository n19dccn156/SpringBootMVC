package KhanhVySang.demo.Service.ThongTinSanPham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.ThongTinSanPham.SanPhamRepository;

@Service
public class SanPhamService {
    
    @Autowired
    private SanPhamRepository sanPhamRepository;
    
    public List<SanPhamModel> findAll(){
        return sanPhamRepository.findAll();
    }

    public List<SanPhamModel> findByMaLoaiSanPhamLimit10Asc(int maLoaiSanPham){
        return sanPhamRepository.findByMaLoaiSanPhamLimit10Asc(maLoaiSanPham);
    }

    public List<SanPhamModel> findByMaLoaiSanPhamLimit10Desc(int maLoaiSanPham){
        return sanPhamRepository.findByMaLoaiSanPhamLimit10Desc(maLoaiSanPham);
    }

    public SanPhamModel findTop1ByGiaDesc(){
        return sanPhamRepository.findTop1ByGiaDesc();
    }

    public SanPhamModel findTop1ByGiaAsc(){
        return sanPhamRepository.findTop1ByGiaAsc();
    }

    public SanPhamModel findByMaSanPham(int maSanPham){
        Optional<SanPhamModel> oSP = sanPhamRepository.findByMaSanPham(maSanPham);
        if(oSP.isPresent()) return oSP.get();
        return new SanPhamModel();
    }

    public SanPhamModel findByTenSanPham(String tenSanPham){
        Optional<SanPhamModel> oSP = sanPhamRepository.findByTenSanPham(tenSanPham);
        if(oSP.isPresent()) return oSP.get();
        return new SanPhamModel();
    }

    public List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByAsc(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaAsc(maLoaiSanPham, gia);
    }

    public List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByDesc(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaDesc(maLoaiSanPham, gia);
    }

    List<SanPhamModel> findByGiaLessThan(int gia){
        return sanPhamRepository.findByGiaLessThanEqual(gia);
    }
    List<SanPhamModel> findByGiaLessThanOrderByGiaDesc(int gia){
        return sanPhamRepository.findByGiaLessThanEqualOrderByGiaDesc(gia);
    }
    List<SanPhamModel> findByGiaLessThanOrderByGiaAsc(int gia){
        return sanPhamRepository.findByGiaLessThanEqualOrderByGiaAsc(gia);
    }
    List<SanPhamModel> findByGiaLessThanOrderByPTUD(int gia){
        return sanPhamRepository.findByGiaLessThanOrderByPTUD(gia);
    }

    // List<SanPhamModel> findByMaDanhMuc(int maDanhMuc){
    //     return sanPhamRepository.findByMaDanhMuc(maDanhMuc);
    // }
    List<SanPhamModel> findByMaDanhMucAndGiaLessThan(int maDanhMuc, int gia){
        return sanPhamRepository.findByMaDanhMucAndGiaLessThan(maDanhMuc, gia);
    }
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByPTUD(int maDanhMuc, int gia){
        return sanPhamRepository.findByMaDanhMucAndGiaLessThanOrderByPTUD(maDanhMuc, gia);
    }
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByGiaDesc(int maDanhMuc, int gia){
        return sanPhamRepository.findByMaDanhMucAndGiaLessThanOrderByGiaDesc(maDanhMuc, gia);
    }
    List<SanPhamModel> findByMaDanhMucAndGiaLessThanOrderByGiaAsc(int maDanhMuc, int gia){
        return sanPhamRepository.findByMaDanhMucAndGiaLessThanOrderByGiaAsc(maDanhMuc, gia);
    }

    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThan(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanEqual(maLoaiSanPham, gia);
    }
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByGiaAsc(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaAsc(maLoaiSanPham, gia);
    }
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByGiaDesc(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanEqualOrderByGiaDesc(maLoaiSanPham, gia);
    }
    
    List<SanPhamModel> findByMaLoaiSanPhamAndGiaLessThanOrderByPTUD(int maLoaiSanPham, int gia){
        return sanPhamRepository.findByMaLoaiSanPhamAndGiaLessThanOrderByPTUD(maLoaiSanPham, gia);
    }

    public Page<SanPhamModel> findPaginatedLoaiSanPham(Pageable pageable, int maLoaiSanPham, int gia, int sapXep) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<SanPhamModel> list = new ArrayList<>();
        List<SanPhamModel> sanPham = new ArrayList<>();;
        if(sapXep == 0) 
            sanPham = findByMaLoaiSanPhamAndGiaLessThan(maLoaiSanPham, gia);
        else if(sapXep == 1)
            sanPham = findByMaLoaiSanPhamAndGiaLessThanOrderByDesc(maLoaiSanPham, gia);
        else if(sapXep == 2)
            sanPham = findByMaLoaiSanPhamAndGiaLessThanOrderByAsc(maLoaiSanPham, gia);
        else if(sapXep == 3)
            sanPham = findByMaLoaiSanPhamAndGiaLessThanOrderByPTUD(maLoaiSanPham, gia);
    

        if (sanPham.size() < startItem)
            list = Collections.emptyList();
        else {
            int toIndex = Math.min(startItem + pageSize, sanPham.size());
            list = sanPham.subList(startItem, toIndex);
        }

        Page<SanPhamModel> bookPage
          = new PageImpl<SanPhamModel>(list, PageRequest.of(currentPage, pageSize), sanPham.size());

        return bookPage;
    }


    public boolean updateSanPham(SanPhamModel sanPham){
        try {
            return sanPhamRepository.updateSanPham(sanPham.getMaSanPham(), 
                                                   sanPham.getTenSanPham(),
                                                   sanPham.getGia(), 
                                                   sanPham.getMoTa(), 
                                                   sanPham.getHinhAnh(),
                                                   sanPham.getMaLoaiSanPham(),
                                                   sanPham.getMaUuDai());
        } catch (Exception e) {
            return false;
        }
    }

    public int insertSanPham(String tenSanPham, int gia, String moTa, String hinhAnh, int maLoaiSanPham){
        try {
            return sanPhamRepository.insertSanPham(tenSanPham, gia, moTa, hinhAnh, maLoaiSanPham);
        } catch (Exception e) {
            return 0;
        }
    }


    public Page<SanPhamModel> findPaginated(Pageable pageable, int gia, int sapXep) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<SanPhamModel> list = new ArrayList<>();
        List<SanPhamModel> sanPham = new ArrayList<>();

        if(sapXep == 0) 
            sanPham = findByGiaLessThan(gia);
        else if(sapXep == 1)
            sanPham = findByGiaLessThanOrderByGiaDesc(gia);
        else if(sapXep == 2)
            sanPham = findByGiaLessThanOrderByGiaAsc(gia);
        else if(sapXep == 3)
            sanPham = findByGiaLessThanOrderByPTUD(gia);
    

        if (sanPham.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, sanPham.size());
            list = sanPham.subList(startItem, toIndex);
        }

        Page<SanPhamModel> bookPage
          = new PageImpl<SanPhamModel>(list, PageRequest.of(currentPage, pageSize), sanPham.size());

        return bookPage;
    }

    public Page<SanPhamModel> findPaginatedDanhMuc(Pageable pageable, int maDanhMuc, int gia, int sapXep) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<SanPhamModel> list = new ArrayList<>();
        List<SanPhamModel> sanPham = new ArrayList<>();


        if(sapXep == 0) 
            sanPham = findByMaDanhMucAndGiaLessThan(maDanhMuc, gia);
        else if(sapXep == 1)
            sanPham = findByMaDanhMucAndGiaLessThanOrderByGiaDesc(maDanhMuc, gia);
        else if(sapXep == 2)
            sanPham = findByMaDanhMucAndGiaLessThanOrderByGiaAsc(maDanhMuc, gia);
        else if(sapXep == 3)
            sanPham = findByMaDanhMucAndGiaLessThanOrderByPTUD(maDanhMuc ,gia);
        
       
        if (sanPham.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, sanPham.size());
            list = sanPham.subList(startItem, toIndex);
        }
        

        Page<SanPhamModel> bookPage
          = new PageImpl<SanPhamModel>(list, PageRequest.of(currentPage, pageSize), sanPham.size());

        return bookPage;
    }
}
