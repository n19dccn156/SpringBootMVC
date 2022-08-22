package KhanhVySang.demo.Controller.Public;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import KhanhVySang.demo.Model.ThongTinCaNhan.GioHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;
import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.ViewSanPham.Top20SanPhamBanNhieuRepo;
import KhanhVySang.demo.Repositories.ViewSanPham.Top20SanPhamMoiNhatRepo;
import KhanhVySang.demo.Service.ThongTinCaNhan.GioHangService;
import KhanhVySang.demo.Service.ThongTinCaNhan.KhachHangService;
import KhanhVySang.demo.Service.ThongTinCaNhan.NhanVienService;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;

@Controller
public class PageTrangChuController {

    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private Top20SanPhamBanNhieuRepo top20SanPhamBanNhieu;
    @Autowired
    private Top20SanPhamMoiNhatRepo top20SanPhamMoiNhat;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping(path = "/vi/trangchu")
    public String viewTrangChu(ModelMap model, HttpSession session, 
                                Authentication auth, 
                                HttpServletRequest request, 
                                HttpServletResponse response){

        int giaTien = sanPhamService.findTop1ByGiaDesc().getGia();
        session.setAttribute("giaHienTai", giaTien);
        model.addAttribute("soLuongSPGH", handleCookie(auth, request, response).size());
        
        session.setAttribute("danhmucOns", danhMucService.findByTrangThai(true));
        session.setAttribute("loaisanphamOns", loaiSanPhamService.findByTrangThai(true));
        model.addAttribute("sanphambn", top20SanPhamBanNhieu.findAll());
        model.addAttribute("sanphammn", top20SanPhamMoiNhat.findAll());
        session.setAttribute("spGiaMin", sanPhamService.findTop1ByGiaAsc());
        session.setAttribute("spGiaMax", sanPhamService.findTop1ByGiaDesc());
        try {
            String username = auth.getName().toString();
            String quyen = "ROLE_"+taiKhoanService.findByTenDangNhap(username).getQuyen();
            model.addAttribute("role", quyen);

            int maTaiKhoan = taiKhoanService.findByTenDangNhap(username).getMaTaiKhoan();
            int maNhanVien = nhanVienService.findByMaTaiKhoan(maTaiKhoan).getMaNhanVien();
            System.out.println();
            Cookie cookie = new Cookie("maCaNhan", String.valueOf(maNhanVien));
            cookie.setMaxAge(60*60*8);
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            System.out.println(cookie.getName());
        } catch (Exception e) {
            model.addAttribute("role", "ROLE_KHACHHANG");
        }
        return "public/index";
    }

    public List<GioHangModel> handleCookie(Authentication auth, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookie = request.getCookies();
        List<GioHangModel> gioHang = new ArrayList<>();
        String value = "";
        try {
            TaiKhoanModel taikhoan = taiKhoanService.findByTenDangNhap(auth.getName());
            KhachHangModel khachhang = khachHangService.findByMaTaiKhoan(taikhoan.getMaTaiKhoan());
            for (Cookie ck : cookie) {
                // readcookie va find trong csdl neu ton tai thi cong don neu khong thif se them moi
                if(ck.getName().equals("gioHangCookie")){
                    value = ck.getValue().toString();
                    if(ck.getValue().indexOf("&") != -1){
                        String[] listSanPham = ck.getValue().split("&");
                        for (String gioHangModel : listSanPham) {
                            String[] detailSanPham = gioHangModel.split(":");                            
                            gioHang.add(new GioHangModel(Integer.valueOf(detailSanPham[0]), khachhang.getMaKhachHang(), Integer.valueOf(detailSanPham[1])));                     
                        }
                    } else {
                        String[] detailSanPham = ck.getValue().split(":");
                        gioHang.add(new GioHangModel(Integer.valueOf(detailSanPham[0]), khachhang.getMaKhachHang(), Integer.valueOf(detailSanPham[1])));                     
                    }
                }
            }

            if(gioHang.isEmpty() == true && gioHangService.findByMaKhachHang(khachhang.getMaKhachHang()).isEmpty() == false){
                for (GioHangModel gh : gioHangService.findByMaKhachHang(khachhang.getMaKhachHang())) {
                    if(value.equals("") == false) value += "&";
                    if(gh.getSoLuong() < sanPhamService.findByMaSanPham(gh.getMaSanPham()).getSoLuong()){
                        value += gh.getMaSanPham() + ":" + gh.getSoLuong();
                        gioHang.add(gh);
                    }
                    else {
                        value += gh.getMaSanPham() + ":" + sanPhamService.findByMaSanPham(gh.getMaSanPham()).getSoLuong();
                        gioHang.add(new GioHangModel(gh.getMaSanPham(), gh.getMaKhachHang(), sanPhamService.findByMaSanPham(gh.getMaSanPham()).getSoLuong()));
                    }
                }

            } 
            else if(gioHang.isEmpty() == false && gioHangService.findByMaKhachHang(khachhang.getMaKhachHang()).isEmpty() == false) {
                List<GioHangModel> listGH = gioHangService.findByMaKhachHang(khachhang.getMaKhachHang());
                for (int i = 0; i < listGH.size(); i++) {
                    for (int j = 0; j < gioHang.size(); j++) {
                        if(listGH.get(i).getMaSanPham() == gioHang.get(j).getMaSanPham()) break;
                        if(j == gioHang.size()-1){
                            if(value.equals("") == false) value += "&";
                            if(listGH.get(j).getSoLuong() > sanPhamService.findByMaSanPham(listGH.get(j).getMaSanPham()).getSoLuong()) {
                                gioHang.add(new GioHangModel(listGH.get(j).getMaSanPham(), listGH.get(j).getMaKhachHang(), sanPhamService.findByMaSanPham(listGH.get(j).getMaSanPham()).getSoLuong()));
                                value += listGH.get(j).getMaSanPham() + ":" + sanPhamService.findByMaSanPham(listGH.get(j).getMaSanPham()).getSoLuong();
                            }
                            else {
                                value += listGH.get(j).getMaSanPham() + ":" + listGH.get(j).getSoLuong();
                                gioHang.add(listGH.get(j));
                            }
                            break;
                        }
                    }
                    
                }
            }
        } catch (Exception e) {
            for (Cookie ck : cookie) {
                if(ck.getName().equals("gioHangCookie")){
                    value = "";
                    if(ck.getValue().indexOf("&") == -1) {
                        String[] temp = ck.getName().split(":");
                        SanPhamModel sanPham = sanPhamService.findByMaSanPham(Integer.valueOf(temp[0]));
                        if(sanPham.getSoLuong() < Integer.valueOf(temp[1])){
                            gioHang.add(new GioHangModel(Integer.valueOf(temp[0]), 0, Integer.valueOf(sanPham.getSoLuong())));
                            value += Integer.valueOf(temp[0]) + ":" + sanPham.getSoLuong();
                        }
                        else {
                            gioHang.add(new GioHangModel(Integer.valueOf(temp[0]), 0, Integer.valueOf(temp[1])));
                            value += Integer.valueOf(temp[0]) + ":" + Integer.valueOf(temp[1]);
                        }
                    }
                    else {
                        for (String gh : ck.getValue().split("&")) {
                            String[] temp = gh.split(":");
                            SanPhamModel sanPham = sanPhamService.findByMaSanPham(Integer.valueOf(temp[0]));
                            if(value.equals("") == false) value += "&";
                            if(sanPham.getSoLuong() < Integer.valueOf(temp[1])) {
                                gioHang.add(new GioHangModel(Integer.valueOf(temp[0]), 0, Integer.valueOf(sanPham.getSoLuong())));
                                value += Integer.valueOf(temp[0]) + ":" + sanPham.getSoLuong();
                            }
                            else {
                                gioHang.add(new GioHangModel(Integer.valueOf(temp[0]), 0, Integer.valueOf(temp[1])));
                                value += Integer.valueOf(temp[0]) + ":" + Integer.valueOf(temp[1]);
                            }
                        }
                    }
                }
            } 
            System.out.println("------- exception -------");       
        } finally {
            if(value.equals("") == false) {
                Cookie cookie2 = new Cookie("gioHangCookie", value);
                cookie2.setMaxAge(86000);
                cookie2.setPath("/");
                cookie2.setDomain("localhost");
                response.addCookie(cookie2);
            }
            
            return gioHang;
        }
    }
}