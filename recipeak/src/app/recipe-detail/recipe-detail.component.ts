import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Recipe } from '../recipe';
import { User } from '../user';
import { History } from '../history';
import { RecipeService } from '../recipe.service';
import { ProfileService } from '../profile.service';
import { HistoryService } from '../history.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  @Input() recipeData: [any];
  @Input() recipe: Recipe;
  @Input() smallView: boolean;
  loggedIn: User;
  reviewing: boolean;
  ratings: number[];
  rating: number;
  review: string;
  

  constructor(private rs: RecipeService, private route: ActivatedRoute, private ps: ProfileService, private hs: HistoryService, private router: Router) { 
    this.ratings = [1,2,3,4,5];
    this.review = "";
  }

  ngOnInit() {
//     this.getRecipe();
    this.getRecipeData();

    this.ps.getLoggedIn().subscribe(loggedIn => this.loggedIn = loggedIn);
  }

  getRecipe(): void {
    /*   
     * -route.snapshot is a static image of the route 
     * information shortly after the component was created.
     *  
     * -paramMap is a dictionary of route 
     * parameter values extracted from the URL
     */  
    const id = +this.route.snapshot.paramMap.get('id');
    this.rs.getRecipe(id)
    .subscribe(recipe => this.recipe = recipe);
  }

  getRecipeData() {
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.rs.getRecipeData(id)
    .subscribe(recipedata => {
      this.recipeData = recipedata;
      console.log(this.recipeData);
      this.recipe = this.recipeData[0].recipe as Recipe;
      console.log(this.recipe);
    });
  }
  
  toggleReview() {
    this.reviewing = !this.reviewing;
  }

  reviewRecipe() {
    let history = new History();
    history.user = this.loggedIn;
    history.recipe = this.recipe;
    history.score = this.rating;
    history.review = this.review;
    if (history.score && history.score > 0) {
      this.hs.addReview(history).subscribe(resp => {
        if (resp) {
          this.success();
        } else {
          alert("Could not create review");
        }
      });
    } else {
      alert("Enter a valid score.")
    }
  }

  success() {
    this.router.navigateByUrl('/dashboard', {skipLocationChange: true}).then(()=>
    this.router.navigate([`detail/${this.recipe.recipeId}`]));
  }

  isPromoted() {
    if (this.recipe) {
      if (this.recipe.promoted != 0) {
        return "Yes";
      }
    }
    return "No";
  }
}