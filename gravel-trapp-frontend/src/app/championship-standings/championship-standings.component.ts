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
  displayedColumns = ['position', 'driverName', 'team', 'points'];
  dataSource = STANDINGS;
}

export interface StandingsEntry {
  position: number;
  driverName: string;
  team: string;
  points: number;
}

const STANDINGS: StandingsEntry[] = [
  { position: 1, driverName: 'Driver A', team: 'Team X', points: 100 },
  { position: 2, driverName: 'Driver B', team: 'Team Y', points: 90 },
  { position: 3, driverName: 'Driver C', team: 'Team Z', points: 80 }
];
