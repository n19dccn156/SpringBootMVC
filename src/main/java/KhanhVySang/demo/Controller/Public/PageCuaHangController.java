package KhanhVySang.demo.Controller.Public;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KhanhVySang.demo.Model.Form.UuDai.TraCuuUuDaiModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.Form.UuDai.TraCuuUuDai;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;

@Controller
public class PageCuaHangController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TraCuuUuDai traCuuUuDai;
    @Autowired
    private PageTrangChuController pageTrangChuController;
    @Autowired
    private TaiKhoanService taiKhoanService;


    @PostMapping(value = "/vi/cuahang")
    public String formPostGia(ModelMap model,
                            @RequestParam("page") Optional<Integer> page,
                            @RequestParam("danhmuc") Optional<Integer> danhmuc,
                            @RequestParam("loaisanpham") Optional<Integer> loaisanpham,
                            @RequestParam("gia") Optional<Integer> gia,
                            @RequestParam("sapxep") Optional<Integer> sapxep){

        int danhMuc = 0;
        int loaiSanPham = 0;
        int giaTien = 0;
        int sapXep = 0;

        if(danhmuc.isPresent() == true) danhMuc = danhmuc.get();
        if(loaisanpham.isPresent() == true) loaiSanPham = loaisanpham.get();
        if(gia.isPresent() == true) giaTien = gia.get();
        if(sapxep.isPresent() == true) sapXep = sapxep.get();

        model.addAttribute("pagenumber", 1);
        model.addAttribute("danhmuc", danhMuc);
        model.addAttribute("loaisanpham", loaiSanPham);
        model.addAttribute("gia", giaTien);
        model.addAttribute("giaHienTai", giaTien);
        model.addAttribute("sapxep", sapXep);
    
        String result = "redirect:/vi/cuahang?&page=1&danhmuc="+danhMuc+"&loaisanpham="+loaiSanPham+"&gia="+giaTien+"&sapxep="+sapXep;
        return result;
    }
    
    @GetMapping(value = "/vi/cuahang")
    public String viewCuaHangBy(ModelMap model, HttpSession session,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("danhmuc") Optional<Integer> danhmuc,
                                @RequestParam("loaisanpham") Optional<Integer> loaisanpham,
                                @RequestParam("gia") Optional<Integer> gia,
                                @RequestParam("sapxep") Optional<Integer> sapxep,
                                Authentication auth, HttpServletRequest request, HttpServletResponse response) {
        int currentPage = page.orElse(1);
        int pageSize = 16;
        
        int danhMuc = 0;
        int loaiSanPham = 0;
        int giaTien = sanPhamService.findTop1ByGiaDesc().getGia();
        int sapXep = 0;

        model.addAttribute("pagenumber", 0);
        model.addAttribute("danhmuc", 0);
        model.addAttribute("loaisanpham", 0);
        model.addAttribute("gia", giaTien);
        model.addAttribute("sapxep", 0);
        
        if(danhmuc.isPresent() == true) danhMuc = danhmuc.get();
        if(loaisanpham.isPresent() == true) loaiSanPham = loaisanpham.get();
        if(gia.isPresent() == true) giaTien = gia.get();
        if(sapxep.isPresent() == true) sapXep = sapxep.get();

        try {
            String username = auth.getName().toString();
            String quyen = "ROLE_"+taiKhoanService.findByTenDangNhap(username).getQuyen();
            model.addAttribute("role", quyen);
        } catch (Exception e) {
            model.addAttribute("role", "ROLE_KHACHHANG");
        }
        model.addAttribute("giaHienTai", giaTien);
        model.addAttribute("soLuongSPGH", pageTrangChuController.handleCookie(auth, request, response).size());
        session.setAttribute("giaHienTai", giaTien);

        if(loaiSanPham != 0) {

            Page<SanPhamModel> sanPhamPage = sanPhamService.findPaginatedLoaiSanPham(PageRequest.of(currentPage - 1, pageSize), loaiSanPham, giaTien, sapXep);
            Hashtable<Integer, TraCuuUuDaiModel> uuDai = new Hashtable<Integer, TraCuuUuDaiModel>();
            for (SanPhamModel sanPham : sanPhamPage) {
                uuDai.put(sanPham.getMaSanPham(), traCuuUuDai.findByMaSanPham(sanPham.getMaSanPham()));
            }
            model.addAttribute("sanphampage", sanPhamPage);
            model.addAttribute("uuDai", uuDai);

            int totalPages = sanPhamPage.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pagenumber", pageNumbers);
                model.addAttribute("danhmuc", danhMuc);
                model.addAttribute("loaisanpham", loaiSanPham);
                model.addAttribute("gia", giaTien);
                model.addAttribute("sapxep", sapXep);
            }
            return "public/cuahang";
        }
        
        if(danhMuc != 0) {

            Page<SanPhamModel> sanPhamPage = sanPhamService.findPaginatedDanhMuc(PageRequest.of(currentPage - 1, pageSize), danhMuc, giaTien, sapXep);
            Hashtable<Integer, TraCuuUuDaiModel> uuDai = new Hashtable<Integer, TraCuuUuDaiModel>();
            for (SanPhamModel sanPham : sanPhamPage) {
                uuDai.put(sanPham.getMaSanPham(), traCuuUuDai.findByMaSanPham(sanPham.getMaSanPham()));
            }
            model.addAttribute("sanphampage", sanPhamPage);
            model.addAttribute("uuDai", uuDai);

            int totalPages = sanPhamPage.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pagenumber", pageNumbers);
                model.addAttribute("danhmuc", danhMuc);
                model.addAttribute("loaisanpham", loaiSanPham);
                model.addAttribute("gia", giaTien);
                model.addAttribute("sapxep", sapXep);
            }

            return "public/cuahang";
        }
        
        Page<SanPhamModel> sanPhamPage = sanPhamService.findPaginated(PageRequest.of(currentPage - 1, pageSize), giaTien, sapXep);
        Hashtable<Integer, TraCuuUuDaiModel> uuDai = new Hashtable<Integer, TraCuuUuDaiModel>();
        for (SanPhamModel sanPham : sanPhamPage) {
            uuDai.put(sanPham.getMaSanPham(), traCuuUuDai.findByMaSanPham(sanPham.getMaSanPham()));
        }
        model.addAttribute("sanphampage", sanPhamPage);
        model.addAttribute("uuDai", uuDai);

        int totalPages = sanPhamPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pagenumber", pageNumbers);
            model.addAttribute("danhmuc", danhMuc);
            model.addAttribute("loaisanpham", loaiSanPham);
            model.addAttribute("gia", giaTien);
            model.addAttribute("sapxep", sapXep);
        } else {
            model.addAttribute("thongBao", "Không có sản phẩm nào được tìm kiếm");
        }

        return "public/cuahang";
    }

}
