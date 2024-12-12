import { Component } from '@angular/core';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';
import { User } from '../../models/user/user';
import { LoginService } from '../../services/login-service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  user: User;
  badCredentials: boolean;

  constructor(private navbarService: NavbarService, private loginService: LoginService, private router: Router) {
    this.user = new User();
    this.badCredentials = false;
  }

  ngOnInit() {
    this.navbarService.hide();
  }

  async onSubmit() {
    let loginSuccessful = false;
    await this.loginService.login(this.user).forEach((user) => {
      if (user === null) {
        this.badCredentials = true;
      }
      else {
        localStorage.setItem('id', user.id.toString());
        localStorage.setItem('firstLogin', String(user.firstLogin));
        localStorage.setItem('admin', String(user.admin));
        localStorage.setItem('username', user.username);
        loginSuccessful = true;
        if (user.firstLogin) {
          this.gotoFirstLogin();
        }
        else {
          this.gotoHome();
        }
      }
    });
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }

  gotoFirstLogin() {
    this.router.navigate(['/first-login']);
  }
}
