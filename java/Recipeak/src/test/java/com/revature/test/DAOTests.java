package com.revature.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;



import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.data.HistoryDAO;
import com.revature.data.RecipeDAO;
import com.revature.data.UserDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class DAOTests {
	Logger log = Logger.getLogger(DAOTests.class);
	@Autowired
	ApplicationContext ac;
	@Autowired
	HistoryDAO hd;
	@Autowired
	UserDAO ud;
	
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
	
	@Test
	public void userDAOTest() {
		User user = ud.getUserById(1);
		log.trace(user);
		assertFalse(user == null);
	}
	
	@Test
	public void historyDAOByIdTest() {
		User user = ud.getUserById(1);
		log.trace(user);
		List<History> history = hd.historyByUser(user);
		log.trace(history);
		assertFalse(history == null);
	}
}
