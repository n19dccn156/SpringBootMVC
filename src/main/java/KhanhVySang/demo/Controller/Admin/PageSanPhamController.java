package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KhanhVySang.demo.Model.Form.SanPham.FormSanPham;
import KhanhVySang.demo.Repositories.Form.SanPham.ViewThongTinSanPham;
import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;

@Controller
@RequestMapping("/ad/sp")
public class PageSanPhamController {
    
    @Autowired
    private ViewThongTinSanPham viewThongTinSanPham;
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    // @GetMapping(path = "/")
    // public String thongTinSanPhamGet(ModelMap model){

    //     List<FormSanPham> form = viewThongTinSanPham.findAll();
    //     model.addAttribute("sanpham", form);
    //     return "NhanVien/SanPham";
    // }

    @GetMapping(path = "/")
    public String thongTinSanPhamGet(ModelMap model, @RequestParam("sapxepdm") Integer maDanhMuc, @RequestParam("sapxeplsp") Integer maLoaiSanPham){

        List<FormSanPham> form = viewThongTinSanPham.findByMaDanhMucAndMaLoaiSanPham(maDanhMuc, maLoaiSanPham);
        model.addAttribute("danhMuc", danhMucService.findAll());
        model.addAttribute("loaiSanPham", loaiSanPhamService.findByMaDanhMuc(maDanhMuc));
        model.addAttribute("loaiSanPhamAll", loaiSanPhamService.findAll());
        model.addAttribute("maDanhMuc", maDanhMuc);
        model.addAttribute("maLoaiSanPham", maLoaiSanPham);
        model.addAttribute("sanpham", form);
        return "NhanVien/SanPham";
    }
}
