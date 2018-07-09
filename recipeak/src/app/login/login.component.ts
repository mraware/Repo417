import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html', 
  providers: [HttpClient],
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  private appUrl = 'http://localhost:4200/recipeak/login';
  public username : string;
  public password : string;
  constructor( private http: HttpClient) 
  {}

  ngOnInit() 
  {
    console.log("I am being called. I AM A LOG IN MACHINE :)");
  }
  

 letMeIn()
 {
   console.log("2");
   this.username = (<HTMLInputElement>document.getElementById("username")).value;
   console.log(this.username);
   this.password = (<HTMLInputElement>document.getElementById("password")).value;
   console.log(this.password);
   const body = `user=${this.username}&pass=${this.password}`;
   return this.http.post(this.appUrl,body, {withCredentials: true }).pipe(map(resp => {
    console.log("The mapping at least does something.");
  }
))
 }
}
