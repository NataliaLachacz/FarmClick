import { Component, OnInit } from '@angular/core';
import { CounterService } from 'src/app/services/counter.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {
  constructor(private counterService: CounterService) {}
  ngOnInit() {}
}
