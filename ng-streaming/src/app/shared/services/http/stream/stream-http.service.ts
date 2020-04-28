import { Injectable } from '@angular/core';
import {HttpService} from '../base/http.service';
import {HttpClient} from '@angular/common/http';
import {API_STREAM_URL} from '../../../constants/constant';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class StreamHttpService extends HttpService {

  constructor(public httpClient: HttpClient,
              public router: Router) {
    super(httpClient, API_STREAM_URL, router);
  }


  public getEvent<T>() {
    const source = new EventSource(this.url);
    let data;
    source.onmessage = ev => {
      data = ev.data;
    };
    console.log(data);
  }
}
