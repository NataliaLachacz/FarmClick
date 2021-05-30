import { Component } from '@angular/core';

import { Plant } from '../../_shared/models/plant.model';
import { plants } from 'src/app/_shared/models/plants';
import { SharedService } from 'src/app/_shared/services/shared.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss'],
})
export class GameComponent {
  clicks: number;
  coins: number;
  plantValue: number;
  plants: Plant[];

  constructor(private sharedService: SharedService) {
    this.clicks = 0;
    this.coins = 0;
    this.plants = plants;
    this.plantValue = this.plants[0].value;
  }

  onAddClick(): void {
    let plantElement: HTMLElement = document.querySelector('.plant__crop');

    this.clicks++;
    let modulo: number = this.clicks % 3;
    this.sharedService.addClick(this.clicks);

    switch (modulo) {
      case 0: {
        plantElement.style.display = 'none';
        this.coins += this.plantValue;
        this.sharedService.addCoins(this.coins);
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
