import { Component } from '@angular/core';

import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent {
  faArrowLeft = faArrowLeft;

  constructor() { }
}
