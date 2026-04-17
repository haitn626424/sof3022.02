package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.Bill;
import com.lab14.diemlab.Service.BillService;
import com.lab14.diemlab.Service.CategoryService;
import com.lab14.diemlab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private UserService userService;

    @GetMapping("hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listBills", billService.findAll());
        model.addAttribute("bill", new Bill());
        model.addAttribute("listUsers", userService.findAll());
        return "bill.html";
    }
    @PostMapping("add")
    public String add(@ModelAttribute Bill bill, Model model) {
        billService.addBill(bill);
        return "redirect:/bills/hien-thi";
    }
}
