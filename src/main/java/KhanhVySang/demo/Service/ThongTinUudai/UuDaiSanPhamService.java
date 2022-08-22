package KhanhVySang.demo.Service.ThongTinUudai;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiSanPhamModel;
import KhanhVySang.demo.Repositories.ThongTinUuDai.UuDaiSanPhamRepository;

@Service
public class UuDaiSanPhamService {
    
    @Autowired
    UuDaiSanPhamRepository uuDaiSanPhamRepository;


    public List<UuDaiSanPhamModel> findAll(){
        return uuDaiSanPhamRepository.findAll();
    }

    public Optional<UuDaiSanPhamModel> findByMaUuDai(int maUuDai){
        return uuDaiSanPhamRepository.findByMaUuDai(maUuDai);
    }

    public Optional<UuDaiSanPhamModel> findByTenUuDai(String tenUuDai){
        return uuDaiSanPhamRepository.findByTenUuDai(tenUuDai);
    } 

    public Collection<UuDaiSanPhamModel> findByNgayBatDau(Date ngayBatDau){
        return uuDaiSanPhamRepository.findByNgayBatDau(ngayBatDau);
    }

    public Collection<UuDaiSanPhamModel> findByNgayKetThuc(Date ngayKetThuc){
        return uuDaiSanPhamRepository.findByNgayKetThuc(ngayKetThuc);
    }

    public Collection<UuDaiSanPhamModel> findByPhanTramUuDai(float phanTramUuDai){
        return uuDaiSanPhamRepository.findByPhanTramUuDai(phanTramUuDai);
    }

    public UuDaiSanPhamModel findByMaUuDaiSuDung(int maUuDai){
        try {
            return uuDaiSanPhamRepository.findByMaUuDaiSuDung(maUuDai);
        } catch (Exception e) {
            return new UuDaiSanPhamModel();
        }
    }

    public boolean insertUuDaiSanPham(UuDaiSanPhamModel udsp){
        try {
            return uuDaiSanPhamRepository.insertUuDaiSanPham(
                                    udsp.getTenUuDai(), 
                                    udsp.getPhanTramUuDai(), 
                                    udsp.getMoTa(),
                                    udsp.getNgayBatDau(), 
                                    udsp.getNgayKetThuc(),
                                    udsp.getMaNhanVien());
        } catch (Exception e) {
            return false;
        }
    }   
    
    public boolean updateUuDaiSanPham(UuDaiSanPhamModel udsp){
        try {
            return uuDaiSanPhamRepository.updateUuDaiSanPham(
                                    udsp.getMaUuDai(),
                                    udsp.getTenUuDai(), 
                                    udsp.getPhanTramUuDai(), 
                                    udsp.getMoTa(),
                                    udsp.getNgayBatDau(), 
                                    udsp.getNgayKetThuc());
        } catch (Exception e) {
            return false;
        }
    }  

}
