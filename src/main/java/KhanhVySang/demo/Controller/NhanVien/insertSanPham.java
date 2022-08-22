package KhanhVySang.demo.Controller.NhanVien;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import KhanhVySang.demo.Model.GoogleDriveFileDTO;
import KhanhVySang.demo.Model.Form.SanPham.FormInsertSanPham;
import KhanhVySang.demo.Model.Form.SanPham.FormSanPham;
import KhanhVySang.demo.Model.ThongTinSanPham.LoaiSanPhamModel;
import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
import KhanhVySang.demo.Repositories.Form.SanPham.ViewThongTinSanPham;
import KhanhVySang.demo.Service.GoogleDriveFileService;
import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;
import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;

@Controller
public class insertSanPham {
    
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;
    @Autowired
    private GoogleDriveFileService googleDriveFileService;
    @Autowired
    private ViewThongTinSanPham viewThongTinSanPham;
    @Autowired
    private DanhMucService danhMucService;

    @PostMapping(path = "/ad/insert/sanpham")
    public String insertSanPham(@ModelAttribute("formInsertSanPham") FormInsertSanPham sanPham, RedirectAttributes redirectAttributes) throws IOException, GeneralSecurityException{
        SanPhamModel foundSP = sanPhamService.findByTenSanPham(sanPham.getTenSanPham());
        LoaiSanPhamModel foundLSP = loaiSanPhamService.findByMaLoaiSanPham(sanPham.getLoaiSanPham());


        System.out.println(sanPham.getTenSanPham());
        System.out.println(sanPham.getLoaiSanPham());

        System.out.println(foundSP.getTenSanPham());
        System.out.println(foundLSP.getMaDanhMuc());

        if(foundSP.getMaSanPham() != 0 || foundLSP.getMaLoaiSanPham() != sanPham.getLoaiSanPham()) {

            redirectAttributes.addFlashAttribute("messageSP", "Tên Sản Phẩm Đã Tồn Tại");
            System.out.println("Khong insert");
            List<FormSanPham> form = viewThongTinSanPham.findByMaDanhMucAndMaLoaiSanPham(7, 3);
            redirectAttributes.addFlashAttribute("danhMuc", danhMucService.findAll());
            redirectAttributes.addFlashAttribute("loaiSanPham", loaiSanPhamService.findByMaDanhMuc(7));
            redirectAttributes.addFlashAttribute("loaiSanPhamAll", loaiSanPhamService.findAll());
            redirectAttributes.addFlashAttribute("maDanhMuc", 7);
            redirectAttributes.addFlashAttribute("maLoaiSanPham", 3);
            redirectAttributes.addFlashAttribute("sanpham", form);
            return "redirect:/ad/sp/?&sapxepdm=7&sapxeplsp=3";
        } else {
            googleDriveFileService.uploadFile(sanPham.getHinhAnh(), "img", true);
    
            List<GoogleDriveFileDTO> listFile = googleDriveFileService.getAllFile();
            String hinhAnh = "";
            for (GoogleDriveFileDTO file : listFile) {
                if(file.getName().equals(sanPham.getHinhAnh().getOriginalFilename())){
                    hinhAnh = file.getThumbnailLink();
                }
            }
            System.out.println("Co insert");
            sanPhamService.insertSanPham(sanPham.getTenSanPham(), sanPham.getGia(), sanPham.getMoTa() , hinhAnh, sanPham.getLoaiSanPham());       
            List<FormSanPham> form = viewThongTinSanPham.findByMaDanhMucAndMaLoaiSanPham(7, 3);
            redirectAttributes.addFlashAttribute("danhMuc", danhMucService.findAll());
            redirectAttributes.addFlashAttribute("loaiSanPham", loaiSanPhamService.findByMaDanhMuc(7));
            redirectAttributes.addFlashAttribute("loaiSanPhamAll", loaiSanPhamService.findAll());
            redirectAttributes.addFlashAttribute("maDanhMuc", 7);
            redirectAttributes.addFlashAttribute("maLoaiSanPham", 3);
            redirectAttributes.addFlashAttribute("sanpham", form);
            return "redirect:/ad/sp/?&sapxepdm=7&sapxeplsp=3";
        }
    }
}
