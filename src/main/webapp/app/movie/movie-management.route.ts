import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Routes} from '@angular/router';
import {Observable, of} from 'rxjs';

import {MovieManagementComponent} from "./list/movie-management.component";
import {MovieService} from "./service/movie.service";
import {IMovie} from "./movie-management.model";

@Injectable({providedIn: 'root'})
export class MovieResolve implements Resolve<IMovie> {
  constructor(private service: MovieService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<IMovie> {
      return of();
  }
}

export const movieRoute: Routes = [
  {
    path: '',
    component: MovieManagementComponent,
  },
];
