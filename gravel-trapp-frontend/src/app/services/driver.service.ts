import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  private apiUrl = 'http://localhost:9080/gravel-trapp/api/drivers';

  constructor(private http: HttpClient) { }

  getDrivers(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
