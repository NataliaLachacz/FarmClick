import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor() { }

  tryRegisterUser(email: string, password: string): void {
    console.log(email, password);
  }

  tryLoginUser(email: string, password: string): void {
    console.log(email, password);
  }
}
