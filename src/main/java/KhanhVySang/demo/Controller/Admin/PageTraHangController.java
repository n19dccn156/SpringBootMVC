package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuTraHangModel;
import KhanhVySang.demo.Service.ThongTinMuaHang.PhieuTraHangService;

@Controller
@RequestMapping("/ad/th")
public class PageTraHangController {

    @Autowired
    private PhieuTraHangService phieuTraHangService;
    
    @GetMapping(path = "/tao-phieu-tra/")
    public String taoPhieuTra(){

        return "NhanVien/TaoPhieuTra";
    }

    @GetMapping(path = "/")
    public String danhSachPhieuTra(ModelMap model){
        List<PhieuTraHangModel> form = phieuTraHangService.findAll();
        model.addAttribute("phieutra", form);
        return "NhanVien/DSPhieuTra";
    }
}
