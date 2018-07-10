import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import {User} from '../user';
import { Router } from '@angular/router';
@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit 
{
  private appUrl = 'http://localhost:8080/Recipeak/login';
  public user : User;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() 
  {console.log("Log Out is being called.");}

  EXIT()
 {
  var myHeader = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
  this.http.delete(this.appUrl,body,{headers:myHeader}).pipe(map(resp => resp as User )).subscribe(resp => newFunction(resp, this.router));
   this.http.delete(this.appUrl);
   this.user=null;
 }

}
