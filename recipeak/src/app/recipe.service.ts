import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Recipe } from './recipe';
import { RECIPES } from './mock-recipes';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor() { }

  getRecipes(): Observable<Recipe[]> {
	return of(RECIPES);
  }
}
