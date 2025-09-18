package vn.iostar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import vn.iostar.entity.Category;
import vn.iostar.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("category", new Category());
        return "admin/categories/add";
    }

    @GetMapping("")
    public String list(ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "admin/categories/list";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("delete/{categoryId}")
    public ModelAndView delete(ModelMap model, @PathVariable("categoryId") int categoryId) {
        categoryService.deleteById(categoryId);
        model.addAttribute("message", "Category is deleted!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @GetMapping("search")
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
        List<Category> list;
        if (StringUtils.hasText(name)) {
            list = categoryService.findByCategoryNameContaining(name);
        } else {
            list = categoryService.findAll();
        }
        model.addAttribute("categories", list);
        return "admin/categories/list";
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
        var optCategory = categoryService.findById(id);
        if (optCategory.isPresent()) {
            model.addAttribute("category", optCategory.get());
            return new ModelAndView("admin/categories/add", model);
        }
        model.addAttribute("message", "Category not found!");
        return new ModelAndView("redirect:/admin/categories", model);
    }
}
