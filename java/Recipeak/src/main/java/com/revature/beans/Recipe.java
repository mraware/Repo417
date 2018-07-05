package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Entity
@Component
@Table(name = "recipe")
public class Recipe 
{
	@Id
	@Column(name = "recipeID")
	@SequenceGenerator(name="repId", sequenceName="RECIPE_SEQ", allocationSize=1)
	@GeneratedValue(generator="redId", strategy=GenerationType.SEQUENCE)
	int recipeID;
	@Column(name = "name")
	String name;
	@Column(name = "flavor")
	int flavor;
	@Column(name = "creator")
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	int creator;
	@Column(name = "privacy")
	String privacy;
	@Column(name = "burns")
	int burns;
	@Column(name = "promoted")
	int promoted;
	@Column(name = "notes")
	String notes;
	public Recipe() {
		super();
	}
	@Autowired
	public Recipe(int recipeID, String name, int flavor, int creator, String privacy, int burns, int promoted,
			String notes) {
		super();
		this.recipeID = recipeID;
		this.name = name;
		this.flavor = flavor;
		this.creator = creator;
		this.privacy = privacy;
		this.burns = burns;
		this.promoted = promoted;
		this.notes = notes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + burns;
		result = prime * result + creator;
		result = prime * result + flavor;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + promoted;
		result = prime * result + recipeID;
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
		Recipe other = (Recipe) obj;
		if (burns != other.burns)
			return false;
		if (creator != other.creator)
			return false;
		if (flavor != other.flavor)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (privacy == null) {
			if (other.privacy != null)
				return false;
		} else if (!privacy.equals(other.privacy))
			return false;
		if (promoted != other.promoted)
			return false;
		if (recipeID != other.recipeID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipeID=" + recipeID + ", name=" + name + ", flavor=" + flavor + ", creator=" + creator
				+ ", privacy=" + privacy + ", burns=" + burns + ", promoted=" + promoted + ", notes=" + notes + "]";
	}
	
}
