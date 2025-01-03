import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../models/user/user';
import { Room } from '../../models/room/room';
import { Observable } from 'rxjs';
import { Membership } from '../../models/membership/membership';

@Injectable({
  providedIn: 'root'
})
export class MembershipService {

  private membershipsUrl: string;

  constructor(private http: HttpClient) { 
    this.membershipsUrl = "http://localhost:8080/memberships";
  }

  public addUserToRoom(user: User, room: Room): Observable<Membership | null> {
    return this.http.post<Membership | null>(`${this.membershipsUrl}?roomId=${room.id}`, user);
  }
}
