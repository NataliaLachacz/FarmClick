import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
    selector: 'app-login-view',
    templateUrl: './login-view.component.html',
    styleUrls: ['./login-view.component.scss'],
    standalone: true,
    imports: [RouterLink, ReactiveFormsModule]
})
export class LoginViewComponent {
  @Input() loginForm;
  @Output() tryToLogInEmitter = new EventEmitter();

  tryToLogIn() {
    this.tryToLogInEmitter.emit();
  }
}
