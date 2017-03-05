package com.ali.javaproject1.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ali.javaproject1.backend.dao.CategoryDao;
import com.ali.javaproject1.backend.model.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ali.javaproject1.backend");
		context.refresh();
		categoryDao=(CategoryDao)context.getBean("categoryDao");
	}
	
	@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("Cloths");
		category.setImageUrl("cat1.jpg");
		assertEquals("Successfully added the category!!!",true,categoryDao.add(category));
	}
}
