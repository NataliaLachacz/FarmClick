import { Injectable } from '@angular/core';
import { UserStats } from '../models/userStats.model';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = 'http://localhost:8080/api/user/stats';

  constructor(private http: HttpClient) {}

  getUserStats(): Observable<UserStats[]> {
    return this.http.get<UserStats[]>(this.url);
  }
}
