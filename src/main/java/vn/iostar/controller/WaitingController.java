package vn.iostar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.iostar.entity.User;

@Controller
@RequestMapping("/waiting")
public class WaitingController {

    @GetMapping
    public String redirectBasedOnRole(@SessionAttribute(name = "account", required = false) User user, RedirectAttributes redirectAttributes) {
        if (user != null) {
            redirectAttributes.addFlashAttribute("username", user.getUserName());

            if (user.getRoleid() == 1) {
                return "redirect:/admin/home";
            } else if (user.getRoleid() == 2) {
                return "redirect:/manager/home";
            } else {
                return "redirect:/user/home";
            }
        } else {
            return "redirect:/login";
        }
    }
}
