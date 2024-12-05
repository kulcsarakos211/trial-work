import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-user-list',
  imports: [NgFor],
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {
    this.users = [];
  }

  ngOnInit() {
    this.userService.findAll().subscribe((data: any) => {
      this.users = data;
    });
  }
}
