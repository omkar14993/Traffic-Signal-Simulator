import { Injectable } from '@angular/core';
import { Observable, fromEvent, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignalStatusService {
  constructor(){}

  public getEventSource(url: string) {
    return new EventSource(url);
  }

  public getRecentStatus(stream: EventSource, eventType): Observable<Event> {
    return fromEvent(stream, eventType);
  }
}

