import { Component, output, signal } from '@angular/core';
import { LucideDynamicIcon } from '@lucide/angular';
import { Project } from '../../models/models';

@Component({
  selector: 'app-project-dashboard',
  imports: [LucideDynamicIcon],
  templateUrl: './project-dashboard.html',
  styleUrl: './project-dashboard.css',
})
export class ProjectDashboard {
  projects = signal<Project[] | []>([]);

  openAddProject = output<void>();

  onAddProjectClick(): void {
    this.openAddProject.emit();
  };

  openEditProject = output<void>();

  onEditProjectClick(): void {
    this.openEditProject.emit();
  };

  openAddAmount = output<void>();

  onAddAmountClick(): void {
    this.openAddProject.emit();
  };

  getProgressPercentage(current: number, target: number): number {
    if (!target || target <= 0) return 0;

    const percentage: number = (current / target) * 100;
    return Math.min(Math.max(percentage, 0), 100);
  }
}
