package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.Drink;
import com.lab14.diemlab.Service.CategoryService;
import com.lab14.diemlab.Service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listDrinks", drinkService.findAll());
        model.addAttribute("drink", new Drink());
        model.addAttribute("listCategories", categoryService.findAll());
        return "drink.html";
    }
    @PostMapping("add")
    public String addDrink(@ModelAttribute("drink") Drink drink , Model model) {
        drinkService.addDrink(drink);
        return "redirect:/drinks/hien-thi";
    }
    @GetMapping("/xoa")
    public String xoa(@RequestParam Integer id, Model model) {
        drinkService.deleteDrinkByActive(id);
        return "redirect:/drinks/hien-thi";
    }
}
