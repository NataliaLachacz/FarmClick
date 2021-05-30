import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private clicks = new Subject<number>();
  private coins = new Subject<number>();

  clicks$ = this.clicks.asObservable();
  coins$ = this.coins.asObservable();

  constructor() { }

  addClick(click: number): void {
    this.clicks.next(click);
  }

  addCoins(coins: number): void {
    this.coins.next(coins);
  }
}
