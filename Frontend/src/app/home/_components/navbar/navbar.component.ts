import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
// import { faShoppingBasket } from '@fortawesome/free-solid-svg-icons';
import { SharedService } from 'src/app/_shared/services/shared.service';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss'],
    standalone: true
})
export class NavbarComponent implements OnDestroy {
  // faShoppingBasket = faShoppingBasket;
  coins: number;
  private _subscription: Subscription = new Subscription();

  constructor(private readonly _sharedService: SharedService) {
    this._subscription.add(this._sharedService.coins$.subscribe((coins: number): void => {
      this.coins = coins;
    }))
  }

  ngOnDestroy(): void{
    this._subscription.unsubscribe();
  }
}
