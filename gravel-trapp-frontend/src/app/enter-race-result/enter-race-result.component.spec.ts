import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterRaceResultComponent } from './enter-race-result.component';

describe('EnterRaceResultComponent', () => {
  let component: EnterRaceResultComponent;
  let fixture: ComponentFixture<EnterRaceResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnterRaceResultComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnterRaceResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
