package KhanhVySang.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.ThongTinCaNhan.TaiKhoanModel;
import KhanhVySang.demo.Service.ThongTinCaNhan.TaiKhoanService;

@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TaiKhoanModel taiKhoan = this.taiKhoanService.findByTenDangNhap(username);
        if(taiKhoan == new TaiKhoanModel()){
            System.out.println("Không Tìm Thấy Tài Khoản! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        String role = "ROLE_"+taiKhoan.getQuyen();
        System.out.println(taiKhoan.getTenDangNhap());
        System.out.println(taiKhoan.getMatKhau());
        System.out.println(role);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        // GrantedAuthority grantList = new GrantedAuthorityDefaults(role);

        
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantList.add(authority);

        //Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp cá thông số như tên , password và quyền
        // Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp Spring Security quản lý được phân quyền như ta đã
        // cấu hình  method configure
        UserDetails userDetails = (UserDetails) new User(taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), grantList);

        return userDetails;
    }
    
}
