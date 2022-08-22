package KhanhVySang.demo.Controller.Public;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import KhanhVySang.demo.Model.Form.UuDai.TraCuuUuDaiModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.GioHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.Form.UuDai.TraCuuUuDai;
import KhanhVySang.demo.Service.ThongTinCaNhan.KhachHangService;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PageGioHangController {

    @Autowired
    private PageTrangChuController pageTrangChuController;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TraCuuUuDai traCuuUuDai;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping(path = "/vi/giohang")
    public String viewGioHang(HttpServletRequest request, HttpServletResponse response, Authentication auth, ModelMap model, HttpSession session){
        
        List<TraCuuUuDaiModel> traCuu = new ArrayList<>();
        List<SanPhamModel> listSanPham = new ArrayList<>();
        List<GioHangModel> gioHang = pageTrangChuController.handleCookie(auth, request, response);
        
        for (GioHangModel gioHangModel : gioHang) {
            listSanPham.add(sanPhamService.findByMaSanPham(gioHangModel.getMaSanPham()));
            traCuu.add(traCuuUuDai.findByMaSanPham(gioHangModel.getMaSanPham()));
        }
        
        try {
            String username = auth.getName().toString();
            String quyen = "ROLE_"+taiKhoanService.findByTenDangNhap(username).getQuyen();
            model.addAttribute("role", quyen);
            TaiKhoanModel taikhoan = taiKhoanService.findByTenDangNhap(username);
            KhachHangModel khachhang = khachHangService.findByMaTaiKhoan(taikhoan.getMaTaiKhoan());
            session.setAttribute("mkh", khachhang.getMaKhachHang());
        } catch (Exception e) {
            model.addAttribute("role", "ROLE_KHACHHANG");
        } finally {
            // session.setAttribute("role", value);
            int giaTien = sanPhamService.findTop1ByGiaDesc().getGia();
            session.setAttribute("giaHienTai", giaTien);
            model.addAttribute("listSP", listSanPham);
            model.addAttribute("traCuu", traCuu);
            model.addAttribute("listSPGH", gioHang);     
            model.addAttribute("soLuongSPGH", gioHang.size()); 
        }
        return "public/giohang";
    }
}
