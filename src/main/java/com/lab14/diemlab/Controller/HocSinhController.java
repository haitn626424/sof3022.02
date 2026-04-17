package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.HocSinh;
import com.lab14.diemlab.Repository.HocSinhRepository;
import com.lab14.diemlab.Repository.LopHocRepository;
import com.lab14.diemlab.Service.HocSinhService;
import com.lab14.diemlab.Service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hocsinhs")
public class HocSinhController {
    @Autowired
    private HocSinhService hocSinhService;
    @Autowired
    private LopHocService lopHocService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size, Model model){
        Page<HocSinh> pageHocSinh = hocSinhService.findAll(page, size);
        model.addAttribute("listHocSinhs",pageHocSinh);
        model.addAttribute("currentPage",pageHocSinh.getNumber());
        model.addAttribute("totalPages",pageHocSinh.getTotalPages());
        model.addAttribute("listLopHocs",lopHocService.findAll());
        model.addAttribute("hocSinh" , new HocSinh());
        return "hoc-sinh";

    }
    @PostMapping("add")
    public String add(@ModelAttribute HocSinh hocSinh, Model model){
        hocSinhService.save(hocSinh);
        return "redirect:/hocsinhs/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") int id, Model model){
        HocSinh hocSinh = hocSinhService.findById(id);
        model.addAttribute("hocSinh",hocSinh);
        model.addAttribute("listLopHocs",lopHocService.findAll());
        return "view-update";
    }
    @PostMapping("update")
    public String update(@ModelAttribute HocSinh hocSinh, Model model){
        hocSinhService.save(hocSinh);
        return "redirect:/hocsinhs/hien-thi";
    }

}
