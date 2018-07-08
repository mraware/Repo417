import { ProfileService } from './../profile.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  id: number;

  profile: Profile;

  constructor(private ps: ProfileService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.ps.getUser(this.id).subscribe(
        profile => this.profile = profile);
    });
  }

}

export interface Profile {
  userId: number;
  type: string;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
}
