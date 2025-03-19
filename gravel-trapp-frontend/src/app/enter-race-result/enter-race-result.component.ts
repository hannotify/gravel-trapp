import {Component} from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatOption, MatSelect} from '@angular/material/select';
import {RaceService} from '../race.service';
import {DriverService} from '../driver.service';
import {MatInput} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {MatButton} from '@angular/material/button';
import {RaceResultService} from '../race-result.service';
import {RaceResult} from '../race-result.service';
import {MatCheckbox} from '@angular/material/checkbox';

@Component({
  selector: 'app-enter-race-result',
  imports: [
    MatToolbar,
    MatFormField,
    MatSelect,
    MatOption,
    MatLabel,
    MatInput,
    FormsModule,
    MatButton,
    MatOption,
    MatCheckbox
  ],
  templateUrl: './enter-race-result.component.html',
  styleUrl: './enter-race-result.component.css'
})
export class EnterRaceResultComponent {
  races: Race[] = [];
  drivers: Driver[] = [];
  raceResult: RaceResult = { raceId: '', driverId: '', position: 0, fastestLap: false };

  constructor(private raceService: RaceService, private driverService: DriverService, private raceResultService: RaceResultService) {
    this.raceService.getRaces().subscribe((response) => this.races = response);
    this.driverService.getDrivers().subscribe((response) => this.drivers = response);
  }

  changeRace(value: string) {
    this.raceResult.raceId = value;
  }

  changeDriver(value: string) {
    this.raceResult.driverId = value;
  }

  changePosition(event: any) {
    this.raceResult.position = event.target.value;
  }

  changeFastestLap(checked: boolean) {
    this.raceResult.fastestLap = checked;
  }

  isFormValid() {
    return this.raceResult.raceId && this.raceResult.driverId && this.raceResult.position
      && this.raceResult.position > 0 && this.raceResult.position <= this.drivers.length;
  }

  submitRaceResult() {
    console.log(this.raceResult);
    this.raceResultService.postRaceResult(this.raceResult).subscribe(() => {
      console.log("POST request sent")
    });
  }

}

interface Race {
  id: string;
  name: string;
  raceYear: number;
}

interface Driver {
  id: string;
  name: string;
  teamName: string;
}
