package com.cooking.accessingdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	List<Recipe> findBychefid(Integer chefid);
	//List<Recipe> findByrecipe_name(String recipe_name);

}
