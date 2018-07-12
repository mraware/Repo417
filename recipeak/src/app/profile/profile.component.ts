import { ProfileService } from './../profile.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  // id: number;

  profile: User;

  constructor(private ps: ProfileService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ps.getUser(+params['id']).subscribe(
        profile => this.profile = profile);
    });
  }

  promoteUser() {
    this.profile.type = 'star';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);

  }

  banUser() {
    this.profile.type = 'banned';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);
  }

  unbanUser() {
    this.profile.type = 'user';
    this.ps.updateUser(this.profile).subscribe(
      profile => this.profile = profile);
  }
}
