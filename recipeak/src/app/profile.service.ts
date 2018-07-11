import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';
import { History } from './history';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private url = '/Recipeak/';
  constructor(public http: HttpClient) { }

  getUsers() {
    return this.http.get(`${this.url}user/all`)
      .pipe(map(resp => resp as User[]));
  }

  getUser(id: number) {
    return this.http.get(`${this.url}user/${id}`)
      .pipe(map(resp => resp as User));
  }

  updateUser(profile: User) {
    return this.http.post(`${this.url}admin/update`, profile)
    .pipe(map(resp => resp as User));
  }

  getHitory(id: number) {
    return this.http.get(`${this.url}user/${id}/history`)
    .pipe(map(resp => resp as History[]));
  }
}
