// package KhanhVySang.demo.Controller.Public;

// import java.time.Clock;
// import java.util.List;

// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.ui.Model;
// import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.servlet.ModelAndView;

// import KhanhVySang.demo.Model.Form.FormEmail;
// import KhanhVySang.demo.Model.ThongTinCaNhan.GioHangModel;
// import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;
// import KhanhVySang.demo.Model.ThongTinCaNhan.NhanVienModel;
// import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
// import KhanhVySang.demo.Model.ThongTinSanPham.DanhMucModel;
// import KhanhVySang.demo.Model.ThongTinSanPham.LoaiSanPhamModel;
// import KhanhVySang.demo.Model.ThongTinSanPham.SanPhamModel;
// import KhanhVySang.demo.Model.ThongTinUuDai.ChiTietUuDaiModel;
// import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiKhachHangModel;
// import KhanhVySang.demo.Model.ThongTinUuDai.UuDaiSanPhamModel;
// import KhanhVySang.demo.Service.MailService;
// import KhanhVySang.demo.Service.ThongTinCaNhan.GioHangService;
// import KhanhVySang.demo.Service.ThongTinCaNhan.KhachHangService;
// import KhanhVySang.demo.Service.ThongTinCaNhan.NhanVienService;
// import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;
// import KhanhVySang.demo.Service.ThongTinSanPham.DanhMucService;
// import KhanhVySang.demo.Service.ThongTinSanPham.LoaiSanPhamService;
// import KhanhVySang.demo.Service.ThongTinSanPham.SanPhamService;
// import KhanhVySang.demo.Service.ThongTinUudai.ChiTietUuDaiService;
// import KhanhVySang.demo.Service.ThongTinUudai.UuDaiKhachHangService;
// import KhanhVySang.demo.Service.ThongTinUudai.UuDaiSanPhamService;

// @Controller
// @RequestMapping(path = "/view")
// public class TrangChuController {
    
//     @Autowired
//     private TaiKhoanService taiKhoanService;
//     @Autowired
//     private KhachHangService khachHangService;
//     @Autowired
//     private GioHangService gioHangService;
//     @Autowired
//     private DanhMucService danhMucService;
//     @Autowired
//     private LoaiSanPhamService loaiSanPhamService;
//     @Autowired
//     private SanPhamService sanPhamService;
//     @Autowired
//     private NhanVienService nhanVienService;
//     @Autowired
//     private UuDaiKhachHangService uuDaiKhachHangService;
//     @Autowired
//     private UuDaiSanPhamService uuDaiSanPhamService;
//     @Autowired
//     private ChiTietUuDaiService chiTietUuDaiService;

//     @Autowired
//     private JavaMailSender mailSender;

//     @GetMapping(path = "/iframe")
//     public String iframe(){

//         return "iframe";
//     }

//     @Transactional
//     @ResponseBody
//     @GetMapping(path = "/sendEmail")
//     public ModelAndView sendEmail(String email, ModelMap model) {

//         try {
//             // create new password
//             Clock clock = Clock.systemDefaultZone();
//             String newPw = ""+clock.millis()%1000000;

//             // Create a Simple MailMessage.
//             SimpleMailMessage message = new SimpleMailMessage();
            
//             message.setTo("n19dccn156@student.ptithcm.edu.vn");
//             message.setSubject(""+newPw);
//             message.setText("Đây là mật khẩu mới của bạn. Hãy đổi mật khẩu trước khi sử dụng !!!");
//             // Send Message!
            
//             // update password
//             TaiKhoanModel taiKhoan =  taiKhoanService.findByEmail("n19dccn156@student.ptithcm.edu.vn");
//             taiKhoanService.updateTaiKhoanByMatKhau(taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), newPw);
//             this.mailSender.send(message); 
            
//             return new ModelAndView("redirect:/pl/trangchu", model);
//             // return "Mật khẩu mới đã được gửi về email của bạn, hãy kiểm trả và thử lại";
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//             return new ModelAndView("redirect:/pl/login", model);
//             // return "Email không hợp lệ";
//         }
        
//     }

//     @GetMapping(path = "/testTTCN")
//     public String viewTest(ModelMap model, HttpSession session){
         
//         Clock clock = Clock.systemDefaultZone();
//         long milisecond = clock.millis()%1000000;
//         System.out.println(milisecond);
//         // Create a Simple MailMessage.

//         List<ChucVuModel> listCV = chucVuService.findAll();
//         List<GioHangModel> listGH = gioHangService.findAll();
//         List<TaiKhoanModel> listTK = taiKhoanService.findAll();
//         List<NhanVienModel> listNV = nhanVienService.findAll();
//         List<KhachHangModel> listKH = khachHangService.findAll();

//         session.setAttribute("gioHang", listGH);
//         session.setAttribute("chucVu", listCV);
//         session.setAttribute("taiKhoan", listTK);
//         session.setAttribute("nhanVien", listNV);
//         session.setAttribute("khachHang", listKH);

//         return "testTTCN";
//     }

//     @GetMapping(path = "/testTTMH")
//     public String viewTestTTMH(ModelMap model, HttpSession session){
         
//         List<ChucVuModel> listCV = chucVuService.findAll();
//         List<GioHangModel> listGH = gioHangService.findAll();
//         List<TaiKhoanModel> listTK = taiKhoanService.findAll();
//         List<NhanVienModel> listNV = nhanVienService.findAll();
//         List<KhachHangModel> listKH = khachHangService.findAll();

//         session.setAttribute("gioHang", listGH);
//         session.setAttribute("chucVu", listCV);
//         session.setAttribute("taiKhoan", listTK);
//         session.setAttribute("nhanVien", listNV);
//         session.setAttribute("khachHang", listKH);

//         return "testTTMH";
//     }

//     @GetMapping(path = "/testTTSP")
//     public String viewTestTTSP(ModelMap model, HttpSession session){
         
//         List<DanhMucModel> listDM = danhMucService.findAll();
//         List<LoaiSanPhamModel> listLSP = loaiSanPhamService.findAll();
//         List<SanPhamModel> listSP = sanPhamService.findAll();

//         session.setAttribute("danhMuc", listDM);
//         session.setAttribute("loaiSanPham", listLSP);
//         session.setAttribute("sanPham", listSP);

//         return "testTTSP";
//     }

//     @GetMapping(path = "/testTTUD")
//     public String viewTestTTUD(ModelMap model, HttpSession session){
         
//         List<UuDaiKhachHangModel> listUDKH = uuDaiKhachHangService.findAll();
//         List<UuDaiSanPhamModel> listUDSP = uuDaiSanPhamService.findAll();
//         List<ChiTietUuDaiModel> listCTUDKH = chiTietUuDaiService.findAll();


//         session.setAttribute("ctUDKH", listCTUDKH);
//         session.setAttribute("UDSP", listUDSP);
//         session.setAttribute("UDKH", listUDKH);

//         return "testTTUD";
//     }



//     @GetMapping(path = "/login")
//     public String viewLoginPost(ModelMap model){

//         return "login";
//     }

//     // @PostMapping(path = "/login")
//     // public String viewUserTrangChu(@ModelAttribute("formDangNhap") FormDangNhap form, 
//     //                                     ModelMap model, HttpSession session, HttpServletResponse response){

//     //     String tenDangNhap = form.getTenDangNhap();
//     //     String matKhau = form.getMatKhau();
//     //     TaiKhoanModel tkLogin = taiKhoanService.findByTenDangNhap(tenDangNhap);
//     //     try {
//     //         if(tkLogin.getMatKhau().equals(matKhau)) {

//     //             session.setAttribute("tenDangNhap", tenDangNhap);
//     //             session.setAttribute("matKhau", matKhau);
    
//     //             KhachHangModel kh = khachHangService.findByMaTaiKhoan(tkLogin.getMaTaiKhoan());
//     //             List<GioHangModel> listGH = gioHangService.findByMaKhachHang(kh.getMaKhachHang());
                
//     //             session.setAttribute("dangDangNhap", true);
//     //             session.setAttribute("taiKhoan", tkLogin);
//     //             session.setAttribute("khachHang", kh);
//     //             session.setAttribute("gioHang", listGH);

//     //             // if(form.getLuuMatKhau()) {
//     //             //     Cookie cookieUser = new Cookie(tenDangNhap, tenDangNhap);                    Cookie cookie = new Cookie(tenDangNhap, tenDangNhap);
//     //             //     Cookie cookiePass = new Cookie(matKhau, matKhau);

//     //             //     response.addCookie(cookieUser);
//     //             //     response.addCookie(cookiePass);
//     //             // }

//     //             return "redirect:/view/trangchu";
//     //         }
//     //     } catch (Exception e) {
//     //         model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
//     //         return "login";        
//     //     }
//     //     return "login";
//     // }

//     @GetMapping(path = "/logout")
//     public String afterLogout(HttpSession session){

//         session.setAttribute("dangDangNhap", false);
//         session.removeAttribute("taiKhoan");
//         session.removeAttribute("khachHang");
//         session.removeAttribute("gioHang");

//         return "redirect:/view/trangchu";
//     }

//     @GetMapping(path = "/register")
//     public String viewRegisterGet(Model model){

//         return "register";
//     }

//     // @PostMapping(path = "/register")
//     // public ModelAndView viewRegisterPost(@ModelAttribute(name = "formDangKy") FormDangKy formDangKy, ModelMap model){

//     //     String tenDangNhap = formDangKy.getTenDangNhap();
//     //     String matKhau = formDangKy.getMatKhau();
//     //     String nhapLaiMatKhau = formDangKy.getNhapLaiMatKhau();
//     //     String email = formDangKy.getEmail();
//     //     String ho = formDangKy.getHo();
//     //     String ten = formDangKy.getTen();
//     //     String gioiTinh = formDangKy.getGioiTinh();
//     //     String dienThoai = formDangKy.getDienThoai();
//     //     Date ngaySinh = formDangKy.getNgaySinh();

//     //     List<DanhMucModel> listDM = danhMucService.findByTrangThai(true);
//     //     TaiKhoanModel tkTDN = taiKhoanService.findByTenDangNhap(tenDangNhap);
//     //     TaiKhoanModel tkEmail = taiKhoanService.findByEmail(email);
//     //     KhachHangModel khSDT = khachHangService.findByDienThoai(dienThoai);

//     //     if(tkTDN != null){
//     //         model.put("message", "Tên đăng nhập này đã được sử dụng");
//     //         return new ModelAndView("redirect:/view/register", model);
            
//     //     } 
//     //     else if(tkEmail != null) {
//     //         model.put("message", "Tên đăng nhập này đã được sử dụng");
//     //         return new ModelAndView("redirect:/view/register", model);
//     //     }
//     //     else if(khSDT == null) {
//     //         model.put("message", "Tên đăng nhập này đã được sử dụng");
//     //         return new ModelAndView("redirect:/view/register");
//     //     } else if(!matKhau.equals(nhapLaiMatKhau)){
//     //         model.put("message", "Tên đăng nhập này đã được sử dụng");
//     //         return new ModelAndView("redirect:/view/register", model);
//     //     } else {

//     //         Date date = Date.valueOf(java.time.LocalDate.now());
//     //         TaiKhoanModel taiKhoan = new TaiKhoanModel(tenDangNhap, matKhau, email, date, 5);
//     //         taiKhoanRepository.saveAndFlush(taiKhoan);
            
//     //         TaiKhoanModel addTK = taiKhoanService.findByTenDangNhap(tenDangNhap);
            

//     //         KhachHangModel khachHang = new KhachHangModel(ho, ten, gioiTinh, dienThoai, ngaySinh, addTK.getTaiKhoan());
//     //         khachHangRepository.saveAndFlush(khachHang);

//     //         KhachHangModel addKH = khachHangService.findByMaTaiKhoan(addTK.getMaTaiKhoan());

//     //         List<GioHangModel> gioHang = gioHangService.findByMaKhachHang(addKH.getMaKhachHang());
            
//     //         model.put("khachHang", khachHang);
//     //         model.put("gioHang", gioHang);
//     //         model.put("danhMuc", listDM);
            
//     //         return new ModelAndView("redirect:/view/login", model);
//     //     }
//     // }




    
// }
