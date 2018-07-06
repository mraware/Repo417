package com.revature.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Flavor;
import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.data.HistoryDAO;
import com.revature.data.HistoryHibernateDAO;
import com.revature.data.RecipeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class DAOTests {
	@Autowired
	ApplicationContext ac;
	@Autowired
	HistoryDAO hd;
	
	@BeforeClass
	public static void methodCalledBeforeAllTests() {
	}
	
	@Test 
	public void historyDAO() {
		assertFalse(hd==null);
	}
	
	@Test 
	public void historyDAOGet() {
		History h = hd.getHistoryById(1);
		assertFalse(h==null);
	}
	
	@Test 
	public void historyDAOStore() {
		History h = new History();
		hd.addHistory(h);
		assertFalse(h==null);
	}
	
	/**** RECIPE TESTS *****/
	
	@Autowired 
	RecipeDAO rd;
	
	@Test
	public void recipeDAO() {
		assertFalse(rd == null);
	}
	
	@Test
	public void recipeDAOGet() {
		Recipe r = rd.getById(1);
		assertFalse(r == null);
	}
	
	@Test 
	public void recipeDAOStore() {
		// how hard does this statement fail?
		Recipe r = (Recipe) ac.getBean(Recipe.class);
		rd.create(r);
		assertFalse(r == null);
		
	}
}
