package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ingredient")
	@SequenceGenerator(name="ingredient", sequenceName="ingredient_sq", allocationSize=1)
	@Column(name="Ingredient_id")
	private int id;
	private String ingredient;
	public Ingredient() {
		super();
	}
	public Ingredient(int id, String ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredient=" + ingredient + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

}