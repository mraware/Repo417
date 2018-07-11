import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Recipe } from '../recipe';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  @Input() recipe: Recipe;

  constructor(private rs: RecipeService, private route: ActivatedRoute) { 
    
  }

  ngOnInit() {
    this.getRecipe();
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
