import { Component, OnInit, OnDestroy } from '@angular/core';
import { fromEvent, Observable, Subject, pipe } from 'rxjs';
import { takeUntil } from 'rxjs/operators'
import {SignalStatusService} from '../service/signal-status-service.service'

@Component({
  selector: 'app-traffic-signal',
  templateUrl: './traffic-signal.component.html',
  styleUrls: ['./traffic-signal.component.scss']
})

export class TrafficSignalComponent implements OnInit, OnDestroy {
  destroy$: Subject<void> = new Subject<void>();
  public sourceStream: EventSource;
  public lightState: string;
  public API_VALUE = './api';
  public EVENT_TYPE = 'signal-status-stream';

  constructor(private statusService: SignalStatusService) { }

  ngOnInit() {
    this.sourceStream = this.statusService.getEventSource(this.API_VALUE);
    this.statusService.getRecentStatus(this.sourceStream, this.EVENT_TYPE)
        .pipe(takeUntil(this.destroy$))
        .subscribe((value: MessageEvent) => {
          this.lightState = value.data;
        });
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
