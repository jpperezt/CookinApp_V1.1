import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import { UpdateRecipeComponent } from './update-recipe/update-recipe.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'deleteuser', component: UserListComponent },
  { path: 'recipes', component: RecipeListComponent },
  { path: 'allrecipes', component: RecipeListComponent },
  { path: 'addrecipe', component: RecipeFormComponent },
  { path: 'editrecipe', component: UpdateRecipeComponent },
  { path: 'deleterecipe', component: RecipeListComponent }	
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
