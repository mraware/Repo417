import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  public username : string;
  public password : string;
  constructor() { }

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
  
 }
}
