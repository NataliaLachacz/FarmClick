import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() { }

  registerUser(login: string, password: string) {
    console.log(login, password);
  }

  getAuthorizationToken(): string {
    return '';
  }
}
