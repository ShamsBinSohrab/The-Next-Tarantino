import {Component, OnInit} from '@angular/core';
import {MovieReview} from "../movie-management.model";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {MovieService} from "../service/movie.service";

@Component({
    selector: 'jhi-movie-management-review',
    templateUrl: './movie-management-review.component.html'
})
export class MovieManagementReviewComponent implements OnInit {
    review!: MovieReview;
    reviewForm = this.fb.group({
        id: [],
        movieId: [],
        review: ['', [Validators.maxLength(50)]],
    });

    constructor(private route: ActivatedRoute, private fb: FormBuilder, private movieService: MovieService) {
    }

    ngOnInit(): void {
        this.route.data.subscribe(({review}) => {
            this.review = review;
            this.updateForm(review);
        });
    }

    submit(): void {
        this.review.review = this.reviewForm.get(['review'])?.value;
        if (this.review.id) {
            this.movieService.updateReview(this.review.movieId, this.review).subscribe((review) => this.updateForm(review));
        } else {
            this.movieService.addReview(this.route.snapshot.params['id'], this.review).subscribe((review) => this.updateForm(review));
        }
    }

    previousState(): void {
        window.history.back();
    }

    private updateForm(review: MovieReview): void {
        this.reviewForm.patchValue({
            id: review.id,
            review: review.review,
            movieId: review.movieId,
        });
    }
}
