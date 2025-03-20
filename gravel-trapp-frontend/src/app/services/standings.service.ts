import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StandingsService {
  private apiUrl = 'http://localhost:9080/gravel-trapp/api/standings';

  constructor(private http: HttpClient) { }

  getStandings(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
