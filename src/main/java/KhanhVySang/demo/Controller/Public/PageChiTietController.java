package KhanhVySang.demo.Controller.Public;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import KhanhVySang.demo.Model.Form.UuDai.TraCuuUuDaiModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiSanPhamModel;
import KhanhVySang.demo.Repositories.Form.UuDai.TraCuuUuDai;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;
import KhanhVySang.demo.Service.ThongTinUudai.UuDaiSanPhamService;

@Controller
public class PageChiTietController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private UuDaiSanPhamService uuDaiSanPhamService;
    @Autowired
    private PageTrangChuController pageTrangChuController;
    @Autowired
    private TraCuuUuDai traCuuUuDai;
    @Autowired
    private TaiKhoanService taiKhoanService;
    

    @GetMapping(path = "/vi/chitiet/{maSanPham}")
    public String viewChiTietSP(ModelMap model, @PathVariable int maSanPham, Authentication auth,
                                HttpServletRequest request, HttpServletResponse response, HttpSession session){

        SanPhamModel sanpham = sanPhamService.findByMaSanPham(maSanPham);
        List<SanPhamModel> spLienQuan = sanPhamService.findByMaLoaiSanPhamLimit10Asc(sanpham.getMaLoaiSanPham());
        List<SanPhamModel> spLienQuan2 = sanPhamService.findByMaLoaiSanPhamLimit10Desc(sanpham.getMaLoaiSanPham());
        
        Hashtable<Integer, TraCuuUuDaiModel> uuDai1 = new Hashtable<Integer, TraCuuUuDaiModel>();
        for (SanPhamModel sanPham : spLienQuan) {
            uuDai1.put(sanPham.getMaSanPham(), traCuuUuDai.findByMaSanPham(sanPham.getMaSanPham()));
        }
        Hashtable<Integer, TraCuuUuDaiModel> uuDai2 = new Hashtable<Integer, TraCuuUuDaiModel>();
        for (SanPhamModel sanPham : spLienQuan2) {
            uuDai2.put(sanPham.getMaSanPham(), traCuuUuDai.findByMaSanPham(sanPham.getMaSanPham()));
        }
        

        if(sanpham.getMaUuDai() == null){
            int giaTien = sanPhamService.findTop1ByGiaDesc().getGia();
            session.setAttribute("giaHienTai", giaTien);
            model.addAttribute("sanpham", sanpham);
            model.addAttribute("giaUuDai", sanpham.getGia());
            model.addAttribute("spLienQuan1", spLienQuan);
            model.addAttribute("spLienQuan2", spLienQuan2);
            model.addAttribute("uuDai1", uuDai1);
            model.addAttribute("uuDai2", uuDai2);

            return "public/chitiet";
        }

        

        UuDaiSanPhamModel uuDai = uuDaiSanPhamService.findByMaUuDaiSuDung(sanpham.getMaUuDai());
        float giaUuDai = sanpham.getGia() - uuDai.getPhanTramUuDai()*sanpham.getGia()/100;
        
        try {
            String username = auth.getName().toString();
            String quyen = "ROLE_"+taiKhoanService.findByTenDangNhap(username).getQuyen();
            model.addAttribute("role", quyen);
        } catch (Exception e) {
            model.addAttribute("role", "ROLE_KHACHHANG");
        }
        int giaTien = sanPhamService.findTop1ByGiaDesc().getGia();
        session.setAttribute("giaHienTai", giaTien);
        model.addAttribute("spLienQuan1", spLienQuan);
        model.addAttribute("spLienQuan2", spLienQuan2);
        model.addAttribute("soLuongSPGH", pageTrangChuController.handleCookie(auth, request, response).size());
        model.addAttribute("sanpham", sanpham);
        model.addAttribute("giaUuDai", giaUuDai);
        model.addAttribute("uuDai1", uuDai1);
        model.addAttribute("uuDai2", uuDai2);

        return "public/chitiet";
    }
}
