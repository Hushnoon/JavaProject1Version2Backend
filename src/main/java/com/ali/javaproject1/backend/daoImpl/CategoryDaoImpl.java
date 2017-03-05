package com.ali.javaproject1.backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ali.javaproject1.backend.dao.CategoryDao;
import com.ali.javaproject1.backend.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Category> listCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	
	public boolean add(Category category) {
		try
		{
			//add the category to database table 
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); 
			return false;
		}
		
	}

	public boolean update(Category category) {
		try
		{
			//update the category to database table 
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); 
			return false;
		}
		
	}

	public boolean delete(Category category) {
		
		category.setActive(false);
		try
		{
			//update the category to database table 
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); 
			return false;
		}
	}

}
