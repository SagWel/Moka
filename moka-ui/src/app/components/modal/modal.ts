import { Component, input, output } from '@angular/core';
import { LucideDynamicIcon } from '@lucide/angular';

@Component({
  selector: 'app-modal',
  imports: [LucideDynamicIcon],
  templateUrl: './modal.html',
  styleUrl: './modal.css',
})
export class Modal {

  title = input.required<string>();

  close = output<void>();

  onClose(): void {
    this.close.emit();
  };
}
