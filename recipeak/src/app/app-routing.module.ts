import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { RecipeComponent } from './recipe/recipe.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { LogOutComponent } from './log-out/log-out.component';
import { HistoryComponent } from './history/history.component';

const routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'recipes', component: RecipeComponent },
  { path: 'detail/:id', component: RecipeDetailComponent },
  { path: 'profile/:id', component: ProfileComponent },
  { path: 'profiles', component: ProfilesComponent },
  { path: 'search', component: SearchComponent},
  { path: 'login', component: LoginComponent },
  { path: 'profile/:id/history', component: HistoryComponent},
  { path: 'logout', component: LogOutComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes), NgbModule.forRoot()],
  exports: [ RouterModule ],
  declarations: []
})

export class AppRoutingModule { }
