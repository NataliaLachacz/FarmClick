import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

// import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';

@Component({
    selector: 'app-settings',
    templateUrl: './settings.component.html',
    styleUrls: ['./settings.component.scss'],
    standalone: true,
    imports: [RouterLink]
})
export class SettingsComponent {
  // faArrowLeft = faArrowLeft;

  constructor() { }
}
