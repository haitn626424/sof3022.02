package com.lab14.diemlab.Repository;

import com.lab14.diemlab.Entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
    List<BillDetail> findByBill_Id(int billId);
}
