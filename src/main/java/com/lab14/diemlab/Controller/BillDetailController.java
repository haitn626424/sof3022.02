package com.lab14.diemlab.Controller;

import com.lab14.diemlab.Entity.BillDetail;
import com.lab14.diemlab.Service.BillDetailService;
import com.lab14.diemlab.Service.BillService;
import com.lab14.diemlab.Service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/billdetails")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private BillService billService;
    @Autowired
    private DrinkService  drinkService;
    @GetMapping("hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listBillDetails", billDetailService.findAll());
        model.addAttribute("billDetail", new BillDetail());
        model.addAttribute("listDrinks", drinkService.findAll());
        model.addAttribute("listBills", billService.findAll());
        return "billDetail.html";
    }
    @PostMapping("add")
    public String addBillDetail(@ModelAttribute("billDetail") BillDetail billDetail, Model model) {
        billDetailService.addBillDetail(billDetail);
        return "redirect:/billdetails/hien-thi";
    }
}
