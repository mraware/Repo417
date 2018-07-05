package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.RecipeDao;

public class Driver {
	private static ApplicationContext ac;
	
	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		RecipeDao bd=(RecipeDao) ac.getBean(RecipeDao.class);
//		System.out.println(bd.getAll());
//		System.exit(0);
	}
}
