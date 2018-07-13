package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recipe_ingredients")
@JsonIgnoreProperties(value = { "recipe" })
public class RecipeIngredient {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recIng")
	@SequenceGenerator(name="recIng", sequenceName="recipe_ingredients_sq", allocationSize=1)
	@Column(name = "recipeingredient_id")
	private int recipeIngredientId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "recipe_id", updatable=false)
	private Recipe recipe;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ingredient", updatable=false)
	private Ingredient ingredient;
	private double amount;
	private String unit;
	
	public RecipeIngredient() {
		super();
	}

	public RecipeIngredient(int recipeIngredientId, Recipe recipe, Ingredient ingredient, double amount, String unit) {
		super();
		this.recipeIngredientId = recipeIngredientId;
		this.recipe = recipe;
		this.ingredient = ingredient;
		this.amount = amount;
		this.unit = unit;
	}

	public int getRecipeIngredientId() {
		return recipeIngredientId;
	}

	public void setRecipeIngredientId(int recipeIngredientId) {
		this.recipeIngredientId = recipeIngredientId;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	@Autowired
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + recipeIngredientId;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredient other = (RecipeIngredient) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (recipeIngredientId != other.recipeIngredientId)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecipeIngredient [recipeIngredientId=" + recipeIngredientId + ", recipe=" + recipe + ", ingredient="
				+ ingredient + ", amount=" + amount + ", unit=" + unit + "]";
	}
}

/*
package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient {
	@Id
	@Column(name = "recipeingredient_id")
	int recipeIngredientId;
//	@ManyToOne
	@JoinColumn(name = "recipe_id")
	int recipeId;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ingredient", updatable=false)
	Ingredient ingredient;
	double amount;
	String unit;
	public RecipeIngredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeIngredient(int recipeIngredientId, int recipeId, Ingredient ingredient, double amount, String unit) {
		super();
		this.recipeIngredientId = recipeIngredientId;
		this.recipeId = recipeId;
		this.ingredient = ingredient;
		this.amount = amount;
		this.unit = unit;
	}
	public int getRecipeIngredientId() {
		return recipeIngredientId;
	}
	public void setRecipeIngredientId(int recipeIngredientId) {
		this.recipeIngredientId = recipeIngredientId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	@Autowired
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + recipeId;
		result = prime * result + recipeIngredientId;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredient other = (RecipeIngredient) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (recipeId != other.recipeId)
			return false;
		if (recipeIngredientId != other.recipeIngredientId)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RecipeIngredient [recipeIngredientId=" + recipeIngredientId + ", recipeId=" + recipeId + ", ingredient="
				+ ingredient + ", amount=" + amount + ", unit=" + unit + "]";
	}
	
}*/