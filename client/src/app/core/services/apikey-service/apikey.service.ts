import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Apikey } from '../../models/apikey/apikey';

@Injectable({
  providedIn: 'root'
})
export class ApikeyService {

  private apikeyUrl: string;

  constructor(private http: HttpClient) { 
    this.apikeyUrl = 'http://localhost:8080/apikey';
  }

  public getApikey(): Observable<Apikey | null> {
    return this.http.get<Apikey | null>(this.apikeyUrl);
  }
}
