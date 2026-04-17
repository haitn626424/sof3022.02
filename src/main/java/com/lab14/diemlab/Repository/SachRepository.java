package com.lab14.diemlab.Repository;

import com.lab14.diemlab.Entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
    @Query(value = "SELECT s FROM Sach s ORDER BY s.gia asc ")
    List<Sach> findAllSachASC();
}
