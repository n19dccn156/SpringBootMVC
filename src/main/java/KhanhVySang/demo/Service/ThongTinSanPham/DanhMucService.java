package KhanhVySang.demo.Service.ThongTinSanPham;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinSanPham.DanhMucModel;
import KhanhVySang.demo.Repositories.ThongTinSanPham.DanhMucRepository;

@Service
public class DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;


    public List<DanhMucModel> findAll(){
        return danhMucRepository.findAll();   
    }

    public DanhMucModel findByMaDanhMuc(int maDanhMuc) {
        Optional<DanhMucModel> oDM = danhMucRepository.findByMaDanhMuc(maDanhMuc);
        if(oDM.isEmpty()) return new DanhMucModel();
        return oDM.get();
    }

    public DanhMucModel findByTenDanhMuc(String tenDanhMuc) {
        Optional<DanhMucModel> oDM = danhMucRepository.findByTenDanhMuc(tenDanhMuc);
        if(oDM.isEmpty()) return new DanhMucModel();
        return oDM.get();
    }

    public List<DanhMucModel> findByTrangThai(boolean trangThai) {
        return danhMucRepository.findByTrangThai(trangThai);
    }

    public int updateDanhMuc(String tenDanhMuc, String hinhAnh, boolean trangThai, int maDanhMuc){
        try {
            return danhMucRepository.updateDanhMuc(tenDanhMuc, hinhAnh, trangThai, maDanhMuc);
        } catch (Exception e) {
            return 0;
        }
    }

    public int insertDanhMuc(String tenDanhMuc, String hinhAnh, boolean trangThai){
        try {
            return danhMucRepository.insertDanhMuc(tenDanhMuc, hinhAnh, trangThai);
        } catch (Exception e) {
            return 0;
        }
    }
}
