import { Component } from '@angular/core';
import { SharedService } from 'src/app/_shared/services/shared.service';
import { FooterComponent } from './_components/footer/footer.component';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './_components/navbar/navbar.component';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss'],
    providers: [SharedService],
    standalone: true,
    imports: [NavbarComponent, RouterOutlet, FooterComponent]
})
export class HomeComponent {

  constructor() { }
}
