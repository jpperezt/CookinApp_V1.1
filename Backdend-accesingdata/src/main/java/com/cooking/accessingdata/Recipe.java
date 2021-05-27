package com.cooking.accessingdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE")
public class Recipe {
	@Id
	@Column(name = "recipe_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="recipe_seq", allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipe_id;	
	private String recipe_name;
	private String recipe_description;
	private final int chefid;
	
	public Recipe() {
        this.recipe_id = 0;
		this.recipe_name = "";
        this.recipe_description = "";
        this.chefid = 0;
    }
    
    public Recipe(int recipe_id, String recipe_name, String recipe_description, int chefid) {
    	this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.recipe_description = recipe_description;
        this.chefid = chefid;
    }

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	
	public String getRecipe_description() {
		return recipe_description;
	}

	public void setRecipe_description(String recipe_description) {
		this.recipe_description = recipe_description;
	}
	
	public int getChefid() {
		return chefid;
	}
	
	
	@Override
	public String toString() {
		return "Recipe [recipe_name=" + recipe_name + ", recipe_description=" + recipe_description + ", chef_id="
				+ chefid + "]";
	}    

	
}
