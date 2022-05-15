import {Component, OnInit} from '@angular/core';
import {MovieReview} from "../movie-management.model";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
    selector: 'jhi-movie-management-review',
    templateUrl: './movie-management-review.component.html'
})
export class MovieManagementReviewComponent implements OnInit {
    review!: MovieReview | null;
    reviewForm = this.fb.group({
        id: [],
        review: ['', [Validators.maxLength(50)]],
    });

    constructor(private route: ActivatedRoute, private fb: FormBuilder) {
    }

    ngOnInit(): void {
        this.route.data.subscribe(({review}) => {
            this.review = review;
            console.error(review);
            this.updateForm(review);
        });
    }

    addReview(): void {
        console.error("HERE")
    }

    previousState(): void {
        window.history.back();
    }

    private updateForm(review: MovieReview): void {
        this.reviewForm.patchValue({
            id: review.id,
            review: review.review,
        });
    }
}
