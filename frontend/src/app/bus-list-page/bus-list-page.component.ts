import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bus-list-page',
  templateUrl: './bus-list-page.component.html',
  styleUrl: './bus-list-page.component.scss'
})
export class BusListPageComponent {
  constructor(private route: Router){}
   filtersArray =[
    {id: 1, title:"Sleeper", active:false},
    {id:2, title:"Seater", active:false},
    {id:3, title:"AC", active:false},
    {id:4, title: "Non AC", active:false}
  ]
  goToSeatSelection(){
    this.route.navigate(['seat-selection'])
  }
}
