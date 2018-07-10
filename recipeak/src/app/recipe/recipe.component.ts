import { Component, OnInit } from '@angular/core';

import { Recipe } from '../recipe';
/*import {RECIPES} from '../mock-recipes';*/
import { RecipeService } from '../recipe.service';
import { User } from '../user';
import { Flavor } from '../flavor';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes: Recipe[]; 
  recipe: Recipe;
  constructor(private recipeService: RecipeService) { }

  ngOnInit() {
    this.getRecipes();
  }

  getRecipes(): void {
    this.recipeService.getRecipes()
      .subscribe(recipes => this.recipes = recipes);
  }

  addNew(): void {
    // TODO
    /*
    * Get the User information from the session
    * Add a radio button for public / private
    * provide default values for: 
    *   burns, promoted, notes
    * Either:
    * - drop down to select from flavors
    * - create a new entry for any new flavor tags..
    */
    let arecipe = new Recipe();
    arecipe.recipeId = 42;
    console.log((<HTMLInputElement>document.getElementById("newName")).value);
    console.log((<HTMLInputElement>document.getElementById("flavaFlav")).value);
    arecipe.name=(<HTMLInputElement>document.getElementById("newName")).value;
    arecipe.flavor = new Flavor(0, (<HTMLInputElement>document.getElementById("flavaFlav")).value);
    arecipe.creator = new User(3,"admin","pawling","admin","Isaac","Pawling");
    arecipe.privacy = 'public';
    arecipe.burns = 1;
    arecipe.promoted = 0;
    arecipe.notes = '';
    console.log(arecipe);
    this.recipeService.addRecipe(arecipe)
      .subscribe(recipe => this.recipe = recipe);
  }
}
