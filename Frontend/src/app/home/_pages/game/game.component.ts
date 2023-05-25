import { Component, OnDestroy, OnInit } from "@angular/core";

import { Plant } from "../../../_shared/models/plant.interface";
import { plants } from "src/app/_shared/utils/plants";

import { SharedService } from "src/app/_shared/services/shared.service";
import { Subscription } from "rxjs";

@Component({
    selector: "app-game",
    templateUrl: "./game.component.html",
    styleUrls: ["./game.component.scss"],
    standalone: true
})
export class GameComponent implements OnInit, OnDestroy {
  clicks: number;
  coins: number;
  plantValue: number;
  plants: Plant[];
  private _subscription: Subscription = new Subscription();

  constructor(private readonly _sharedService: SharedService) {}

  ngOnInit(): void {
    this.initVariables();
  }

  getCoins(): void {
    this._subscription.add(
      this._sharedService.coins$.subscribe(
        (coins: number) => (this.coins = coins)
      )
    );
  }

  getClicks(): void {
    this._subscription.add(
      this._sharedService.clicks$.subscribe(
        (clicks: number) => (this.clicks = clicks)
      )
    );
  }

  initVariables(): void {
    this.getCoins();
    this.getClicks();
    this.plants = plants;
    this.plantValue = this.plants[0].value;
  }

  onAddClick(): void {
    let plantElement: HTMLElement = document.querySelector(".plant__crop");
    this.clicks++;
    let modulo: number = this.clicks % 3;
    this._sharedService.addClick(this.clicks);

    switch (modulo) {
      case 0: {
        plantElement.style.display = "none";
        this.coins += this.plantValue;
        this._sharedService.addCoins(this.coins);
        break;
      }
      case 1: {
        plantElement.style.transform = "scale(0.5)";
        plantElement.style.top = "0px";
        plantElement.style.left = "60px";
        plantElement.style.display = "block";
        break;
      }
      case 2: {
        plantElement.style.transform = "scale(1)";
        plantElement.style.top = "-20px";
        plantElement.style.left = "70px";
      }
      default: {
        break;
      }
    }
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
