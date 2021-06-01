import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RecipeService } from '../service/recipe.service';
import { Recipe } from '../model/recipe';

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.css']
})
export class RecipeFormComponent{

  recipe: Recipe;
  chefIdDefault: string;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private recipeService: RecipeService) {
    if (sessionStorage.getItem('edit') == 'true') {
    	console.log('Entering in Edit ');
    	this.recipe.recipe_id = sessionStorage.getItem('recipe_id')
    	this.recipe.recipe_name = sessionStorage.getItem('recipe_name')
    	this.recipe.recipe_description = sessionStorage.getItem('recipe_description')
    }
    else
    {
    	this.recipe = new Recipe();    
    	console.log('Chef Id from Service 2 '+this.recipeService.getChefLoggedIn())
    	this.chefIdDefault = this.recipeService.getChefLoggedIn();
    	this.recipe.chefid = +this.chefIdDefault;
    	console.log('Chef Id from Service 3 '+this.recipe.chefid);
    }
  }  

  onSubmit() {
    if (sessionStorage.getItem('edit') == 'true') {
    	this.recipeService.editRecipe(this.recipe.recipe_id, this.recipe).subscribe(
      	() => console.log('Recipe with ID = ${recipe.recipe_id} edited'),
      	(err) => console.log(err)
    	);
    }
    else
    {
    	this.recipeService.save(this.recipe).subscribe(result => this.gotoRecipeList());
    }       
  }

  gotoRecipeList() {
    this.router.navigate(['/recipes']);
  }
}