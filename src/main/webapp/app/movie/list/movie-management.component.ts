import {Component, OnInit} from '@angular/core';
import {Account} from "../../core/auth/account.model";
import {Movie} from "../movie-management.model";
import {AccountService} from "../../core/auth/account.service";
import {MovieService} from "../service/movie.service";
import {ActivatedRoute} from "@angular/router";
import {HttpResponse} from "@angular/common/http";
import {combineLatest} from "rxjs";

@Component({
    selector: 'jhi-movie-management',
    templateUrl: './movie-management.component.html'
})
export class MovieManagementComponent implements OnInit {
    account!: Account | null;
    movies: Movie[] | null = null;
    watchedMovies: Movie[] | null = null;
    favouriteMovies: Movie[] | null = null;
    isLoading = false;

    constructor(
        private accountService: AccountService,
        private movieService: MovieService,
        private activatedRoute: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.accountService
        .identity()
        .subscribe(account => this.account = account);
        this.handleNavigation()
    }

    loadAll(): void {
        this.isLoading = true;
        this.movieService
        .listOfWatchedMovies()
        .subscribe({
            next: (res: HttpResponse<Movie[]>) => {
                this.isLoading = false;
                this.watchedMovies = res.body;
            },
            error: () => (this.isLoading = false),
        });
        this.movieService
        .listOfFavouriteMovies()
        .subscribe({
            next: (res: HttpResponse<Movie[]>) => {
                this.isLoading = false;
                this.favouriteMovies = res.body;
            },
            error: () => (this.isLoading = false),
        });
    }

    setWatched(movie: Movie, watched: boolean): void {
        movie.watched = watched;
        this.movieService.update(movie).subscribe(() => this.loadAll());
    }

    setFavourite(movie: Movie, favourite: boolean): void {
        movie.favourite = favourite;
        this.movieService.update(movie).subscribe(() => this.loadAll());
    }

    private handleNavigation(): void {
        combineLatest([this.activatedRoute.data, this.activatedRoute.queryParamMap]).subscribe(([data, params]) => {
            this.loadAll();
        });
    }

    private onSuccess(movies: Movie[] | null): void {
        this.movies = movies;
    }
}
