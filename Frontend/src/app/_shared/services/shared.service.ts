import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private _clicks = new BehaviorSubject<number>(0);
  private _coins = new BehaviorSubject<number>(0);

  clicks$ = this._clicks.asObservable();
  coins$ = this._coins.asObservable();

  addClick(click: number): void {
    this._clicks.next(click);
  }

  addCoins(coins: number): void {
    this._coins.next(coins);
  }
}
