import { Component } from '@angular/core';
import { Room } from '../../../models/room/room';
import { RoomService } from '../../../services/room-service/room.service';
import { NavbarService } from '../../../../shared/services/navbar-service/navbar.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-room',
  standalone: false,
  
  templateUrl: './room.component.html',
  styleUrl: './room.component.css'
})
export class RoomComponent {
   room: Room;
  
    constructor(private roomService: RoomService, private navbarService: NavbarService, private route: ActivatedRoute) {
      this.room = new Room();
    }
  
    ngOnInit() {
      this.roomService.findById(Number(this.route.snapshot.paramMap.get('id'))).subscribe(room => {
        this.room = room!;
      })
      this.navbarService.show();
    }
}
