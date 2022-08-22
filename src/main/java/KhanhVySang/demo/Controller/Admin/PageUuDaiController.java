package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiKhachHangModel;
import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiSanPhamModel;
import KhanhVySang.demo.Service.ThongTinUudai.UuDaiKhachHangService;
import KhanhVySang.demo.Service.ThongTinUudai.UuDaiSanPhamService;

@Controller
@RequestMapping("/ad/ud")
public class PageUuDaiController {
    
    @Autowired
    private UuDaiKhachHangService uuDaiKhachHangService;
    @Autowired
    private UuDaiSanPhamService uuDaiSanPhamService;

    @GetMapping(path = "/uu-dai-khach-hang/")
    public String uuDaiKhachHangGet(ModelMap model){
        List<UuDaiKhachHangModel> form = uuDaiKhachHangService.findAll();
        model.addAttribute("udkhachhang", form);
        return "NhanVien/UDKhachHang";
    }

    @GetMapping(path = "/uu-dai-san-pham/")
    public String uuDaiSanPhamGet(ModelMap model){
        List<UuDaiSanPhamModel> form = uuDaiSanPhamService.findAll();
        model.addAttribute("udsanpham", form);
        return "NhanVien/UDSanPham";
    }
}
