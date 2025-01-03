import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Room } from '../../models/room/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private roomsUrl: string;

  constructor(private http: HttpClient) {
    this.roomsUrl = 'http://localhost:8080/rooms';
  }

  public findAll(): Observable<Room[]> {
    return this.http.get<Room[]>(this.roomsUrl);
  }

  public findById(id: number): Observable<Room | null> {
    return this.http.get<Room | null>(`${this.roomsUrl}?id=${id}`);
  }

  public findAllByUserId(userId: number): Observable<Room[]> {
    return this.http.get<Room[]>(`${this.roomsUrl}?userId=${userId}`);
  }
}
