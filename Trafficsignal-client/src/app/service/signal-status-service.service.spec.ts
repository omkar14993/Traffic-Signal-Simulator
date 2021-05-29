import { TestBed } from '@angular/core/testing';

import { SignalStatusService } from './signal-status-service.service';

describe('SignalStatusService', () => {
  let service: SignalStatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignalStatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return EventSource for a given URL', () => {
    const url = "abc.com";
    const mockEventSource = new EventSource(url);
    const eventSource = service.getEventSource(url);
    expect(mockEventSource).toEqual(eventSource);
  });
});
