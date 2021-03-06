import { RecipeService } from './../recipe.service';
import { ProfileService } from '../profile.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { Recipe } from '../recipe';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  loggedIn: User;
  profile: User;
  recipes: Recipe[];

  constructor(private ps: ProfileService, private route: ActivatedRoute, private rs: RecipeService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ps.getUser(+params['id']).subscribe(
        profile => {
          this.profile = profile;
          this.rs.getRecipesByUser(this.profile.userId).subscribe(recipes => {
            this.recipes = recipes;
            console.log(this.recipes);
          });
        });
    });

    this.ps.getLoggedIn().subscribe(loggedIn => this.loggedIn = loggedIn);
  }

  promoteUser() {
    this.profile.type = 'star';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);

  }

  banUser() {
    this.profile.type = 'banned';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);
  }

  unbanUser() {
    this.profile.type = 'user';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);
  }

  viewHistory() {
    this.router.navigate([`/profile/${this.profile.userId}/history`]);
  }
}
