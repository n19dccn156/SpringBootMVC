package KhanhVySang.demo.Controller.Public;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonDatHang {
    
    @GetMapping(path = "/vi/donhang")
    public String donHang(){
        
        return "";
    }
}
