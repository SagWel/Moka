import { DecimalPipe } from '@angular/common';
import { Component, output, signal } from '@angular/core';
import { LucideDynamicIcon } from '@lucide/angular';

interface Cards {
  categoryName: string,
  plannedAmount: number,
  actualAmount: number,
}

@Component({
  selector: 'app-category-budget-tables',
  imports: [LucideDynamicIcon, DecimalPipe],
  templateUrl: './category-budget-tables.html',
  styleUrl: './category-budget-tables.css',
})
export class CategoryBudgetTables {
  openAddExpense = output<void>();

  onAddExpenseClick(): void {
    this.openAddExpense.emit();
  };

  openAddIncome = output<void>();

  onAddIncomeClick(): void {
    this.openAddIncome.emit();
  };

  openEditExpense = output<void>();

  onEditExpenseClick(): void {
    this.openEditExpense.emit();
  };

  openEditIncome = output<void>();

  onEditIncomeClick(): void {
    this.openEditIncome.emit()
  }

  expenses = signal<Cards[] | []>([]);

  incomes = signal<Cards[] | []>([]);
}
