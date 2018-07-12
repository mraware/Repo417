import { Injectable } from '@angular/core';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Ingredient } from './ingredient/ingredient.component';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
  private appUrl = '/Recipeak/';

  constructor(private http: HttpClient) { }

  /*
   * TODO need to set up the ingredient controller
   * 
   */

  getIngredients(recipdId: number): Observable<Ingredient[]> {
    return this.http.get(`${this.appUrl}recipe/all`, {withCredentials: false})
    .pipe(map(
      resp => resp as Recipe[]
    ));

  }
}
