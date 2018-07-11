import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import {User} from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html', 
  providers: [HttpClient],
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  private appUrl = '/Recipeak/login';
  public username : string;
  public password : string;
  public user : User;
  constructor( private http: HttpClient, private router: Router) 
  {}

  ngOnInit() 
  {
    
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
   this.http.post(this.appUrl,body,{headers:myHeader,withCredentials:true }).pipe(map(resp => resp as User )).subscribe(resp => newFunction(resp, this.router));
  function newFunction (user, router)
  {
   router.navigate(['/profile',user.userId]);
   return user;
  }   
 }
}
