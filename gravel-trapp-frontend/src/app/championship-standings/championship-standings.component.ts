import { Component } from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable
} from '@angular/material/table';
import {MatToolbar} from '@angular/material/toolbar';
import {StandingsService} from '../standings.service';

@Component({
  selector: 'app-championship-standings',
  imports: [
    MatTable,
    MatHeaderCell,
    MatCell,
    MatHeaderCellDef,
    MatCellDef,
    MatColumnDef,
    MatHeaderRow,
    MatRow,
    MatHeaderRowDef,
    MatRowDef,
    MatToolbar
  ],
  templateUrl: './championship-standings.component.html',
  styleUrl: './championship-standings.component.css'
})
export class ChampionshipStandingsComponent {
  displayedColumns = ['position', 'driverName', 'teamName', 'points'];
  dataSource: StandingsEntry[] = [];

  constructor(private standingsService: StandingsService) {
    this.standingsService.getStandings().subscribe((response) => this.dataSource = response);
  }
}

export interface StandingsEntry {
  position: number;
  driverName: string;
  teamName: string;
  points: number;
}

