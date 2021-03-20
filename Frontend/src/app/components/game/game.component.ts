import { Plant } from './../../models/plant.model';
import { Component } from '@angular/core';

import { plants } from 'src/app/models/plants';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent {
  clicks: number;
  coins: number;
  plantValue: number;
  plants: Plant[];

  constructor() {
    this.clicks = 0;
    this.coins = 0;
    this.plants = plants;
    this.plantValue = this.plants[0].value;
  }

  onAddClick(): void {
    this.clicks++;
    let modulo: number = this.clicks % 3;
    let plantElement: HTMLElement = document.querySelector('.plant__crop');

    switch (modulo) {
      case 0: {
        plantElement.style.display = 'none';
        this.coins += this.plantValue;
        break;
      }
      case 1: {
        plantElement.style.transform = 'scale(0.5)';
        plantElement.style.top = '0px';
        plantElement.style.left = '60px';
        plantElement.style.display = 'block';
        break;
      }
      case 2: {
        plantElement.style.transform = 'scale(1)';
        plantElement.style.top = '-20px';
        plantElement.style.left = '70px';
      }
      default: {
        break;
      }
    }
  }
}
