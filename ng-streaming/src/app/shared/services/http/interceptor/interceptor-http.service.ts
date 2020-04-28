import { Injectable } from '@angular/core';
import {environment} from '../../../../../environments/environment';
import {HttpEvent, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InterceptorHttpService {

  constructor() { }

  static remapUrl(url: string): string {
    if (!environment.useDevProxy) {
      if (url.startsWith('/api', 0)) {
        return environment.SERVER_URL.concat(url);
      }
    }
    return url;
  }

  public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const url = InterceptorHttpService.remapUrl(req.url);
    const cloned = req.clone({
        url
      });
    return next.handle(cloned);
  }
}
