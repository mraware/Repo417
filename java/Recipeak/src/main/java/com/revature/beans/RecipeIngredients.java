package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredients {
	@Id
	@Column(name = "recipeingredient_id")
	int recipeIngredientId;
	@ManyToOne
	@Column(name = "recipe_id")
	int recipeId;
	int ingredient;
	double amount;
	String unit;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ingredient;
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
		RecipeIngredients other = (RecipeIngredients) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (ingredient != other.ingredient)
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
		return "RecipeIngredients [recipeIngredientId=" + recipeIngredientId + ", recipeId=" + recipeId
				+ ", ingredient=" + ingredient + ", amount=" + amount + ", unit=" + unit + "]";
	}
	public RecipeIngredients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeIngredients(int recipeIngredientId, int recipeId, int ingredient, double amount, String unit) {
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
	public int getIngredient() {
		return ingredient;
	}
	public void setIngredient(int ingredient) {
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
}