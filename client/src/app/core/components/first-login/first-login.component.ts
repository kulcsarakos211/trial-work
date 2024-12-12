import { Component } from '@angular/core';
import { User } from '../../models/user/user';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';
import { UserService } from '../../services/user-service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-first-login',
  standalone: false,
  
  templateUrl: './first-login.component.html',
  styleUrl: './first-login.component.css'
})
export class FirstLoginComponent {

  user: User;
  usernameTaken: boolean;

  constructor(private navbarService: NavbarService, private userService: UserService, private router: Router) {
    this.user = new User();
    this.usernameTaken = false;
  }

  async onSubmit() {
    await this.userService.findByUsername(this.user.username).forEach(async user => {
      if (user === null || user.username === this.user.username) {
        await this.userService.findById(Number(localStorage.getItem("id"))).forEach(existingUser => {
          existingUser!.firstLogin = false;
          existingUser!.password = this.user.password;
          existingUser!.username = this.user.username;
          this.userService.updateUser(existingUser!).subscribe();
          localStorage.setItem("username", this.user.username);
          localStorage.setItem("firstLogin", "false");
          alert("Information updated successfully");
          this.gotoHome();
        });
      }
      else {
        this.usernameTaken = true;
      }
    });
  }

  ngOnInit() {
    this.navbarService.hide();
  }

  gotoHome() {
    this.router.navigate(["/home"]);
  }

}
