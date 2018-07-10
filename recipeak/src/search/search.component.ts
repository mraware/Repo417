import { Component, OnInit } from '@angular/core';
import { Observable }        from 'rxjs';
import { finalize } from 'rxjs/operators';

import { Search }        from './data-model';
import { SearchService } from './search.service';

@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.css']
})
export class SearchListComponent implements OnInit {
  searches: Observable<Search[]>;
  isLoading = false;
  selectedSearch: Search;

  constructor(private searchService: SearchService) { }

  ngOnInit() { this.getSearches(); }

  getSearches() {
    this.isLoading = true;
    this.searches = this.searchService.getSearches()
                      // TODO: error handling
                      .pipe(finalize(() => this.isLoading = false));
    this.selectedSearch = undefined;
  }

  select(search: Search) { this.selectedSearch = search; }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/