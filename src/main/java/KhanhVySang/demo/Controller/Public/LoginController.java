package KhanhVySang.demo.Controller.Public;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import KhanhVySang.demo.Model.Google.GooglePojoModel;
import KhanhVySang.demo.Util.LoginGoogleUtil;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class LoginController {
    
    @Autowired
    private LoginGoogleUtil loginGoogleUtil;

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        System.out.println(code);

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }
        String accessToken = loginGoogleUtil.getToken(code);

        GooglePojoModel googlePojo = loginGoogleUtil.getUserInfo(accessToken);
        UserDetails userDetail = loginGoogleUtil.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        
        // UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal, credentials, authorities)
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/vi/trangchu";
    }


    @GetMapping("/login")
    public String loginGet() {

        return "Public/login";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "Public/403";
    }
}
