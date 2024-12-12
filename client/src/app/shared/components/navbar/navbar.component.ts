import { Component } from '@angular/core';
import { NavbarService } from '../../services/navbar-service/navbar.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: false,
  
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(public navbarService: NavbarService, private router: Router) {
  }

  gotoHome() {
    this.router.navigate(["/home"]);
  }

  gotoRooms() {
    this.router.navigate(["/rooms"]);
  }

  gotoLogout() {
    this.router.navigate(["/logout"]);
  }

  gotoMessages() {
    this.router.navigate(["/messages"]);
  }

  createUser() {
    this.router.navigate(["/register"]);
  }

  logout() {
    localStorage.clear();
    this.router.navigate([""]);
  }
}
