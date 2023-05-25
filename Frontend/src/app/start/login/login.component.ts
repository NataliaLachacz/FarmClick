import { Component } from '@angular/core';
import { LoginViewComponent } from './_components/login-view.component';
import { LoginService } from './login.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    standalone: true,
    imports: [LoginViewComponent],
    providers: [LoginService],
})
export class LoginComponent {
    loginForm = this._loginService.initLoginForm();

    constructor(private readonly _loginService: LoginService) {}

    tryToLogInListener() {
        console.log('login');
    }
}
