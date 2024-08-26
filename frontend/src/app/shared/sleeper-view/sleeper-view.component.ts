import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sleeper-view',
  templateUrl: './sleeper-view.component.html',
  styleUrl: './sleeper-view.component.scss'
})
export class SleeperViewComponent {

  @Input() seatType;
  @Input() purpose;
  ngOnInit(){

  }
}
