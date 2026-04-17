package com.lab14.diemlab.Repository;

import com.lab14.diemlab.Entity.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh,Integer> {
}
