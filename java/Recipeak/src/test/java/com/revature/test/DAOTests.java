package com.revature.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.data.SearchService;

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
	public void historyDAOStoreDelete() {
		History h = new History(0,null,null,1,1,"ok");
		System.out.println(h);
		h = hd.addHistory(h);
		System.out.println(h);
		if(h==null) {
			assertTrue(false);
		}
		System.out.println(h);
		hd.deleteHistory(h);
		h = hd.getHistoryById(h.getId());
		assertTrue(h==null);
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
	public void recipeDAOCreate() {
		Recipe r = new Recipe();
		rd.create(r);
		assertFalse(r == null);	
	}
	
	@Test
	public void recipeDAOGetAll() {
		assertFalse(rd.getAll().isEmpty());
	}

	@Test
	public void recipeDAODelete() {
		Recipe r = new Recipe();
		r = rd.create(r);
		rd.delete(r);
		assertTrue(rd.getById(r.getRecipeId()) == null);
	}
	
	// TODO : write a test for recipeDAOUpdate
	

	/**** SEARCH TESTS *****/
	
	@Autowired
	SearchService ss;
	
	@Test
	public void searchGetByUser() {
		assertFalse(null == ss.getRecipeByUser(1));
	}
	
	@Test
	public void searchGetByFlavor() {
		assertFalse(null == ss.getRecipeByFlavor(1));
	}
	
	@Test
	public void searchAllRecipes() {
		assertFalse(null == ss.getAllRecipes());
	}
	
	@Test
	public void searchAllRecipeIngredients() {
		assertFalse(null == ss.getAllRecipeIngredients());
	}
	
	@Test
	public void searchGetByName() {
		assertFalse(null == ss.getRecipeByName("Brownie"));
	}
	
	@Test
	public void searchContains() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(10);
		inputList.add(11);
		inputList.add(12);
		inputList.add(14);
		assertFalse(null == ss.getContains(inputList));
	}
	
	@Test
	public void searchContainsAlt() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		inputList.add(10);
		inputList.add(11);
		inputList.add(12);
		inputList.add(14);
		assertTrue(null == ss.getContains(inputList));
	}
	
	@Test
	public void searchMadeFrom() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(10);
		assertFalse(null == ss.getMadeFrom(inputList));
	}
	
	@Test
	public void searchMadeFromAlt() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		assertTrue(null == ss.getMadeFrom(inputList));
	}
}
