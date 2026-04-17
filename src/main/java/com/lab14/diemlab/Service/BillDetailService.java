package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.Bill;
import com.lab14.diemlab.Entity.BillDetail;
import com.lab14.diemlab.Repository.BillDetailRepository;
import com.lab14.diemlab.Repository.BillRepository;
import com.lab14.diemlab.Repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private BillService billService;

    public List<BillDetail> findAll() {
        return billDetailRepository.findAll();

    }
    public void addBillDetail(BillDetail billDetail){
        billDetailRepository.save(billDetail);

        Bill bill = billRepository.findById(billDetail.getBill().getId())
                .orElseThrow(() -> new RuntimeException("Bill Not Found"));

    int tong=0;
    for(BillDetail billDetail1 : billDetailRepository.findByBill_Id(bill.getId())){
        tong += billDetail1.getQuantity()*billDetail1.getPrice();
    }
       bill.setTotal(tong);
       billRepository.save(bill);
    }
    public List<BillDetail> findBillDetailByIDBill(int id){
        return billDetailRepository.findByBill_Id(id);
    }
}
