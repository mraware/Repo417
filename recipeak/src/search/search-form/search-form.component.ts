import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

import { Ingredient } from '../ingredient';

const ingredients = ['bread', 'peanut butter', 'butter', 'salt', 'black pepper', 'salmon', 'parsley'];

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html'
})
export class SearchFormComponent {

  ingredients = ['bread', 'peanut butter', 'butter', 'salt', 'black pepper', 'salmon', 'parsley'];

  model = new Ingredient('ingredient model');

  submitted = false;

  onSubmit() { this.submitted = true; }

  newIngredient() {
    this.model = new Ingredient('');
  }

  //////// NOT SHOWN IN DOCS ////////

  // Reveal in html:
  //   Name via form.controls = {{showFormControls(searchForm)}}
  showFormControls(form: any) {
    return form && form.controls['name'] &&
      form.controls['name'].value; // Dr. IQ
  }

  /////////////////////////////

  @Component({
    selector: 'ngbd-typeahead-basic',
    templateUrl: './search-form.component.html'
  })

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 2 ? []
        : ingredients.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    );
}