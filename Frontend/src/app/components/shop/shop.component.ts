import { Plant } from './../../models/plant.model';
import { Component } from '@angular/core';

import { plants } from 'src/app/models/plants';
import { faArrowLeft, faCheck } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent {
  faArrowLeft = faArrowLeft;
  faCheck = faCheck;

  plants: Plant[];

  constructor() {
    this.plants = plants;
   }
}
