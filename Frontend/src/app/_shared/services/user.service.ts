import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserStats } from '../models/userStats.model';
import { environment } from './../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private readonly _http: HttpClient) {}

  getUserStats(): Observable<UserStats[]> {
    return this._http.get<UserStats[]>(environment.apiUrl);
  }
}
