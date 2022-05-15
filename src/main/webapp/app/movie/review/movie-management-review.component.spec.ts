import {ComponentFixture, TestBed} from '@angular/core/testing';

import {MovieManagementReviewComponent} from './movie-management-review.component';

describe('MovieManagementReviewComponent', () => {
    let component: MovieManagementReviewComponent;
    let fixture: ComponentFixture<MovieManagementReviewComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [MovieManagementReviewComponent]
        })
        .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(MovieManagementReviewComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
