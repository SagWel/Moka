import { Component, signal } from '@angular/core';
import { Header } from '../../components/header/header';
import { AccountSummary } from '../../components/account-summary/account-summary';
import { CategoryBudgetTables } from '../../components/category-budget-tables/category-budget-tables';
import { TransactionList } from '../../components/transaction-list/transaction-list';
import { ProjectDashboard } from '../../components/project-dashboard/project-dashboard';

@Component({
  selector: 'app-home-page',
  imports: [Header,AccountSummary, CategoryBudgetTables, TransactionList, ProjectDashboard],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage {

  activeTab = signal<'BUDGETS' | 'PROJECTS'>('BUDGETS')

  selectTab(tab: 'BUDGETS' | 'PROJECTS'): void {
    this.activeTab.set(tab)
  }
}
