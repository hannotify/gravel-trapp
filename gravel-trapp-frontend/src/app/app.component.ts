import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NavigationComponent} from './navigation/navigation.component';
import {MatCard, MatCardContent} from '@angular/material/card';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavigationComponent, MatCard, MatCardContent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
