import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Recipe } from '../recipe';
import { User } from '../user';
import { RecipeService } from '../recipe.service';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  @Input() recipe: Recipe;
  loggedIn: User;

  constructor(private rs: RecipeService, private route: ActivatedRoute, private ps: ProfileService) { 
    
  }

  ngOnInit() {
    this.getRecipe();

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
    console.log(id);
    this.rs.getRecipe(id)
    .subscribe(recipe => this.recipe = recipe);
  }

  




}
