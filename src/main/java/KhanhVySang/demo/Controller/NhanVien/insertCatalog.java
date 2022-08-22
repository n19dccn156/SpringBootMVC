package KhanhVySang.demo.Controller.NhanVien;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import KhanhVySang.demo.Model.GoogleDriveFileDTO;
import KhanhVySang.demo.Model.Form.Catalog.FormInsertDanhMuc;
import KhanhVySang.demo.Model.Form.Catalog.FormInsertLoaiSanPham;
import KhanhVySang.demo.Model.ThongTinSanPham.DanhMucModel;
import KhanhVySang.demo.Service.GoogleDriveFileService;
import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;

@Controller
public class insertCatalog {
    
    @Autowired
    private GoogleDriveFileService googleDriveFileService;
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @PostMapping(path = "/ad/insert/danhmuc")
    public String insertDanhMuc(@ModelAttribute("formInsertDanhMuc") FormInsertDanhMuc danhMuc, ModelMap model, RedirectAttributes redirectAttributes) throws IOException, GeneralSecurityException{

        DanhMucModel foundDM = danhMucService.findByTenDanhMuc(danhMuc.getTenDanhMuc());
        if(foundDM.equals(new DanhMucModel()) != true) {
            redirectAttributes.addFlashAttribute("messageDM", "Tên Danh Mục Phẩm Đã Tồn Tại");
            System.out.println("Khong insert");
            return "redirect:/ad/catalog/";
        }
        googleDriveFileService.uploadFile(danhMuc.getHinhAnh(), "img", true);
    
        List<GoogleDriveFileDTO> listFile = googleDriveFileService.getAllFile();
        String hinhAnh = "";
        for (GoogleDriveFileDTO file : listFile) {
            if(file.getName().equals(danhMuc.getHinhAnh().getOriginalFilename())){
                hinhAnh = file.getThumbnailLink();
            }

        }
        System.out.println("Co insert");
        danhMucService.insertDanhMuc(danhMuc.getTenDanhMuc(), hinhAnh, true);       
        return "redirect:/ad/catalog/";
    }

    @PostMapping(path = "/ad/insert/loaisanpham")
    public String insertLoaiSanPham(@ModelAttribute("formInsertLoaiSanPham") FormInsertLoaiSanPham loaiSanPham, RedirectAttributes redirectAttributes){

        if(loaiSanPhamService.insertLoaiSanPham(loaiSanPham.getTenLoaiSanPham(), loaiSanPham.getTrangThai(), loaiSanPham.getMaDanhMuc()) == 0) {
            System.out.println("Khong Insert");
            redirectAttributes.addFlashAttribute("messageLSP", "Tên Loại Sản Phẩm Đã Tồn Tại");
            return "redirect:/ad/catalog/";
        }
        System.out.println("Co Insert");
        // int row = loaiSanPhamService.insertLoaiSanPham(loaiSanPham.getTenLoaiSanPham(), loaiSanPham.getTrangThai(), loaiSanPham.getMaDanhMuc());

        return "redirect:/ad/catalog/";
    }
}
