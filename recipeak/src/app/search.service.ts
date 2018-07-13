import { Injectable } from '@angular/core';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Recipe } from './recipe';
import { Ingredient } from './ingredient';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private appUrl = '/Recipeak/';
  constructor(private http: HttpClient) { }

  getRecipesName(name: string) {
	return this.http.get(`${this.appUrl}search/name/${name}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
	  ));
  }

  getRecipesFlavor(flavor: string) {
	return this.http.get(`${this.appUrl}search/flavor/${flavor}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
	  ));
  }

  getRecipesUser(user: string) {
	return this.http.get(`${this.appUrl}search/user/${user}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
	  ));
  }

  getRecipesContains(contains: String) {
	return this.http.get(`${this.appUrl}search/contains/${contains}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
		));
  }

  getRecipesMadeFrom(madefrom: String) {
	return this.http.get(`${this.appUrl}search/madefrom/${madefrom}`, {withCredentials: false})
	  .pipe(map(
		resp => resp as Recipe[]
	  ));
  }
}