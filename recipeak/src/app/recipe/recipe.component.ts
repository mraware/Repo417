import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe';
import {RECIPES} from '../mock-recipes';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes = RECIPES;
  selectedRecipe: Recipe;

  onSelect(recipe: Recipe): void {
	this.selectedRecipe = recipe;
  }

  constructor() { }

  ngOnInit() {
  }

}
