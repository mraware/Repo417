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
  private appUrl = 'http://localhost:8080/Recipeak/';
  constructor(private http: HttpClient) { }

  getRecipe(id: number) {
	return this.http.get(`${this.appUrl}recipe/${id}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe
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
    return this.http.post(`${this.appUrl}recipe/new`, body)
      .pipe(map(
        resp => resp as Recipe
      ));
  }
}
