import { Component, OnInit } from "@angular/core";
import { faCog } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: "app-footer",
  templateUrl: "./footer.component.html",
  styleUrls: ["./footer.component.scss"]
})
export class FooterComponent implements OnInit {
  faCog = faCog;

  constructor() {}

  ngOnInit() {}
}
