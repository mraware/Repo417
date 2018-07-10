package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Instructions")
public class Instruction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructions")
	@SequenceGenerator(name="instructions", sequenceName="instructions_sq", allocationSize=1)
	@Column(name="instruction_id")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="recipe_id", insertable=false, updatable=false)
//	@Column(name="recipe_id")
	private Recipe recipe;
	@Column(name="step_number")
	private int stepNumber;
	private String step;
	public Instruction() {
		super();
	}
	public Instruction(int id, Recipe recipe, int stepNumber, String step) {
		super();
		this.id = id;
		this.recipe = recipe;
		this.stepNumber = stepNumber;
		this.step = step;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((step == null) ? 0 : step.hashCode());
		result = prime * result + stepNumber;
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
		Instruction other = (Instruction) obj;
		if (id != other.id)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (step == null) {
			if (other.step != null)
				return false;
		} else if (!step.equals(other.step))
			return false;
		if (stepNumber != other.stepNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Instruction [id=" + id + ", recipe=" + recipe + ", stepNumber=" + stepNumber + ", step=" + step + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public int getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	
	
	
}
