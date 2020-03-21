import { Component, OnInit } from "@angular/core";
import { faShoppingBasket } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"]
})
export class NavbarComponent implements OnInit {
  faShoppingBasket = faShoppingBasket;

  constructor() {}

  ngOnInit() {}
}
