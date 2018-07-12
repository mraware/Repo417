import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Recipe } from '../recipe';
/*import {RECIPES} from '../mock-recipes';*/
import { RecipeService } from '../recipe.service';
import { User } from '../user';
import { Flavor } from '../flavor';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes: Recipe[]; 
  recipe: Recipe;
  id : number;
  notes: String;
  constructor(private recipeService: RecipeService, private http: HttpClient) { }

  ngOnInit() {
    let user = new User(0,"","","","","");
    this.getRecipes();
    this.http.get('/Recipeak/login/session').pipe(map(resp => resp as User )).subscribe(resp => newFunction(resp));
    function newFunction(resp)
    {
      user = resp;
      if(user.type==="user")
      {
        document.getElementById("sensitive").style.display="none";
      }
    }
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
    arecipe.creator = new User(0,"","","","","");
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

  Promote() : void
  {
    console.log("PROMOTE HAS BEEN CALLED.");
    this.id = Number ((<HTMLInputElement>document.getElementById("recipeID")).value);
    let brecipe = new Recipe();
    this.recipeService.getRecipe(this.id).subscribe(resp => GoldStar (resp,this.recipeService));
    function GoldStar(resp, recipeService)
    {
      brecipe = resp;
      console.log(brecipe);
      console.log(brecipe.recipeId);
      console.log("The old promoted level is "+ brecipe.promoted);
      brecipe.promoted=1;
      console.log("The new promoted level is " +brecipe.promoted);
      recipeService.updateRecipe(brecipe).subscribe(recipe => brecipe = recipe);
    }
  }

  EngageStar(promoted) 
  {
    if(promoted>0)
    {
      return "PROMOTED!!!" 
    }
    return null;
  }

  Notes() : void
  {
    console.log("NOTES HAS BEEN CALLED.");
    this.id = Number ((<HTMLInputElement>document.getElementById("recipeID")).value);
    this.notes = (<HTMLInputElement>document.getElementById("Notes")).value;
    let brecipe = new Recipe();
    this.recipeService.getRecipe(this.id).subscribe(resp => NoteTaker (resp,this.recipeService));
    function NoteTaker (resp, recipeService)
    {
      brecipe = resp;
      console.log(brecipe);
      console.log(brecipe.recipeId);
      console.log("The old note is "+ brecipe.notes);
      brecipe.notes= this.notes;
      console.log("The new note is " +brecipe.notes);
      recipeService.updateRecipe(brecipe).subscribe(recipe => brecipe = recipe);
    }
  }
}
