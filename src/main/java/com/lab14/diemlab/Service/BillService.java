package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.Bill;
import com.lab14.diemlab.Entity.BillDetail;
import com.lab14.diemlab.Repository.BillDetailRepository;
import com.lab14.diemlab.Repository.BillRepository;
import com.lab14.diemlab.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BillRepository billRepository;

    public List<Bill> findAll(){
        return billRepository.findAll();
    }
    public Bill findById(int id){
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill Not Found"));
    }
    public void addBill(Bill bill){
        bill.setCreateDate(LocalDate.now());
        bill.setTotal(0);
        billRepository.save(bill);
    }

}
