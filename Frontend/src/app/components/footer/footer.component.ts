import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { faCog } from '@fortawesome/free-solid-svg-icons';

import { SharedService } from 'src/app/_shared/services/shared.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnDestroy{
  faCog = faCog;
  clicks: number;
  private _subscription: Subscription = new Subscription();

  constructor(private readonly _sharedService: SharedService) {
    this._subscription.add(this._sharedService.clicks$.subscribe((clicks: number): void => {
      this.clicks = clicks;
    }));
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
