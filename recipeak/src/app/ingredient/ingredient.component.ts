import { Component, OnInit } from '@angular/core';

import { Ingredient } from '../ingredient';
import { IngredientService } from '../ing'
  /*
   * TODO : 
   * - make a ingredient class
   * - make an ingredient service
   * - make recipe detail receive an ingredient object 
   * - implement the get recipe function
   * 
   * 
   */
@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.css']
})
export class IngredientComponent implements OnInit {
  ingredients: Ingredient[];

  constructor(private is: IngredientService) { }

  ngOnInit() {
    this.getIngredients(recipeId);
  }

  getIngredients(recipeId: number): void {
    this.is.getIngredients()
      .subscribe(ingredients => this.ingredients = ingredients);
  }
}