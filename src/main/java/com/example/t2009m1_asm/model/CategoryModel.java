package com.example.t2009m1_asm.model;

import com.example.t2009m1_asm.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean Save(Category category);

    List<Category> getAll();

    Category findById(int id);


    boolean Update(int id, Category updateCategory);

    boolean Delete(int id);
}
