package KhanhVySang.demo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import KhanhVySang.demo.Model.Form.KhachHang.FormThongTinKhachHang;
import KhanhVySang.demo.Repositories.Form.KhachHang.ViewThongTinKhachHang;


@Controller
@RequestMapping("/ad/kh")
public class PageKhachHangController {
    
    @Autowired
    private ViewThongTinKhachHang viewThongTinKhachHang;

    @GetMapping(path = "/")
    public String listKhachHang(ModelMap model){

        List<FormThongTinKhachHang> formKH = viewThongTinKhachHang.findAll();

        // Pageable page = PageRequest.of(2, 2);
        // Page<FormThongTinKhachHang> formKH = viewThongTinKhachHang.findAll(page);

        model.addAttribute("khachHang", formKH);
        
        return "NhanVien/KhachHang";
    }
}
