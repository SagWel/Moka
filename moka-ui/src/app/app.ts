import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { provideLucideIcons, LucideCirclePlus, LucideCircleChevronLeft, LucideCircleChevronRight } from '@lucide/angular';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
  providers: [
    provideLucideIcons(LucideCirclePlus, LucideCircleChevronLeft, LucideCircleChevronRight)
  ]
})
export class App {
  title = 'Moka';
}
