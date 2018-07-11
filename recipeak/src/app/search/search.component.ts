import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { Ingredient } from '../ingredient';

const ingredients = ['bread', 'peanut butter', 'butter', 'salt', 'black pepper', 'salmon', 'parsley'];

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html'
})

export class SearchComponent {

  ingredients = ['bread', 'peanut butter', 'butter', 'salt', 'black pepper', 'salmon', 'parsley'];

  model = new Ingredient('ingredient model');

  submitted = false;

  onSubmit() { this.submitted = true; }

  ingredientList:Ingredient[] = [];

  newIngredient(form: any) {
    this.ingredientList.push(new Ingredient(form.controls['ingredientList'].value));
  }

showFormControls(form: any) {
  /*return form && form.controls['ingredientList'] &&
    form.controls['ingredientList'].value;*/
    return this.ingredientList;
}
}