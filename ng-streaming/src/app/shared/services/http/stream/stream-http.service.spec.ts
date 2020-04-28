import { TestBed } from '@angular/core/testing';

import { StreamHttpService } from './stream-http.service';

describe('StreamHttpService', () => {
  let service: StreamHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StreamHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
