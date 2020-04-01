import { Component, OnInit, Input } from '@angular/core';
import { faCog } from '@fortawesome/free-solid-svg-icons';
import { UserService } from '../../services/user.service';
import { UserStats } from '../../models/userStats.model';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  faCog = faCog;
  userStats: UserStats[];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getUserStats();
  }

  getUserStats() {
    this.userService
      .getUserStats()
      .subscribe(userStats => (this.userStats = userStats));
  }
}
