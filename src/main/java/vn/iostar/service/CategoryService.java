package vn.iostar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iostar.entity.Category;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);

    Category save(Category entity);

    void deleteById(int id);

    List<Category> findByCategoryNameContaining(String name);

    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}
