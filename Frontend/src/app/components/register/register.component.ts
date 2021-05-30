import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { LoginService } from 'src/app/_shared/services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  errorMessage: string;

  constructor(private loginService: LoginService) { }

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
    const email = this.registerForm.controls.email.value;
    const password = this.registerForm.controls.password.value;

    if (password === this.registerForm.controls.repeatedPassword.value) {
      this.loginService.tryRegisterUser(email, password);
    } else {
      this.errorMessage = 'The repeated password is different';
    }
  }
}
