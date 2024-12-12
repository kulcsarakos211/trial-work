import { Component } from '@angular/core';
import { UserService } from '../../services/user-service/user.service';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';
import { Router } from '@angular/router';
import { User } from '../../models/user/user';

@Component({
  selector: 'app-create-user',
  standalone: false,
  
  templateUrl: './create-user.component.html',
  styleUrl: './create-user.component.css'
})
export class CreateUserComponent {

  userExists: boolean;
  user: User;

  constructor(private userService: UserService, private navbarService: NavbarService, private router: Router) {
    this.userExists = false;
    this.user = new User();
  }

  async onSubmit() {
    let existingUser: User | null = null;
    await this.userService.findByEmail(this.user.email).forEach(user => {
      existingUser = user;
      if (existingUser === null) {
        this.user.password = "secretpassword";
        this.userService.save(this.user).subscribe();
        alert("New user registered!");
        this.gotoHome();
      }
      else {
        this.userExists = true;
      }
    });
  }

  ngOnInit() {
    this.navbarService.show();
  }

  gotoHome() {
    this.router.navigate(["/home"]);
  }
}
