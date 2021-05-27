package com.cooking.accessingdata;

import com.cooking.accessingdata.Recipe;
import com.cooking.accessingdata.RecipeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {
	
	@Autowired
    private AppRecipeDAO appRecipeDAO;
	
	// standard constructors
    
    private final RecipeRepository recipeRepository;
    private List<Recipe> recipes;
    
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    //list recipes
    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
    	recipes = (List<Recipe>) recipeRepository.findAll();
    	return recipes;
    }
    
    //get recipes by Chef Id
    @GetMapping("/recipes/ChefId/{chefid}")
    public List<Recipe> findBychefid(@PathVariable("chefid") Integer chefid) {    	
    	recipes = recipeRepository.findBychefid(chefid);
    	return recipes;
    }
    
    //get recipes by Recipe Id
    @GetMapping("/recipes/RecipeId/{recipe_id}")
    public Optional<Recipe> findByRecipeId(@PathVariable("recipe_id") Integer recipe_id) {    	
    	Optional<com.cooking.accessingdata.Recipe> recipe = recipeRepository.findById(recipe_id);
    	return recipe;
    }
    
    //create operation
    @PostMapping("/recipes")
    void addRecipe(@RequestBody Recipe recipe) {    	
    	System.out.print("inside addRecipe method  = " + recipe.getChefid());
    	System.out.print("inside addRecipe method  = " + recipe.getRecipe_description());
    	System.out.print("inside addRecipe method  = " + recipe.getRecipe_name());
        recipeRepository.save(recipe);
        System.out.print("inside addRecipe method  = " + recipe.getRecipe_id());
    }
    
    //delete operation
    @DeleteMapping("/recipes/{recipe_id}")
   	public ResponseEntity<Void> deleteRecipe(@PathVariable("recipe_id") int recipe_id) {	
    	System.out.println("Inside delete method Recipe  = " + recipe_id);
    	recipeRepository.deleteById(recipe_id);
    	return ResponseEntity.noContent().build();
   	}       
    
    @PutMapping("/recipes/{recipe_id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable(value = "recipe_id") int recipe_id,
        @RequestBody Recipe recipeDetails) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipe_id);        		

        Recipe recipe = optionalRecipe.get();
        
        recipe.setRecipe_name(recipeDetails.getRecipe_name());	
        recipe.setRecipe_description(recipeDetails.getRecipe_description());
        final Recipe updatedRecipe = recipeRepository.save(recipe);
        return ResponseEntity.ok(updatedRecipe);
    }
    
    
    // Login Operation - get user info
    @GetMapping("/recipes/{recipe_name}")
    public Recipe getRecipe(String recipe_name) {
    	Recipe recipe = this.appRecipeDAO.findRecipe(recipe_name);
    	return recipe;
    }
    
}
