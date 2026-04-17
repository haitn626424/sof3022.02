package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.Category;
import com.lab14.diemlab.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {

        return categoryRepository.findAllByActive(true);
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public void deleteCategory(Integer id) {
       Category category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
       category.setActive(false);
       categoryRepository.save(category);

    }
}
