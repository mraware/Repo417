import { Injectable } from '@angular/core';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Recipe } from './recipe';
import { RECIPES } from './mock-recipes';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  /* TODO fix this!!! */
  private appUrl = '/Recipeak/';
  constructor(private http: HttpClient) {}

  getRecipes(): Observable<Recipe[]> {
  return this.http.get(this.appUrl, {withCredentials: false})
    .pipe(map(
    resp => resp as Recipe[]
    ));
  }

  /* OLD WAY: Mock data
  getRecipes(): Observable<Recipe[]> {
	return of(RECIPES);
  } */
}
