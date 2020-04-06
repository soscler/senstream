import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Constant} from '../constants/constant';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public getById<T>(id: number): Observable<T> {
    return this.httpClient.get<T>(this.url.concat(`/${id}`))
      .pipe(
        catchError(this.handleError<T>(`getById`, null))
      );
  }

  public getEvent<T>(endpoint: string) {
    const source = new EventSource(this.url.concat(`/${endpoint}`));
    let data;
    source.onmessage = ev => {
      data = ev.data;
    };
    console.log(data);
  }

  handleError<T>(operation = 'operation', result?: T ) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
