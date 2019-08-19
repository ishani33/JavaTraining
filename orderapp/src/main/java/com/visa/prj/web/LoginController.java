package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user") //this places the model attribute "user" in session scope 
public class LoginController {

    @RequestMapping("login.do")
    public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m) {
    	// do validation here
        m.addAttribute("user", email); //by default model attributes are in request scope 
        return "listproducts.do"; //by default it is server side redirection
    }
     
    @RequestMapping("signout.do")
    public String doLogout(HttpServletRequest req) {
        HttpSession ses = req.getSession(false);
        ses.removeAttribute("user");
        ses.invalidate();
        return "redirect:login.html"; //client side redirection
    }
     
}
