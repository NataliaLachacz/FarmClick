import { Component } from '@angular/core';
import { SharedService } from 'src/app/_shared/services/shared.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [SharedService]
})
export class HomeComponent {

  constructor() { }
}
