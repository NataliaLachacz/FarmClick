import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() { }

  tryRegisterUser(email: string, password: string): void {
    console.log(email, password);
  }

  tryLoginUser(email: string, password: string): void {
    console.log(email, password);
  }

  registerUser(login: string, password: string) {
    console.log(login, password);
  }

  getAuthorizationToken(): string {
    return '';
  }
}
