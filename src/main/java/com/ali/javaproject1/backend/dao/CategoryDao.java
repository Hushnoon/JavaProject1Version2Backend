package com.ali.javaproject1.backend.dao;

import java.util.List;

import com.ali.javaproject1.backend.model.Category;

public interface CategoryDao {
	
	List<Category> listCategories();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
