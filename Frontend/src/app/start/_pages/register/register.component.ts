import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../../_core/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: UntypedFormGroup;
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
    this.registerForm = new UntypedFormGroup({
      nickname: new UntypedFormControl('', Validators.required),
      email: new UntypedFormControl('', Validators.required),
      password: new UntypedFormControl('', Validators.required),
      repeatedPassword: new UntypedFormControl('', Validators.required)
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
