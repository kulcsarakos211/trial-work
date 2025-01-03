import { Component } from '@angular/core';
import { UserService } from '../../services/user-service/user.service';
import { NavbarService } from '../../../shared/services/navbar-service/navbar.service';
import { Router } from '@angular/router';
import { User } from '../../models/user/user';
import { MembershipService } from '../../services/membership-service/membership.service';
import { Room } from '../../models/room/room';

@Component({
  selector: 'app-create-user',
  standalone: false,
  
  templateUrl: './create-user.component.html',
  styleUrl: './create-user.component.css'
})
export class CreateUserComponent {

  userExists: boolean;
  user: User;
  defaultRoom: Room;

  constructor(private userService: UserService, private membershipService: MembershipService, private navbarService: NavbarService, private router: Router) {
    this.userExists = false;
    this.user = new User();
    this.defaultRoom = new Room();
    this.defaultRoom.id = 1;
  }

  async onSubmit() {
    let existingUser: User | null = null;
    await this.userService.findByEmail(this.user.email).forEach(user => {
      existingUser = user;
      if (existingUser === null) {
        this.user.password = "secretpassword";
        this.userService.save(this.user).subscribe(user => this.membershipService.addUserToRoom(user!, this.defaultRoom).subscribe());
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
