import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusShortViewComponent } from './shared/bus-short-view/bus-short-view.component';
import { BusListPageComponent } from './bus-list-page/bus-list-page.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SelectSeatsComponent } from './select-seats/select-seats.component';

const routes: Routes = [
  {path:'', pathMatch:'full', component:LandingPageComponent},
  {path:'busses-list', component: BusListPageComponent},
  {path:'seat-selection', component:SelectSeatsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
