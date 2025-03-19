import {Component} from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatOption, MatSelect} from '@angular/material/select';
import {RaceService} from '../race.service';
import {DriverService} from '../driver.service';
import {MatInput} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {MatButton} from '@angular/material/button';

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
    MatOption
  ],
  templateUrl: './enter-race-result.component.html',
  styleUrl: './enter-race-result.component.css'
})
export class EnterRaceResultComponent {
  races: Race[] = [];
  drivers: Driver[] = [];

  selectedRaceId: string = '';
  selectedDriverId: string = '';
  selectedPosition: number = 0;

  constructor(private raceService: RaceService, private driverService: DriverService) {
    this.raceService.getRaces().subscribe((response) => this.races = response);
    this.driverService.getDrivers().subscribe((response) => this.drivers = response);
  }

  changeRace(value: string) {
    this.selectedRaceId = value;
  }

  changeDriver(value: string) {
    this.selectedDriverId = value;
  }

  changePosition(event: any) {
    this.selectedPosition = event.target.value;
  }

  submitRaceResult() {
    console.log(this.selectedRaceId, this.selectedDriverId, this.selectedPosition);
  }

  isFormValid() {
    return this.selectedRaceId && this.selectedDriverId && this.selectedPosition
      && this.selectedPosition > 0 && this.selectedPosition <= this.drivers.length;
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
