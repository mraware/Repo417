import { Injectable } from '@angular/core';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private appUrl = '/Recipeak/';
  constructor(private http: HttpClient) { }

  registerUser(userInfo: string) {
	return this.http.post(`${this.appUrl}register/`, userInfo, {withCredentials: false})
	  .pipe(map(
		user => user as User[]
	  ));
  }
}