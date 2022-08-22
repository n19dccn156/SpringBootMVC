package KhanhVySang.demo.Service.ThongTinUudai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinUuDai.ChiTietUuDaiModel;
import KhanhVySang.demo.Repositories.ThongTinUuDai.ChiTietUuDaiRepository;

@Service
public class ChiTietUuDaiService {
    @Autowired
    public ChiTietUuDaiRepository chiTietUuDaiRepository;
    
    public List<ChiTietUuDaiModel> findAll(){
        return chiTietUuDaiRepository.findAll();
    }

    public List<ChiTietUuDaiModel> findByMaKhachHang(int maKhachHang){
        return chiTietUuDaiRepository.findByMaKhachHang(maKhachHang);
    }

    public boolean deleteCTUDKhachHang(ChiTietUuDaiModel ctud){
        try {
            return chiTietUuDaiRepository.deleteCTUDKhachHang(ctud.getKhachHang(), 
                                                              ctud.getMaUuDai());
        } catch (Exception e) {
            return false;
        }
    } 

    public boolean insertCTUDKhachHang(ChiTietUuDaiModel ctud){
        try {
            return chiTietUuDaiRepository.insertCTUDKhachHang(ctud.getKhachHang(), 
                                                              ctud.getMaUuDai(), 
                                                              ctud.getSoLuong());
        } catch (Exception e) {
            return false;
        }
    }   
    
    public boolean updateCTUDKhachHang(ChiTietUuDaiModel ctud){
        try {
            return chiTietUuDaiRepository.updateCTUDKhachHang(ctud.getKhachHang(), 
                                                              ctud.getMaUuDai(), 
                                                              ctud.getSoLuong());
        } catch (Exception e) {
            return false;
        }
    }  
}
