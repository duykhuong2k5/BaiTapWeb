package vn.iostar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.iostar.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService adminService;

    @GetMapping("/home")
    public String home() {
        return "admin/home";
    }

    @GetMapping("/accounts/list")
    public String listAccounts(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admin/accounts/list";
    }

    @GetMapping("/categories/list")
    public String listCategories(Model model) {
        return "admin/categories/list";
    }

    @GetMapping("/videos/list")
    public String listVideos(Model model) {
        return "admin/videos/list";
    }
}

