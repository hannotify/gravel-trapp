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
          'Authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwODAvZ3JhdmVsLXRyYXBwIiwic3ViIjoiZ3JhdmVsLXRyYXBwIiwidXBuIjoiam9lcCIsInVzZXJuYW1lIjoiam9lcCIsImdyb3VwcyI6WyJhZG1pbiJdLCJpYXQiOjE3NDIzNzUxNTEsImV4cCI6MTc0MjM3Njk1MSwianRpIjoiNjdiZmQzYjMtZjM4OS00MTNmLTk0YWUtNjk5MmI2NzU0OWUzIn0.lv4gu09H_gl3APhYApLBA5kOhp7WdV_V3Z-mOaZnuFuWPNd7jBDwXC417zxXf7uFudIuat6-lOSXqsvhgzTqOOvxkS0bWYkIQwOd1-n_nKkUq0lO2mO6rqJ0EU26BypnW_IyjQXEqArfB2IASWZR6eq10Nlcff1A_ZKRnJ6d2FKaUx1H6K4uwud5gXRM5i4k5nWp0QmKIR7QrP7OhncfU-oBPzurTKYwIUYNbq90QrYplCfiN5oU_YkwF_mAFLzlQQw2p-KhRMGE-awoMmmZwXHAoa3csSzahSEsI-heKoC4FpoHkzpAtG2wlUoKnGN49e9k9Q5SAPqKGTWOJZBBBw'
        }
      });
  }
}

export interface RaceResult {
  raceId: string;
  driverId: string;
  position: number;
}
