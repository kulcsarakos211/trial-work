import { Component } from '@angular/core';
import { RoomService } from '../../../services/room-service/room.service';
import { NavbarService } from '../../../../shared/services/navbar-service/navbar.service';
import { Room } from '../../../models/room/room';

@Component({
  selector: 'app-room-list',
  standalone: false,
  
  templateUrl: './room-list.component.html',
  styleUrl: './room-list.component.css'
})
export class RoomListComponent {

  rooms: Room[];

  constructor(private roomService: RoomService, private navbarService: NavbarService) {
    this.rooms = [];
  }

  ngOnInit() {
    this.roomService.findAllByUserId(Number(localStorage.getItem("id"))).subscribe(rooms => {
      this.rooms = rooms;
    });
    this.navbarService.show();
  }
}
