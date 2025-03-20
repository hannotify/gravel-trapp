import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RaceResultService {
  private apiUrl = 'http://localhost:9080/gravel-trapp/api/race-results';

  constructor(private http: HttpClient) { }

  postRaceResult(raceResult: RaceResult): Observable<any> {
    return this.http.post(
      this.apiUrl,
      raceResult, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + localStorage.getItem('gravel-trapp-jwt')
        }
      });
  }
}

export interface RaceResult {
  raceId: string;
  driverId: string;
  position: number;
  fastestLap: boolean;
}
