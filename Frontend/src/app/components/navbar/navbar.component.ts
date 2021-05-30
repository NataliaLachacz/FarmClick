import { SharedService } from 'src/app/_shared/services/shared.service';
import { Component } from '@angular/core';
import { faShoppingBasket } from '@fortawesome/free-solid-svg-icons';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  faShoppingBasket = faShoppingBasket;

  coins: number;
  subscription: Subscription;

  constructor(private sharedService: SharedService) {
    this.subscription = this.sharedService.coins$.subscribe((coins: number): void => {
      this.coins = coins;
    })
  }
}
