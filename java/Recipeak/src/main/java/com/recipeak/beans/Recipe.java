package com.recipeak.beans;

import javax.persistence.Entity;

@Entity
public class Recipe 
{
	
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
		return true;
	}
	public Recipe(String name, int flavor, int creator, String privacy, int burns, int promoted, String notes) {
		super();
		this.name = name;
		this.flavor = flavor;
		this.creator = creator;
		this.privacy = privacy;
		this.burns = burns;
		this.promoted = promoted;
		this.notes = notes;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	String name;
	int flavor;
	int creator;
	String privacy;
	int burns;
	int promoted;
	String notes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFlavor() {
		return flavor;
	}
	public void setFlavor(int flavor) {
		this.flavor = flavor;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
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
	
	
}
