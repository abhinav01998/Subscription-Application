import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Subscription { // Defining the interface to match the java Entity
  id?: string;
  serviceName: string;
  price: number;
  currency: string;
  paymentPeriod: number;
  nextRenewalDate: number;
}

@Injectable({
  providedIn: 'root',
})
export class Subscription {
  private apiUrl = 'http://localhost:8080/api/subscriptions';

  constructor(private http: HttpClient) { }

  getSubscriptions(): Observable<Subscription[]> {
    return this.http.get<Subscription[]>(this.apiUrl);
  }
  addSubscription(sub: Subscription): Observable<Subscription> {
    return this.http.post<Subscription>(this.apiUrl, JSON.stringify(sub));
  }
}
