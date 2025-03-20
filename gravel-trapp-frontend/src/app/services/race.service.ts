import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RaceService {
  private apiUrl = 'http://localhost:9080/gravel-trapp/api/races';

  constructor(private http: HttpClient) { }

  getRaces(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
