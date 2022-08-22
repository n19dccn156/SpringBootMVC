package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Service.ThongTinCaNhan.NhanVienService;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;

@Controller
@RequestMapping(path = "/ad/nv")
public class PageNhanVienController {
    
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/thong-tin-nhan-vien/")
    public String thongTinNhanVienGet(ModelMap model){

        model.addAttribute("nhanvien", nhanVienService.findAllByForm());
        return "NhanVien/NhanVien";
    }

    @GetMapping("/thong-tin-nhan-vien/lamviec/")
    public String thongTinNhanVienLamViecGet(ModelMap model, @ModelAttribute("trangThaiPost") boolean trangThai){

        model.addAttribute("nhanvien", nhanVienService.findFormByTrangThai(trangThai));
        return "NhanVien/NhanVien";
    }

    @GetMapping("/thong-tin-tai-khoan/")
    public String thongTinTaiKhoanNhanVienGet(ModelMap model){

        List<TaiKhoanModel> taiKhoan = taiKhoanService.findByQuyen("NHANVIEN");
        for (TaiKhoanModel tk : taiKhoanService.findByQuyen("ADMIN")){
            taiKhoan.add(tk);
        }
        model.addAttribute("taikhoan", taiKhoan);
        return "NhanVien/DSTaiKhoan";
    }

    // @PostMapping("/ttnv")
    // public String taoNhanVienPost(ModelMap model, @ModelAttribute("themNhanVien") FormThemNhanVien formThemNhanVien){

        
    //     return "nhanvien";
    // } 
    

    // this.ho = ho;
    // this.ten = ten;
    // this.gioiTinh = gioiTinh;
    // this.dienThoai = dienThoai;
    // this.cccd = cccd;
    // this.ngaySinh = ngaySinh;
    // this.tenDangNhap = tenDangNhap;
    // this.email = email;
    // this.chucVu = chucVu;
    

}
