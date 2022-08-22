package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuNhapHangModel;
import KhanhVySang.demo.Service.ThongTinMuaHang.PhieuNhapHangService;

@Controller
@RequestMapping("/ad/nh")
public class PageNhapHangController {

    @Autowired
    private PhieuNhapHangService phieuNhapHangService;
    
    @GetMapping(path = "/tao-phieu-nhap/")
    public String taoPhieuNhap(){

        return "NhanVien/TaoPhieuNhap";
    }

    @GetMapping(path = "/")
    public String danhSachPhieuNhap(ModelMap model){
        List<PhieuNhapHangModel> form = phieuNhapHangService.findAll();
        model.addAttribute("phieunhap", form);
        return "NhanVien/DSPhieuNhap";
    }
}
