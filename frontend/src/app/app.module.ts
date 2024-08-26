import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SourceDestFieldsComponent } from './source-dest-fields/source-dest-fields.component';
import { FilterChipDesignComponent } from './filter-chip-design/filter-chip-design.component';
import { BusListPageComponent } from './bus-list-page/bus-list-page.component';
import { BusShortViewComponent } from './shared/bus-short-view/bus-short-view.component';
import { SleeperViewComponent } from './shared/sleeper-view/sleeper-view.component';
import { SittingViewComponent } from './shared/sitting-view/sitting-view.component';
import { SelectSeatsComponent } from './select-seats/select-seats.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { PassengerFormComponent } from './shared/passenger-form/passenger-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SourceDestFieldsComponent,
    FilterChipDesignComponent,
    BusListPageComponent,
    BusShortViewComponent,
    SleeperViewComponent,
    SittingViewComponent,
    SelectSeatsComponent,
    LandingPageComponent,
    PassengerFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
