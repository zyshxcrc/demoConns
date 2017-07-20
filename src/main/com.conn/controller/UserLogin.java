package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/20.
 */
@Controller
public class UserLogin {
    @RequestMapping("/login")
    public String doLogin(String name,String password){
        if ("liuziyang".equals(name)&&"123456".equals(password)){
            return "main";
        }
        return "redirect:login";
    }
}
