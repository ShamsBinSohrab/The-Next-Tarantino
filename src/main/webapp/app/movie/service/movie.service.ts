import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

import {ApplicationConfigService} from 'app/core/config/application-config.service';
import {IMovie, IMovieDetails} from "../movie-management.model";

@Injectable({providedIn: 'root'})
export class MovieService {
    private resourceUrl = this.applicationConfigService.getEndpointFor('api/movies');

    constructor(private http: HttpClient, private applicationConfigService: ApplicationConfigService) {
    }

    list(): Observable<HttpResponse<IMovie[]>> {
        return this.http.get<IMovie[]>(this.resourceUrl, {params: {}, observe: 'response'});
    }

    listOfWatchedMovies(): Observable<HttpResponse<IMovie[]>> {
        return this.http.get<IMovie[]>(this.resourceUrl, {
            params: {watched: true},
            observe: 'response'
        });
    }

    listOfFavouriteMovies(): Observable<HttpResponse<IMovie[]>> {
        return this.http.get<IMovie[]>(this.resourceUrl, {
            params: {watched: false, favourite: true},
            observe: 'response'
        });
    }

    update(movie: IMovie): Observable<IMovie> {
        return this.http.patch<IMovie>(`${this.resourceUrl}/${movie.id}`, movie);
    }

    details(imdbId: string): Observable<IMovieDetails> {
        return this.http.get<IMovieDetails>(`${this.resourceUrl}/${imdbId}`);
    }
}
