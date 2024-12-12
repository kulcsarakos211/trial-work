import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../models/user/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  private loginUrl: string

  constructor(private http: HttpClient) {
    this.loginUrl = "http://localhost:8080/login";
  }

  public login(user: User): Observable<User | null> {
    return this.http.post<User | null>(this.loginUrl, user);
  }
}
