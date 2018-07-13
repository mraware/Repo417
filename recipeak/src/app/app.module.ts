import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { RecipeComponent } from './recipe/recipe.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ProfileService } from './profile.service';
import { SearchComponent } from './search/search.component';
import { HistoryService } from './history.service';
import { RecipeService } from './recipe.service';
import { LogOutComponent } from './log-out/log-out.component';
import { HistoryComponent } from './history/history.component';
import { ReviewComponent } from './review/review.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RecipeComponent,
    DashboardComponent,
    RecipeDetailComponent,
    ProfileComponent,
    ProfilesComponent,
    SearchComponent,
    LogOutComponent,
    HistoryComponent,
    ReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProfileService,
    HistoryService,
    RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
