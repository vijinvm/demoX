package com.example.demoX;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
@Autowired
private CategoryRepository categoryRepository;

public Category addCategory(Category category) {
   return categoryRepository.save(category);
}
public List<Category> getAllCategories() {
    return categoryRepository.findAll();
}
}
