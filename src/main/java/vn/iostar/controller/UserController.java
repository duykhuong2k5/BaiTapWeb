package vn.iostar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import vn.iostar.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String list(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/accounts/list";
    }

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("user", new User());
        return "admin/accounts/add"; // show form add.jsp
    }

    @GetMapping("edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Integer id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/accounts/add";
        }
        model.addAttribute("message", "User not found");
        return "redirect:/admin/users";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(ModelMap model, @ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id, ModelMap model) {
        userService.deleteById(id);
        model.addAttribute("message", "User deleted!");
        return new ModelAndView("redirect:/admin/users", model);
    }

    @GetMapping("search")
    public String search(@RequestParam(name = "name", required = false) String name, ModelMap model) {
        List<User> list;
        if (name != null && !name.isEmpty()) {
            list = userService.searchByUserName(name);
        } else {
            list = userService.findAll();
        }
        model.addAttribute("users", list);
        return "admin/accounts/list";
    }
}
