import { Plant } from '../../_shared/models/plant.model';
import { Component } from '@angular/core';
import { faArrowLeft, faCheck } from '@fortawesome/free-solid-svg-icons';
import { plants } from 'src/app/_shared/models/plants';
import { Subscription } from 'rxjs';
import { SharedService } from 'src/app/_shared/services/shared.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent {
  faArrowLeft = faArrowLeft;
  faCheck = faCheck;
  plants: Plant[];
  coins: number;
  private _subscription: Subscription = new Subscription();

  constructor(private readonly _sharedService: SharedService) {}

  ngOnInit(): void {
    this.initVariables();
  }

  initVariables(): void {
     this.plants = plants;
     this.getCoins();
   }

   getCoins(): void {
    this._subscription.add(
      this._sharedService.coins$.subscribe(
        (coins: number) => (this.coins = coins, console.log(coins))
      )
    );
  }

   tryBuyNewPlant(plant: Plant): void {
    console.log(plant)
    if (!plant.isUnlock && this.coins >= plant.toUnlock) {
      plant.isUnlock = true;
      this._sharedService.addCoins(this.coins - plant.toUnlock);
      console.log(plants)
    }
   }

   ngOnDestroy(): void {
  this._subscription.unsubscribe();
   }
}
