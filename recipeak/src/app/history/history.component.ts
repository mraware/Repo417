import { HistoryService } from './../history.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { History } from '../history';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  public history: History[];

  constructor(private hs: HistoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.hs.getHistory(+params['id']).subscribe(
        history => this.history = history);
      });
    }

}
