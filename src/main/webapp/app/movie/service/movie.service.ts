import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

import {ApplicationConfigService} from 'app/core/config/application-config.service';
import {IMovie} from "../movie-management.model";

@Injectable({providedIn: 'root'})
export class MovieService {
  private resourceUrl = this.applicationConfigService.getEndpointFor('api/movies');

  constructor(private http: HttpClient, private applicationConfigService: ApplicationConfigService) {
  }

  list(): Observable<HttpResponse<IMovie[]>> {
    return this.http.get<IMovie[]>(this.resourceUrl, {params: {}, observe: 'response'});
  }
}
