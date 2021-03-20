import { Component } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent {
  clicks: number;
  coins: number;
  plantValue: number;

  constructor() {
    this.clicks = 0;
    this.coins = 0;
    this.plantValue = 5;
  }

  onAddClick(): void {
    this.clicks++;
    this.coins += this.plantValue;
  }
}
