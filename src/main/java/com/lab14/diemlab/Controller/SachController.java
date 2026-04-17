package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.Sach;
import com.lab14.diemlab.Service.NhaXuatBanService;
import com.lab14.diemlab.Service.SachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sachs")
@RequiredArgsConstructor
public class SachController {

    private final NhaXuatBanService  nhaXuatBanService;
    private final SachService  sachService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listSachs", sachService.findAll());
        model.addAttribute("listNhaXuatBans", nhaXuatBanService.findAll());
        model.addAttribute("sach", new Sach());
        return "sach";
    }
    @GetMapping("details/{id}")
    public String details(Model model, @PathVariable int id) {
        model.addAttribute("sach", sachService.findById(id));
        model.addAttribute("listSachs", sachService.findAll());
        model.addAttribute("listNhaXuatBans", nhaXuatBanService.findAll());
        return "sach";
    }
    @PostMapping("add")
    public String add(@Valid @ModelAttribute("sach") Sach sach, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "hien-thi";
        }
        sachService.addSachOrUpdate(sach);
        return "redirect:/sachs/hien-thi";
    }
    @GetMapping("/sapxep")
    public String sapxep(Model model) {
        model.addAttribute("listSachs", sachService.findAllSachASC());
        model.addAttribute("listNhaXuatBans", nhaXuatBanService.findAll());
        model.addAttribute("sach", new Sach());
        return "sach";
    }
}
