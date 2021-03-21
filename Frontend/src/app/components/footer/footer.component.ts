import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { faCog } from '@fortawesome/free-solid-svg-icons';

import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnDestroy{
  faCog = faCog;

  clicks: number;
  subscription: Subscription;

  constructor(private sharedService: SharedService) {
    this.subscription = this.sharedService.clicks$.subscribe((clicks: number): void => {
      this.clicks = clicks;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
