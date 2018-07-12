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
  id : number;
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
    * 
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

  Burn() : void 
  {
    console.log("BURN HAS BEEN CALLED.");
    this.id = Number ((<HTMLInputElement>document.getElementById("recipeID")).value);
    let brecipe = new Recipe();
    this.recipeService.getRecipe(this.id).subscribe(resp => Incinerate (resp,this.recipeService));
    function Incinerate(resp, recipeService)
    {
    brecipe = resp;
    console.log(brecipe);
    console.log(brecipe.recipeId);
    console.log("The old burn level is "+ brecipe.burns);
    brecipe.burns++;
    console.log("The new burn level is " +brecipe.burns);
    recipeService.updateRecipe(brecipe).subscribe(recipe => brecipe = recipe);
    }
  }
}
