import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Routes} from '@angular/router';
import {Observable, of} from 'rxjs';

import {MovieManagementComponent} from "./list/movie-management.component";
import {MovieService} from "./service/movie.service";
import {IMovieDetails, MovieDetails} from "./movie-management.model";
import {MovieManagementDetailsComponent} from "./details/movie-management-details.component";

@Injectable({providedIn: 'root'})
export class MovieDetailsResolve implements Resolve<IMovieDetails> {
    constructor(private service: MovieService) {
    }

    resolve(route: ActivatedRouteSnapshot): Observable<IMovieDetails> {
        const id = route.params['imdbId'];
        if (id) {
            return this.service.details(id);
        }
        return of(new MovieDetails());
    }
}

export const movieRoute: Routes = [
    {
        path: '',
        component: MovieManagementComponent,
    },
    {
        path: ':imdbId/view',
        component: MovieManagementDetailsComponent,
        resolve: {
            details: MovieDetailsResolve,
        }
    },
];
