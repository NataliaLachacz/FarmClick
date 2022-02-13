import { Plant } from '../../_shared/models/plant.model';
import { Component } from '@angular/core';
import { faArrowLeft, faCheck } from '@fortawesome/free-solid-svg-icons';
import { plants } from 'src/app/_shared/models/plants';

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
