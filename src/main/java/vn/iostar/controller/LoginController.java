package vn.iostar.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iostar.entity.User;
import vn.iostar.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginForm() {
        return "web/login";
    }

    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "remember", required = false) String remember,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            session.setAttribute("account", user);

            if ("on".equals(remember)) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(30 * 60);
                response.addCookie(cookie);
            }

            return "redirect:/waiting";
        } else {
            model.addAttribute("alert", "Tài khoản hoặc mật khẩu không đúng");
            return "web/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();

        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/login";
    }
}
