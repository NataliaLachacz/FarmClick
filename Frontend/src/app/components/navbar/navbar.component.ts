import { Component, OnInit } from '@angular/core';
import { faShoppingBasket } from '@fortawesome/free-solid-svg-icons';
import { CounterService } from 'src/app/services/counter.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  faShoppingBasket = faShoppingBasket;

  constructor(private counterService: CounterService) {}

  ngOnInit() {}
}
