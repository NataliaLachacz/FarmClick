import { Component, OnInit, Input } from '@angular/core';
import { faCog } from '@fortawesome/free-solid-svg-icons';
import { CounterService } from '../../services/counter.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  faCog = faCog;

  constructor(private counterService: CounterService) {}

  ngOnInit() {}
}
