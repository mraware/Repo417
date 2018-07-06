package com.revature.app;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Recipe;
import com.revature.data.RecipeDAO;

public class Driver {
	private static ApplicationContext ac;
	
	public static void main(String[] args) {
		
		String filename = "src/main/webapp/WEB-INF/beans.xml";

//        URL url = getClass().getResource(filename);


//        File file = new File(filename);
//        System.out.println(file.exists());
//        //log.info("File exists: {}", file.exists());
		
		ac = new ClassPathXmlApplicationContext("classpath*:beans.xml");
		RecipeDAO bd=(RecipeDAO) ac.getBean("recipe");
//		System.out.println(bd.getAll());
//		System.exit(0);
	}
}
