import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Recipe } from '../model/recipe';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RecipeService {

  private recipesUrl: string;

  constructor(private http: HttpClient) {
    this.recipesUrl = 'http://localhost:8080/recipes';
  }

  public findAll(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipesUrl);
  }

  public findAllByChefId(chefid: number): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipesUrl + '/ChefId/' + chefid);
  }

  public save(recipe: Recipe) {
    return this.http.post<Recipe>(this.recipesUrl, recipe);
  }

  public deleteRecipe(recipe_id: string): Observable<void> {
    return this.http.delete<void>(this.recipesUrl + '/' + recipe_id);
  }  

  public editRecipe(recipe_id: string, data) {
    return this.http.put(this.recipesUrl + '/' + recipe_id, data);
  }   

  public getRecipe(recipe_id: string): Observable<Recipe> {
    return this.http.get<Recipe>(this.recipesUrl + '/RecipeId/' + recipe_id);
  }

  public findByRecipeName(recipename: string): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipesUrl + '/' + recipename);
  }

  getChefLoggedIn() {
    let user = sessionStorage.getItem('userid')
    console.log('getChefLoggedIn' + user)
    console.log(!(user === null))    
    return user
  }

}