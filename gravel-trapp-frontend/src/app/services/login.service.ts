import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = 'http://localhost:9080/gravel-trapp/api/user/login';

  constructor(private http: HttpClient) { }

  postLogin(user: User): Observable<any> {
    return this.http.post(this.apiUrl, user, { responseType: 'text' });
  }
}

export interface User {
  username: string;
  password: string;
}

