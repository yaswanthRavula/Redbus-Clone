import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-filter-chip-design',
  templateUrl: './filter-chip-design.component.html',
  styleUrl: './filter-chip-design.component.scss'
})
export class FilterChipDesignComponent {
 @Input() dynamicBgColor='red';
 @Input() dynamicFgColor='white';
 @Input() title;
}
