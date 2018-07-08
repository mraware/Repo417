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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "recipe")
public class Recipe 
{
	@Id
	@Column(name = "recipe_id")
	@SequenceGenerator(name="recId", sequenceName="RECIPE_SQ", allocationSize=1)
	@GeneratedValue(generator="recId", strategy=GenerationType.SEQUENCE)
	private int recipeId;
	private String name;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="flavor", insertable=false, updatable=false)
	private Flavor flavor;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="creator", insertable=false, updatable=false)
	private User creator;
	private String privacy;
	private int burns;
	private int promoted;
	private String notes;
	
	public Recipe() {
		super();
	}
	@Autowired
	public Recipe(int recipeId, String name, Flavor flavor, User creator, String privacy, int burns, int promoted,
			String notes) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.flavor = flavor;
		this.creator = creator;
		this.privacy = privacy;
		this.burns = burns;
		this.promoted = promoted;
		this.notes = notes;
	}
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Flavor getFlavor() {
		return flavor;
	}
	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public int getBurns() {
		return burns;
	}
	public void setBurns(int burns) {
		this.burns = burns;
	}
	public int getPromoted() {
		return promoted;
	}
	public void setPromoted(int promoted) {
		this.promoted = promoted;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + burns;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + promoted;
		result = prime * result + recipeId;
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
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
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
		if (recipeId != other.recipeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", name=" + name + ", flavor=" + flavor + ", creator=" + creator
				+ ", privacy=" + privacy + ", burns=" + burns + ", promoted=" + promoted + ", notes=" + notes + "]";
	}	
}
