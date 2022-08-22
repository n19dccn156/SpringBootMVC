package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KhanhVySang.demo.Model.Form.HoaDon.FormThongTinHoaDon;
import KhanhVySang.demo.Model.ThongTinMuaHang.PhieuBanHangModel;
import KhanhVySang.demo.Model.ThongTinMuaHang.TrangThaiGiaoHangModel;
import KhanhVySang.demo.Repositories.Form.HoaDon.ViewThongTinHoaDon;
import KhanhVySang.demo.Service.ThongTinMuaHang.PhieuBanHangService;
import KhanhVySang.demo.Service.ThongTinMuaHang.TrangThaiGiaoHangService;

@Controller
@RequestMapping("/ad/hd")
public class PageHoaDonController {
    
    @Autowired
    private ViewThongTinHoaDon viewThongTinHoaDon;
    @Autowired
    private TrangThaiGiaoHangService trangThaiGiaoHangService;
    @Autowired
    private PhieuBanHangService phieuBanHangService;

    @GetMapping(path = "/hoa-don-off/")
    public String taoHoaDonOff(){

        return "NhanVien/HDOffline";
    }

    // @GetMapping(path = "/hoa-don-onl/")
    // public String taoHoaDonOnl(ModelMap model){
    //     List<FormHoaDonOnl> form = viewHoaDonOnl.findByTenTrangThai("Đang Duyệt Đơn");
    //     model.addAttribute("hoadononl", form);
    //     return "NhanVien/HDOnline";
    // }

    // @GetMapping(path = "/hoa-don-onl/")
    // public String taoHoaDonOnl(ModelMap model, @RequestParam("sapxep") Integer sapxep){

    //     List<TrangThaiGiaoHangModel> trangThai = trangThaiGiaoHangService.findAll();
    //     List<FormHoaDonOnl> form = viewHoaDonOnl.findByMaTrangThai(sapxep);
    //     model.addAttribute("maTrangThai", sapxep);
    //     model.addAttribute("sanpham", form);
    //     model.addAttribute("trangThaiGiaoHang", trangThai);

    //     return "NhanVien/HDOnline";
    // }

    @GetMapping(path = "/hoa-don-onl/")
    public String taoHoaDonOnl(ModelMap model, @RequestParam("sapxep") Integer sapxep){

        List<TrangThaiGiaoHangModel> trangThai = trangThaiGiaoHangService.findAll();
        // List<FormHoaDonOnl> form = viewHoaDonOnl.findByMaTrangThai(sapxep);
        List<PhieuBanHangModel> form = phieuBanHangService.findByMaTrangThai(sapxep);
        model.addAttribute("maTrangThai", sapxep);
        model.addAttribute("sanpham", form);
        model.addAttribute("trangThaiGiaoHang", trangThai);

        if(sapxep == 9) model.addAttribute("tttt", "1");
        else if(sapxep == 4) model.addAttribute("tttt", "");
        else if(sapxep == 3) model.addAttribute("tttt", "");
        else if(sapxep == 2) model.addAttribute("tttt", "3");
        else if(sapxep == 1) model.addAttribute("tttt", "2");


        return "NhanVien/HDOnline";
    }

    @GetMapping(path = "/")
    public String danhSachHoaDon(ModelMap model){

        List<FormThongTinHoaDon> form = viewThongTinHoaDon.findAll();
        model.addAttribute("phieubanhang", form);

        return "NhanVien/DSHoaDon";
    }
}
