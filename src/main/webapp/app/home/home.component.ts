import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {combineLatest, Subject} from 'rxjs';

import {AccountService} from 'app/core/auth/account.service';
import {Account} from 'app/core/auth/account.model';
import {Movie} from "../movie/movie.model";
import {HttpResponse} from "@angular/common/http";
import {MovieService} from "../movie/service/movie.service";

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  account!: Account | null;
  movies: Movie[] | null = null;
  isLoading = false;

  private readonly destroy$ = new Subject<void>();

  constructor(
    private accountService: AccountService,
    private movieService: MovieService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
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
      .list()
      .subscribe({
        next: (res: HttpResponse<Movie[]>) => {
          this.isLoading = false;
          this.onSuccess(res.body);
        },
        error: () => (this.isLoading = false),
      });
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  private handleNavigation(): void {
    combineLatest([this.activatedRoute.data, this.activatedRoute.queryParamMap]).subscribe(([data, params]) => {
      this.loadAll();
    });
  }

  private onSuccess(movies: Movie[] | null): void {
    this.movies = movies;
    console.error(movies);
  }
}
