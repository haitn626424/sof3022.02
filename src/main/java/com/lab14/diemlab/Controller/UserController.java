package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.User;
import com.lab14.diemlab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("hien-thi")
    public String hienthi(Model model){
        model.addAttribute("listUsers", userService.findAll());
        model.addAttribute("user", new User());
        return "user.html";
    }
    @PostMapping("add")
    public String add(@ModelAttribute User user, Model model){
        userService.addUser(user);
        return "redirect:/users/hien-thi";
    }
    @GetMapping("xoa")
    public String xoa(@RequestParam Integer id, Model model){
        userService.deleteUser(id);
        return "redirect:/users/hien-thi";
    }
}
