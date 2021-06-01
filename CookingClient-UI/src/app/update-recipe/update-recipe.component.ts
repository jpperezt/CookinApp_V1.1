import { Component, OnInit } from '@angular/core';
import { Recipe } from '../model/recipe';
import { ActivatedRoute, Router } from '@angular/router';
import { RecipeService } from '../service/recipe.service';

@Component({
  selector: 'app-update-recipe',
  templateUrl: './update-recipe.component.html',
  styleUrls: ['./update-recipe.component.css']
})
export class UpdateRecipeComponent implements OnInit {
  
  recipe_id: string;
  recipe: Recipe;

  constructor(private route: ActivatedRoute,
  			  private router: Router,
    		  private recipeService: RecipeService) { }

  ngOnInit() {
  	this.recipe = new Recipe();

    this.recipe_id = this.route.snapshot.params['recipe_id'];
    console.log('Update-recipe OnInit Snapshot '+this.recipe_id);
    
    this.recipe_id = sessionStorage.getItem('recipe_id');
    console.log('Update-recipe OnInit Sesion '+sessionStorage.getItem('recipe_id'));

    this.recipeService.getRecipe(this.recipe_id)
      .subscribe(data => {
        console.log(data)
        this.recipe = data;
      }, error => console.log(error));
  }

  updateRecipe() {
    this.recipeService.editRecipe(this.recipe_id, this.recipe)
      .subscribe(data => {
        console.log(data);
        this.recipe = new Recipe();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateRecipe();    
  }

  gotoList() {
    this.router.navigate(['/recipes']);
  }

}
