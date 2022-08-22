package KhanhVySang.demo.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;

@Controller
@RequestMapping("/ad/catalog")
public class PageCatalog {
    
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    // @GetMapping(path = "/")
    // public String Catalog(ModelMap model){

    //     model.addAttribute("danhmuc", danhMucService.findAll());
    //     model.addAttribute("loaisanpham", loaiSanPhamService.findAllByForm());
    //     return "NhanVien/DanhMuc";
    // }
    // @RequestParam("page") Optional<Integer> page,

    @GetMapping(path = "/")
    public String CatalogNew(ModelMap model, @RequestParam("sapxep") Integer maDanhMuc){

        model.addAttribute("danhmuc", danhMucService.findAll());
        // model.addAttribute("loaisanpham", loaiSanPhamService.findByMaDanhMuc(maDanhMuc));
        model.addAttribute("loaisanpham", loaiSanPhamService.findAllByFormAndMaDanhMuc(maDanhMuc));
        model.addAttribute("sapxep", maDanhMuc);
        return "NhanVien/DanhMuc";
    }

}
