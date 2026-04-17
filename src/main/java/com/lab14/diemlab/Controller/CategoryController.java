package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.Category;
import com.lab14.diemlab.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listCategories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "category.html";
    }
    @PostMapping("add")
    public String addCategory(@ModelAttribute Category category , Model model) {
        categoryService.addCategory(category);
        return "redirect:/categories/hien-thi";
    }
    @GetMapping("xoa")
    public String xoa(@RequestParam Integer id, Model model){
        categoryService.deleteCategory(id);
        return "redirect:/categories/hien-thi";
    }
}
