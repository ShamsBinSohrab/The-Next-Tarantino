import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {SharedModule} from 'app/shared/shared.module';
import {MovieManagementComponent} from "./list/movie-management.component";
import {movieRoute} from "./movie-management.route";
import {MovieManagementDetailsComponent} from './details/movie-management-details.component';
import {MovieManagementReviewComponent} from './review/movie-management-review.component';

@NgModule({
  imports: [SharedModule, RouterModule.forChild(movieRoute)],
  declarations: [
      MovieManagementComponent,
      MovieManagementDetailsComponent,
      MovieManagementReviewComponent
  ],
  entryComponents: [],
})
export class MovieManagementModule {
}
