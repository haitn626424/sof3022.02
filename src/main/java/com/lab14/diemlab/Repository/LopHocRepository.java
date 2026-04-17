package com.lab14.diemlab.Repository;

import com.lab14.diemlab.Entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc,Integer> {
}
