import { HttpClient, HttpHeaderResponse, HttpHeaders, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../models/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public findByEmail(email: string): Observable<User | null> {
    return this.http.get<User | null>(`${this.usersUrl}?email=${email}`);
  }

  public findByUsername(username: string): Observable<User | null> {
    return this.http.get<User | null>(`${this.usersUrl}?username=${username}`);
  }

  public findById(id: number): Observable<User | null> {
    return this.http.get<User | null>(`${this.usersUrl}?id=${id}`);
  }

  public updateUser(user: User) {
    return this.http.patch<User>(this.usersUrl, user);
  }

  public save(user: User): Observable<User | null> {
    return this.http.post<User | null>(this.usersUrl, user);
  }
}
