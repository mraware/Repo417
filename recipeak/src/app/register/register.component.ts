import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

import { User } from '../user';
import { Recipe } from '../recipe';
import { RegisterService } from '../register.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html'
})

export class RegisterComponent {

    model = new User(0, 'user', '', '', '', '');

    submitted = false;

    onSubmit() { this.submitted = true; }

    users: User[];
    user: User;
    userInfo = '';

    constructor(private registerService: RegisterService) { }

    registerUser(form: any) {
        var username = form.controls['userName'].value;
        var password = form.controls['password'].value;
        var firstname = form.controls['firstName'].value;
        var lastname = form.controls['lastName'].value;
        this.userInfo = username + ' ' + password + ' ' + firstname + ' ' + lastname;
        this.registerService.registerUser(this.userInfo)
            .subscribe(user => this.users = user);
    }
}