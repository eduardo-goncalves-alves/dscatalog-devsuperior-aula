package com.pieiv.dscatalog.services;

import com.pieiv.dscatalog.entities.Category;
import com.pieiv.dscatalog.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<Category> findAll() {
        return repository.findAll();
    }
}
