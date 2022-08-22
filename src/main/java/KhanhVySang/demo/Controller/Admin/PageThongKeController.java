package KhanhVySang.demo.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad/tk")
public class PageThongKeController {
    
    @GetMapping(path = "/doanh-thu/")
    public String doanhThu(){
        return "NhanVien/ThongKe";
    }
}
