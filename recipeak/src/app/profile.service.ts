import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Profile } from './profile/profile.component';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private url = 'http://localhost:8080/Recipeak/';
  constructor(public http: HttpClient) { }

  getUsers() {
    return this.http.get(`${this.url}user/all`)
      .pipe(map(resp => resp as Profile[]));
  }

  getUser(id: number) {
    return this.http.get(`${this.url}user/${id}`)
      .pipe(map(resp => resp as Profile));
  }

  updateUser(profile: Profile) {
    return this.http.post(`${this.url}admin/update`, profile)
    .pipe(map(resp => resp as Profile));
  }
}
