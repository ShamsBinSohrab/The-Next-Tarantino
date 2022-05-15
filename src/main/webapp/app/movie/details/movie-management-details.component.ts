import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MovieDetails} from "../movie-management.model";

@Component({
    selector: 'jhi-movie-management-details',
    templateUrl: './movie-management-details.component.html'
})
export class MovieManagementDetailsComponent implements OnInit {
    details!: MovieDetails | null;

    constructor(private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.data.subscribe(({details}) => {
            this.details = details;
        });
    }

}
