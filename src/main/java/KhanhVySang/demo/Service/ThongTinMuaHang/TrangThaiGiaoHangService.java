package KhanhVySang.demo.Service.ThongTinMuaHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinMuaHang.TrangThaiGiaoHangModel;
import KhanhVySang.demo.Repositories.ThongTinMuaHang.TrangThaiGiaoHangRepository;

@Service
public class TrangThaiGiaoHangService {

    @Autowired
    private TrangThaiGiaoHangRepository trangThaiGiaoHangRepository;
    
    public List<TrangThaiGiaoHangModel> findAll(){
        return trangThaiGiaoHangRepository.findAll();
    }
}
