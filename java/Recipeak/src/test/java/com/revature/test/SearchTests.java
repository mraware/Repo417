package com.revature.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.data.SearchDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class SearchTests {
	
	SearchDAO ss;

	@Test
	public void searchGetByUser() {
		System.out.println("recipeByUser: " + ss.getRecipeByUser(1));
		assertFalse(null == ss.getRecipeByUser(1));
	}
	
	@Test
	public void searchGetByFlavor() {
		System.out.println("recipeByUser: " + ss.getRecipeByFlavor(1));
		assertFalse(null == ss.getRecipeByFlavor(1));
	}
	
	@Test
	public void searchAllRecipes() {
		System.out.println("recipeByUser: " + ss.getAllRecipes());
		assertFalse(null == ss.getAllRecipes());
	}
	
	@Test
	public void searchAllRecipeIngredients() {
		System.out.println("recipeByUser: " + ss.getAllRecipeIngredients());
		assertFalse(null == ss.getAllRecipeIngredients());
	}
	
	@Test
	public void searchGetByName() {
		System.out.println("recipeByUser: " + ss.getRecipeByName("Brownie"));
		assertFalse(null == ss.getRecipeByName("Brownie"));
	}

	@Test
	public void searchContains() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(10);
		inputList.add(11);
		inputList.add(12);
		inputList.add(14);
		System.out.println("recipeByUser: " + ss.getContains(inputList));
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
		System.out.println("recipeByUser: " + ss.getContains(inputList));
		assertTrue(null == ss.getContains(inputList));
	}
	
	@Test
	public void searchMadeFrom() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(10);
		System.out.println("recipeByUser: " + ss.getMadeFrom(inputList));
		assertFalse(null == ss.getMadeFrom(inputList));
	}
	
	@Test
	public void searchMadeFromAlt() {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		System.out.println("recipeByUser: " + ss.getMadeFrom(inputList));
		assertTrue(null == ss.getMadeFrom(inputList));
	}
}