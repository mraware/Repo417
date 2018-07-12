import { HistoryService } from './../history.service';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { History } from '../history';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  public reviews: History[];
  @Input() public id: number;
  @Input() public type: string;

  constructor(private hs: HistoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    console.log("review init");
    console.log(this.id);
    console.log(this.type);
    if (this.type == "recipe") {
      this.route.params.subscribe(params => {
        this.hs.getReviewsByRecipe(this.id).subscribe(
          reviews => this.reviews = reviews);
        });
    } else if (this.type == "user") {
      this.route.params.subscribe(params => {
        this.hs.getReviewsByUser(this.id).subscribe(
          reviews => this.reviews = reviews);
        });
      }
    }
}
