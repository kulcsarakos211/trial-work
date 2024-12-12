import { Component } from '@angular/core';
import { User } from '../../models/user/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/user-service/user.service';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';

@Component({
  selector: 'app-user-form',
  standalone: false,
  
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})
export class UserFormComponent {

  user: User;

  constructor(private navbarSerice: NavbarService, private router: Router, private userService: UserService) {
    this.user = new User();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

  ngOnInit() {
    this.navbarSerice.show();
  }

}
