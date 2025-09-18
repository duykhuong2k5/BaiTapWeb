package vn.iostar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import vn.iostar.entity.Video;
import vn.iostar.service.VideoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("")
    public String list(ModelMap model) {
        model.addAttribute("videos", videoService.findAll());
        return "/admin/videos/list";
    }

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("videos", new Video());
        return "/admin/videos/add";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute("video") Video video) {
        videoService.save(video);
        return "redirect:/admin/videos";
    }
    @GetMapping("edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Integer id) {
        Optional<Video> optVideo = videoService.findById(id);
        if (optVideo.isPresent()) {
            model.addAttribute("video", optVideo.get());
            return "admin/videos/add"; // dùng chung form add/edit
        }
        model.addAttribute("message", "Video không tồn tại!");
        return "redirect:/admin/videos";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos";
    }

    @GetMapping("search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, ModelMap model) {
        List<Video> list;
        if(StringUtils.hasText(keyword)){
            list = videoService.findByTitleContaining(keyword);
        }else{
            list = videoService.findAll();
        }
        model.addAttribute("videos", list);
        return "/admin/videos/list";

    }
}
