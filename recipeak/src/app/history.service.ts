import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';
import { History } from './history';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  private url = '/Recipeak/';
  constructor(public http: HttpClient) { }

  getHistory(id: number) {
    return this.http.get(`${this.url}user/${id}/history`)
    .pipe(map(resp => resp as History[]));
  }

  getReviewsByRecipe(id: number) {
    return this.http.get(`${this.url}recipe/${id}/reviews`)
    .pipe(map(resp => resp as History[]));
  }

  getReviewsByUser(id: number) {
    console.log(`${this.url}user/${id}/reviews`);
    return this.http.get(`${this.url}user/${id}/reviews`)
    .pipe(map(resp => resp as History[]));
  }

  addReview(history: History) {
    return this.http.post(`${this.url}history/review`, history)
    .pipe(map(resp => resp as History));
  }
}