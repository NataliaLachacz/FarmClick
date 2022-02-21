import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../../_core/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  errorMessage: string;

  constructor(private readonly _authService: AuthService) { }

  ngOnInit(): void {
    this.initVariables();
  }

  initVariables(): void {
    this.initEmptyRegisterForm();
    this.errorMessage = '';
  }

  initEmptyRegisterForm(): void {
    this.registerForm = new FormGroup({
      nickname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      repeatedPassword: new FormControl('', Validators.required)
    });
  }

  onSubmitRegisterForm(): void {
    const email: string = this.registerForm.controls.email.value;
    const password: string = this.registerForm.controls.password.value;

    if (password === this.registerForm.controls.repeatedPassword.value) {
      this._authService.tryRegisterUser(email, password);
    } else {
      this.errorMessage = 'The repeated password is different';
    }
  }
}
