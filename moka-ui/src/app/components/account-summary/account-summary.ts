import { Component, computed, output, signal } from '@angular/core';
import { LucideDynamicIcon } from '@lucide/angular';
import { Account, Months } from '../../models/models';

interface CategoryShare {
  categoryName: string,
  categoryColor: string,
  plannedAmount: number,
  actualAmount: number
}

@Component({
  selector: 'app-account-summary',
  imports: [LucideDynamicIcon],
  templateUrl: './account-summary.html',
  styleUrl: './account-summary.css',
})
export class AccountSummary {

  readonly OUTER_EXPENSE_R: number = 160;
  readonly INNER_EXPENSE_R: number = 120;

  readonly OUTER_EXPENSE_CIRCUMFERENCE: number = 2 * Math.PI * this.OUTER_EXPENSE_R;
  readonly INNER_EXPENSE_CIRCUMFERENCE: number = 2 * Math.PI * this.INNER_EXPENSE_R;

  private getCurrentMonthEnum(): Months {
    const monthValues = Object.values(Months);
    const currentMonthIndex = new Date().getMonth();
    return monthValues[currentMonthIndex]
  }

  readonly currentMonth = signal<Months>(this.getCurrentMonthEnum());

  protected readonly expenseCategories = signal<CategoryShare[] |[]>([]);

  protected totalExpensePlanned = computed(() => 
    this.expenseCategories().reduce((sum, cat) => sum + cat.plannedAmount, 0)
  );

  protected expenseOuterSlices = computed(() => {
    const total = this.totalExpensePlanned();
    if (total === 0) return [];

    let accumulatedPercentage = 0;
    return this.expenseCategories().map(cat => {
      const percentage = cat.plannedAmount / total;
      const strokeDasharray = `${percentage * this.OUTER_EXPENSE_CIRCUMFERENCE} ${this.OUTER_EXPENSE_CIRCUMFERENCE}`;
      const strokeDashoffset = -accumulatedPercentage * this.OUTER_EXPENSE_CIRCUMFERENCE;

      accumulatedPercentage += percentage;
      return {... cat, strokeDasharray, strokeDashoffset };
    });
  });

  protected expenseInnerSlices = computed(() => {
    const total = this.totalExpensePlanned();
    if (total === 0) return [];

    let acccumuletedPourcentage = 0;
    return this.expenseCategories().map(cat => {
      const percentage = cat.actualAmount / total;
      const strokeDasharray = `${percentage * this.INNER_EXPENSE_CIRCUMFERENCE} ${this.INNER_EXPENSE_CIRCUMFERENCE}`;
      const strokeDashoffset = -acccumuletedPourcentage * this.INNER_EXPENSE_CIRCUMFERENCE;

      acccumuletedPourcentage += (cat.plannedAmount / total);
      return {...cat, strokeDasharray, strokeDashoffset };
    });
  });

  readonly OUTER_INCOME_R: number = 160;
  readonly INNER_INCOME_R: number = 120;

  readonly OUTER_INCOME_CIRCUMFERENCE: number = 2 * Math.PI * this.OUTER_INCOME_R;
  readonly INNER_INCOME_CIRCUMFERENCE: number = 2 * Math.PI * this.INNER_INCOME_R;

  protected readonly incomeCategories = signal<CategoryShare[] |[]>([]);

  protected totalIncomePlanned = computed(() => 
    this.incomeCategories().reduce((sum, cat) => sum + cat.plannedAmount, 0)
  );

  protected incomeOuterSlices = computed(() => {
    const total = this.totalIncomePlanned();
    if (total === 0) return [];

    let accumulatedPercentage = 0;
    
    return this.incomeCategories().map(cat => {
      const percentage = cat.plannedAmount / total;
      const strokeDasharray = `${percentage * this.OUTER_INCOME_CIRCUMFERENCE} ${this.OUTER_INCOME_CIRCUMFERENCE}`;
      const strokeDashoffset = -accumulatedPercentage * this.OUTER_INCOME_CIRCUMFERENCE;

      accumulatedPercentage += percentage;
      return {... cat, strokeDasharray, strokeDashoffset };
    });
  });

  protected incomeInnerSlices = computed(() => {
    const total = this.totalIncomePlanned();
    if (total === 0) return [];

    let acccumuletedPourcentage = 0;
    return this.incomeCategories().map(cat => {
      const percentage = cat.actualAmount / total;
      const strokeDasharray = `${percentage * this.INNER_INCOME_CIRCUMFERENCE} ${this.INNER_INCOME_CIRCUMFERENCE}`;
      const strokeDashoffset = -acccumuletedPourcentage * this.INNER_INCOME_CIRCUMFERENCE;

      acccumuletedPourcentage += (cat.plannedAmount / total);
      return {...cat, strokeDasharray, strokeDashoffset };
    });
  });

  protected readonly accounts = signal<Account[] | []>([]);
  protected readonly currentAccountIndex = signal<number>(0);
  protected readonly currentAccount = computed(() => {
    const list = this.accounts();
    const index = this.currentAccountIndex();
    return list.length > 0 ? list[index] : null
  })

  readonly openAddAccount = output<void>();

  readonly openEditAccount = output<void>();

  protected previousAccount(): void {
    this.currentAccountIndex.update(i => Math.max(0, i - 1));
  };

  protected nextAccount(): void {
    this.currentAccountIndex.update(i => i + 1);
  };

  protected onAddAccountClick(): void {
    this.openAddAccount.emit();
  };

  protected onEditAccountClick(): void {
    this.openEditAccount.emit();
  };
}
