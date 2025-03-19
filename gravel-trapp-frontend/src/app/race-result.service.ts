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
          'Authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwODAvZ3JhdmVsLXRyYXBwIiwic3ViIjoiZ3JhdmVsLXRyYXBwIiwidXBuIjoiam9lcCIsInVzZXJuYW1lIjoiam9lcCIsImdyb3VwcyI6WyJhZG1pbiJdLCJpYXQiOjE3NDIzODEwODUsImV4cCI6MTc0MjM4Mjg4NSwianRpIjoiNmJkYWVjNTEtMjQ4YS00MTU0LWFlYjEtZmNjZWUxOTYxOWFiIn0.Z5h6kRjtaufq_Av-vakTKUlv4rshIAntMDaRgZD7GRCH66PyZ4sNQZ3lOh_6QOG7yS8f6R41SLQFsdezWm2IGfiwQtg9IrRAAgYmITTvEfTgJccAb1Jn09hk4uVINza0eNJ4ODQzm93UlvwszI5pdUCXUlAxV9YZ35Ve1U-H9RHscGYH8Iev4wBLHt7oowuuu5gvuxVTCZVzBsMnVpeil-rqbqKYxuMF1euZpbjjZ7Z9g00Xx7VKYNx4_FTI26blMiH5MnLzf2EeILRIP7NOaUuO105BTu7v-dcWRIIVzleksT5uYuovZ5TP3d1yJDo5BRlnMFXCnlgPurp-fINl1w'
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
