import { HistoryService } from './../history.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { History } from '../history';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  public reviews: History[];

  constructor(private hs: HistoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.hs.getHistory(+params['id']).subscribe(
        reviews => this.reviews = reviews);
      });
    }
}
