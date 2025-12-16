package com.pieiv.dscatalog.services;

import com.pieiv.dscatalog.dto.CategoryDTO;
import com.pieiv.dscatalog.entities.Category;
import com.pieiv.dscatalog.repositories.CategoryRepository;
import com.pieiv.dscatalog.services.exceptions.EntityNotFoundExcpetion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<CategoryDTO> findAll () {
        List<Category> list = repository.findAll();
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundExcpetion("Entity not found with id " + id));
        return new CategoryDTO(entity);
    }
}
