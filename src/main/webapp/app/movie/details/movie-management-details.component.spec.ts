import {ComponentFixture, TestBed} from '@angular/core/testing';

import {MovieManagementDetailsComponent} from './movie-management-details.component';

describe('MovieManagementDetailsComponent', () => {
    let component: MovieManagementDetailsComponent;
    let fixture: ComponentFixture<MovieManagementDetailsComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [MovieManagementDetailsComponent]
        })
        .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(MovieManagementDetailsComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
