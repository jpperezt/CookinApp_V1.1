import { Component, OnInit } from '@angular/core';
import { Recipe } from '../model/recipe';
import { RecipeService } from '../service/recipe.service';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[];
  userid_String: string = sessionStorage.getItem('userid');
  userid_Number: number = +this.userid_String;
  usertype: string = sessionStorage.getItem('usertype');
  recipe = '';

  constructor(private recipeService: RecipeService,
  			  public loginService:AuthenticationService,
  			  private router: Router) { 
  }

  ngOnInit(): void {
  	console.log('UserID String ' + this.userid_String);
  	console.log('UserType ' + this.usertype);
  	sessionStorage.setItem('edit','false');
  	if (this.usertype == 'CHEF') {
  		this.recipeService.findAllByChefId(this.userid_Number).subscribe(data => {
    	console.log('UserID with Type Chef' + this.userid_Number);
    	this.recipes = data;
    	});
  	}
  	else
  	{
  		console.log('UserID with Type !Chef' + this.userid_Number);
  		this.recipeService.findAll().subscribe(data => {
      	this.recipes = data;
    	});
  	}
  	
  }

  deleteRecipe(recipe: Recipe) {
    console.log('Calling Delete Service ' + recipe.recipe_id);
    this.recipeService.deleteRecipe(recipe.recipe_id).subscribe(
      () => console.log('Recipe with ID = ${recipe.recipe_id} deleted'),
      (err) => console.log(err)
    );    
  }

  editRecipe(recipe: Recipe) {
    console.log('Calling Edit Service ' + recipe.recipe_id);
    sessionStorage.setItem('edit', 'true');
    sessionStorage.setItem('recipe_id', recipe.recipe_id);
    sessionStorage.setItem('recipe_name', recipe.recipe_name);
    sessionStorage.setItem('recipe_description', recipe.recipe_description);
    this.router.navigate(['/editrecipe']);         
  }

  searchRecipeByName() {
    this.recipeService.findByRecipeName(this.recipe)
      .subscribe(
        data => {
          this.recipes = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
