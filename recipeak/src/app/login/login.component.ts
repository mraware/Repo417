import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import {User} from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html', 
  providers: [HttpClient],
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  private appUrl = 'http://localhost:8080/Recipeak/login';
  public username : string;
  public password : string;
  public user : User;
  constructor( private http: HttpClient) 
  {}

  ngOnInit() 
  {
    console.log("I am being called. I AM A LOG IN MACHINE :)");
  }
  

 letMeIn()
 {
   this.username = (<HTMLInputElement>document.getElementById("username")).value;
   console.log(this.username);
   this.password = (<HTMLInputElement>document.getElementById("password")).value;
   console.log(this.password);
   var myHeader = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
   let body = new HttpParams();
   body = body.set('username', this.username);
   body = body.set('password', this.password);
   return this.http.post(this.appUrl,body,{headers:myHeader}).pipe(map(resp => resp as User )).subscribe(resp => this.user=resp);
 }
 logOut()
 {
   this.http.delete(this.appUrl);
   this.user=null;
 }
}
