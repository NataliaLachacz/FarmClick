import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserStats } from '../models/userStats.interface';
import { environment } from './../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private readonly _httpClient: HttpClient) {}

  getUserStats(): Observable<UserStats[]> {
    return this._httpClient.get<UserStats[]>(environment.apiUrl);
  }
}
