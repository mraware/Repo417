package com.recipeak.beans;

public class Recipe 
{
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
