import { Injectable } from '@angular/core';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Recipe } from './recipe';
/*import { RECIPES } from './mock-recipes'; */

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private appUrl = '/Recipeak/';
  constructor(private http: HttpClient) { }

  getRecipeData(id: number) {
    return this.http.get(`${this.appUrl}recipe/${id}`)
      .pipe(map(
        resp => resp as [any]
      ));
  }

  getRecipe(id: number) {
	return this.http.get(`${this.appUrl}recipe/${id}`, {withCredentials: false})
	  .pipe(map(
		resp => resp[0].recipe as Recipe
	  ));
  }

  getRecipes(): Observable<Recipe[]> {
	return this.http.get(`${this.appUrl}recipe/all`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
	  ));
  }


  addRecipe(recipe: Recipe): Observable<Recipe> {
    const body = JSON.stringify(recipe)
    return this.http.post(`${this.appUrl}recipe/new`, body, {withCredentials: true})
      .pipe(map(
        resp => resp as Recipe
      ));
  }

  updateRecipe(recipe: Recipe) {
    const body = JSON.stringify(recipe)
    return this.http.post(`${this.appUrl}recipe/update`, body)
    .pipe(map(resp => resp as Recipe));
  }

  
  getRecipesByUser(id: number): Observable<Recipe[]> {
    return this.http.get(`${this.appUrl}recipe/all/${id}`, {withCredentials: false})
      .pipe(map(
      resp => resp as Recipe[]
      ));
    }

}
