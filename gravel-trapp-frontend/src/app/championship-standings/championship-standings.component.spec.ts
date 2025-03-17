import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampionshipStandingsComponent } from './championship-standings.component';

describe('ChampionshipStandingsComponent', () => {
  let component: ChampionshipStandingsComponent;
  let fixture: ComponentFixture<ChampionshipStandingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChampionshipStandingsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChampionshipStandingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
