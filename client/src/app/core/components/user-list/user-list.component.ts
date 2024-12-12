import { Component } from '@angular/core';
import { UserService } from '../../services/user-service/user.service';
import { User } from '../../models/user/user'
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';

@Component({
  selector: 'app-user-list',
  standalone: false,
  
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent {

  users: User[];

  constructor(private userService: UserService, private navbarService: NavbarService) {
    this.users = [];
  }

  ngOnInit() {
    this.navbarService.show();
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

}
