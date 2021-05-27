package com.cooking.accessingdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RecipeRepository recipeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<User> listUsers = userRepo.findAll();
		
		listUsers.forEach(System.out :: println);
		
		List<Recipe> listRecipes = recipeRepo.findAll();
		
		listRecipes.forEach(System.out :: println);
		
		List<Recipe> listRecipesByChef = recipeRepo.findBychefid(2);
		
		listRecipesByChef.forEach(System.out :: println);
		//System.exit(0);
	}

}
