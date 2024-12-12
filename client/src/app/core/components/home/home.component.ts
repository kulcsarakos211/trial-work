import { Component } from '@angular/core';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';

@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  username: string;

  constructor(private navbarService: NavbarService) {
    this.username = localStorage.getItem("username")!;
  }

  ngOnInit() {
    this.navbarService.show();
  }

}
