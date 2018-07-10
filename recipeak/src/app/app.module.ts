import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RecipeComponent } from './recipe/recipe.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ProfileService } from './profile.service';
import { LogOutComponent } from './log-out/log-out.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RecipeComponent,
    DashboardComponent,
    RecipeDetailComponent,
    ProfileComponent,
    ProfilesComponent,
    LogOutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	  HttpClientModule
  ],
  providers: [ProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
