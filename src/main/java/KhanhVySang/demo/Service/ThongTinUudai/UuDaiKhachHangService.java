package KhanhVySang.demo.Service.ThongTinUudai;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiKhachHangModel;
import KhanhVySang.demo.Repositories.ThongTinUuDai.UuDaiKhachHangRepository;

@Service
public class UuDaiKhachHangService {
    
    @Autowired
    private UuDaiKhachHangRepository uuDaiKhachHangRepository;

    public List<UuDaiKhachHangModel> findAll(){
        return uuDaiKhachHangRepository.findAll();
    }

    public Optional<UuDaiKhachHangModel> findByMaUuDai(int maUuDai){
        return uuDaiKhachHangRepository.findByMaUuDai(maUuDai);
    }

    public List<UuDaiKhachHangModel> findByPhanTramUuDai(float phanTramUuDai){
        return uuDaiKhachHangRepository.findByPhanTramUuDai(phanTramUuDai);
    }

    public List<UuDaiKhachHangModel> findByNgayBatDau(Date ngayBatDau){
        return uuDaiKhachHangRepository.findByNgayBatDau(ngayBatDau);
    }

    public List<UuDaiKhachHangModel> findByNgayKetThuc(Date ngayKetThuc){
        return uuDaiKhachHangRepository.findByNgayKetThuc(ngayKetThuc);
    }

    public boolean insertUuDaiKhachHang(UuDaiKhachHangModel udkh){
        try {
            return uuDaiKhachHangRepository.insertUuDaiKhachHang(
                                        udkh.getTenUuDai(), 
                                        udkh.getPhanTramUuDai(), 
                                        udkh.getMoTa(),
                                        udkh.getDieuKien(),
                                        udkh.getDonGiaToiThieu(),
                                        udkh.getUuDaiToiDa(),
                                        udkh.getNgayBatDau(), 
                                        udkh.getNgayKetThuc(),
                                        udkh.getMaNhanVien());
        } catch (Exception e) {
            return false;
        }
    }   
    
    public boolean updateUuDaiKhachHang(UuDaiKhachHangModel udkh){
        try {
            return uuDaiKhachHangRepository.updateUuDaiKhachHang(
                                        udkh.getMaUuDai(),
                                        udkh.getTenUuDai(), 
                                        udkh.getPhanTramUuDai(), 
                                        udkh.getMoTa(),
                                        udkh.getDieuKien(),
                                        udkh.getDonGiaToiThieu(),
                                        udkh.getUuDaiToiDa(),
                                        udkh.getNgayBatDau(), 
                                        udkh.getNgayKetThuc());
        } catch (Exception e) {
            return false;
        }
    }  
}
