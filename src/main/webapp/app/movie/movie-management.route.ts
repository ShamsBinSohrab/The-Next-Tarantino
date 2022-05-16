import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Routes} from '@angular/router';
import {Observable} from 'rxjs';

import {MovieManagementComponent} from "./list/movie-management.component";
import {MovieService} from "./service/movie.service";
import {IMovieDetails, IMovieReview} from "./movie-management.model";
import {MovieManagementDetailsComponent} from "./details/movie-management-details.component";
import {MovieManagementReviewComponent} from "./review/movie-management-review.component";
import {UserRouteAccessService} from "../core/auth/user-route-access.service";

@Injectable({providedIn: 'root'})
export class MovieDetailsResolve implements Resolve<IMovieDetails> {
  constructor(private service: MovieService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<IMovieDetails> {
    const id = route.params['imdbId'];
    return this.service.details(id);
  }
}

@Injectable({providedIn: 'root'})
export class MovieReviewResolve implements Resolve<IMovieReview> {
  constructor(private service: MovieService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<IMovieReview> {
    const id = route.params['id'];
    return this.service.getReview(id);
  }
}

export const movieRoute: Routes = [
  {
    path: '',
    component: MovieManagementComponent,
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':imdbId/view',
    component: MovieManagementDetailsComponent,
    resolve: {
      details: MovieDetailsResolve,
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/review',
    component: MovieManagementReviewComponent,
    resolve: {
      review: MovieReviewResolve,
    },
    canActivate: [UserRouteAccessService]
  },
];
