import { HttpClient, HttpHeaderResponse, HttpHeaders, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user'
import { Globals } from '../globals';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    let headers = new HttpHeaders();
    headers = headers.append('asd', 'true');
    return this.http.get<User[]>(this.usersUrl, { headers: Globals.SERVICE_HEADERS });
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user, { headers: Globals.SERVICE_HEADERS });
  }
}
