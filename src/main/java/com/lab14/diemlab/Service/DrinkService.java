package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.Drink;
import com.lab14.diemlab.Repository.CategoryRepository;
import com.lab14.diemlab.Repository.DrinkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Drink> findAll() {

        return drinkRepository.findAllByActive(true);
    }

    public  void addDrink(Drink drink){
        drinkRepository.save(drink);
    }
    public void deleteDrinkByActive(Integer id){
        Drink drink =  drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Drink not found"));
        drink.setActive(false);
        drinkRepository.save(drink);
    }
}
