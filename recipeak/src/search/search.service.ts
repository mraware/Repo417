import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

import { Search, searches } from './data-model';

@Injectable()
export class SearchService {

  delayMs = 500;

  // Fake server get; assume nothing can go wrong
  getSearches(): Observable<Search[]> {
    return of(searches).pipe(delay(this.delayMs)); // simulate latency with delay
  }

  // Fake server update; assume nothing can go wrong
  updateSearch(search: Search): Observable<Search>  {
    const oldSearch = searches.find(h => h.id === search.id);
    const newSearch = Object.assign(oldSearch, search); // Demo: mutate cached hero
    return of(newSearch).pipe(delay(this.delayMs)); // simulate latency with delay
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/