import { Component, signal } from '@angular/core';
import { Months } from '../../models/models';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
    private getCurrentMonthEnum(): Months {
    const monthValues = Object.values(Months);
    const currentMonthIndex = new Date().getMonth();
    return monthValues[currentMonthIndex]
  }

  readonly currentMonth = signal<Months>(this.getCurrentMonthEnum());

  readonly user = signal<string>('U')
}
