import { TestBed } from '@angular/core/testing';

import { RaceResultService } from './race-result.service';

describe('RaceResultService', () => {
  let service: RaceResultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RaceResultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
