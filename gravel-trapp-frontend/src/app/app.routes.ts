import { Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ChampionshipStandingsComponent} from './championship-standings/championship-standings.component';
import {AboutComponent} from './about/about.component';
import {EnterRaceResultComponent} from './enter-race-result/enter-race-result.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, title: 'Home' },
  { path: 'championship-standings', component: ChampionshipStandingsComponent, title: 'Championship Standings' },
  { path: 'enter-race-result', component: EnterRaceResultComponent, title: 'Enter Race Result' },
  { path: 'about', component: AboutComponent, title: 'About' }
];
