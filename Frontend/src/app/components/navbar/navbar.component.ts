import { Component, OnInit } from '@angular/core';
import { faShoppingBasket } from '@fortawesome/free-solid-svg-icons';
import { UserService } from '../../services/user.service';
import { UserStats } from '../../models/userStats.model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  faShoppingBasket = faShoppingBasket;
  userStats: UserStats[];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getUserStats();
  }

  getUserStats() {
    this.userService
      .getUserStats()
      .subscribe(userStats => (this.userStats = userStats));
  }
}
