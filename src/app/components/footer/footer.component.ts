import { Component, OnInit } from '@angular/core';
import { faCog } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { Counter } from './../../store/models/counter.model';
import { AppState } from './../../store/app.state';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  faCog = faCog;
  counter: Observable<Counter[]>;

  constructor(private store: Store<AppState>) {
    this.counter = store.select('counter');
  }

  ngOnInit() {}
}
