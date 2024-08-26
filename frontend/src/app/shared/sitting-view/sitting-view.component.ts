import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sitting-view',
  templateUrl: './sitting-view.component.html',
  styleUrl: './sitting-view.component.scss'
})
export class SittingViewComponent {

  
  @Input() seatType;
  @Input() purpose;
  ngOnInit(){

  }
}
