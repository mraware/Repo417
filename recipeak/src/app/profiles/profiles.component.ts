import { ProfileService } from './../profile.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Profile } from '../profile/profile.component';


@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  profiles: Profile[];

  constructor(private ps: ProfileService, private router: Router) {}

  ngOnInit() {
    this.ps.getUsers().subscribe(
      profiles => this.profiles = profiles);
  }
  viewProfile(id: number) {
    this.router.navigate(['/profile', id]);
  }

}
