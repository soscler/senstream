import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export abstract class HttpService {

  protected constructor(public httpClient: HttpClient, public url: string,
                        public router: Router) {
  }

  public getById<T>(id: number | string): Observable<T> {
    return this.httpClient.get<T>(this.url.concat(`/${id}`))
      .pipe(
        catchError(this.handleError<T>(`getById`, null))
      );
  }

  handleError<T>(operation = 'operation', result?: T ) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
