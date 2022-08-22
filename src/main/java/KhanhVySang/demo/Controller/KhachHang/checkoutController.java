package KhanhVySang.demo.Controller.KhachHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import KhanhVySang.demo.Controller.Public.PageTrangChuController;
import KhanhVySang.demo.Model.Form.FormCheckout;
import KhanhVySang.demo.Model.Form.UuDai.TraCuuUuDaiModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.GioHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.Form.UuDai.TraCuuUuDai;
import KhanhVySang.demo.Service.ThongTinCaNhan.KhachHangService;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
import KhanhVySang.demo.Service.ThongTinMuaHang.ChiTietPhieuBanHangService;
import KhanhVySang.demo.Service.ThongTinMuaHang.PhieuBanHangService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkoutController {
    

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
    @Autowired
    private PhieuBanHangService phieuBanHangService;
    @Autowired
    private ChiTietPhieuBanHangService chiTietPhieuBanHangService;

    @GetMapping(path = "/kh/checkout")
    public String viewDathangGet(HttpServletRequest request, HttpServletResponse response, Authentication auth, ModelMap model, HttpSession session){

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
        return "khachhang/checkout";
    }

    @PostMapping(path = "/kh/checkout")
    public String viewDathangPost(@ModelAttribute(name = "formDangKy") FormCheckout formCheckout, 
                                    ModelMap model, Authentication auth, HttpServletRequest request, 
                                    HttpServletResponse response, HttpSession session){

        String ho = formCheckout.getHo();
        String ten = formCheckout.getTen();
        String sdt = formCheckout.getSdt();
        String diaChi = formCheckout.getDiaChi();

        List<GioHangModel> gioHang = pageTrangChuController.handleCookie(auth, request, response);

        TaiKhoanModel taikhoan = taiKhoanService.findByTenDangNhap(auth.getName().toString());
        KhachHangModel khachhang = khachHangService.findByMaTaiKhoan(taikhoan.getMaTaiKhoan());

        phieuBanHangService.insertPhieuBanHangOnl(diaChi, sdt, khachhang.getMaKhachHang(), ho, ten);
        int maPhieuBanHang = phieuBanHangService.findMaPhieuBanHangNew();
        for (GioHangModel gh : gioHang) {
            int gia = traCuuUuDai.findByMaSanPham(gh.getMaSanPham()).getGiaUuDai();
            chiTietPhieuBanHangService.insertCTPhieuBanHang(maPhieuBanHang, gh.getMaSanPham(), gh.getSoLuong(), gia);
        }
        return "redirect:/vi/trangchu";   
    }
}
