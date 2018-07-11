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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="History")
public class History {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="history")
	@SequenceGenerator(name="history", sequenceName="history_sq", allocationSize=1)
	@Column(name="History_id")
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", updatable=false)
	private User user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="recipe", updatable=false)
	private Recipe recipe;
	private int saved;
	private int score;
	private String review;
	public History(int id, User user, Recipe recipe, int saved, int score, String review) {
		super();
		this.id = id;
		this.user = user;
		this.recipe = recipe;
		this.saved = saved;
		this.score = score;
		this.review = review;
	}
	public History() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + saved;
		result = prime * result + score;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		History other = (History) obj;
		if (id != other.id)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (saved != other.saved)
			return false;
		if (score != other.score)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", user=" + user + ", recipe=" + recipe + ", saved=" + saved + ", score=" + score
				+ ", review=" + review + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	@Autowired
	public void setUser(User user) {
		this.user = user;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	@Autowired
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public int getSaved() {
		return saved;
	}
	public void setSaved(int saved) {
		this.saved = saved;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
}
