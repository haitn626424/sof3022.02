package com.lab14.diemlab.Repository;

import com.lab14.diemlab.Entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    List<Drink> findAllByActive(boolean active);
}
