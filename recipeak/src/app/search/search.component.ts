import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { Ingredient } from '../ingredient';
import { Recipe } from '../recipe';
import { SearchService } from '../search.service';

const ingredients = ['bread', 'peanut butter', 'butter', 'salt', 'black pepper', 'salmon', 'parsley'];

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html'
})

export class SearchComponent {

  model = new Ingredient('ingredient model');

  submitted = false;

  onSubmit() { this.submitted = true; }

  ingredientList: Ingredient[] = [];
  recipes: Recipe[];
  recipe: Recipe;
  ingredientsString = '';

  constructor(private searchService: SearchService) { }

  newIngredient(form: any) {
    this.ingredientList.push(new Ingredient(form.controls['ingredientAdd'].value));
  }

  showFormControls(form: any) {
    /*return form && form.controls['ingredientList'] &&
      form.controls['ingredientList'].value;*/

    var ingredientsString = '';
    for (var i = 0; i < this.ingredientList.length; i++) {
      if (i > 0) {
        ingredientsString += ', ';
      }
      ingredientsString += this.ingredientList[i].name;
    }
    return ingredientsString;
  }

  getSearchType(form: any) {
    console.log('getting search type');
    var name = form.controls['recipeName'].value;
    var flavor = form.controls['flavor'].value;
    var user = form.controls['userName'].value;
    if (name != undefined && name != '') {
      console.log('search by name');
      console.log(name);
      this.getRecipeName(name);
      return;
    } else if (flavor != undefined && flavor != '') {
      console.log('search by flavor');
      this.getRecipeFlavor(flavor);
      console.log(flavor);
      return;
    } else if (user != undefined && user != '') {
      console.log('search by user name');
      console.log(user);
      this.getRecipeUser(user);
      return;
    }
    console.log('form is empty');
  }

  getRecipeName(name) {
    this.searchService.getRecipesName(name)
      .subscribe(recipe => this.recipes = recipe);
  }

  getRecipeFlavor(flavor) {
    this.searchService.getRecipesFlavor(flavor)
      .subscribe(recipe => this.recipes = recipe);
  }

  getRecipeUser(user) {
    this.searchService.getRecipesUser(user)
      .subscribe(recipe => this.recipes = recipe);
  }

  getRecipeContains() {
    var ingredientsString = '';
    for (var i = 0; i < this.ingredientList.length; i++) {
      if (i > 0) {
        ingredientsString += ', ';
      }
      ingredientsString += this.ingredientList[i].name;
    }
    console.log('Contains');
    console.log('Ingredients String: ' + ingredientsString);
    this.searchService.getRecipesContains(ingredientsString)
      .subscribe(recipe => this.recipes = recipe);
  }

  getRecipeMadeFrom() {
    var ingredientsString = '';
    for (var i = 0; i < this.ingredientList.length; i++) {
      if (i > 0) {
        ingredientsString += ', ';
      }
      ingredientsString += this.ingredientList[i].name;
    }
    console.log('Made From');
    console.log('Ingredients String: ' + ingredientsString);
    this.searchService.getRecipesMadeFrom(ingredientsString)
      .subscribe(recipe => this.recipes = recipe);
  }
}