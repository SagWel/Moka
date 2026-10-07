import { NgClass } from '@angular/common';
import { Component, output, signal } from '@angular/core';
import { LucideDynamicIcon } from '@lucide/angular';
import { TransactionStatus } from '../../models/models';

interface Transaction {
  label: string,
  date: string,
  amount: number,
  description: string,
  category: string,
  status: TransactionStatus,
  isRecurring: boolean
}

@Component({
  selector: 'app-transaction-list',
  imports: [LucideDynamicIcon, NgClass],
  templateUrl: './transaction-list.html',
  styleUrl: './transaction-list.css',
})
export class TransactionList {
  transactions = signal<Transaction[] | []>([]);

  openAddTransaction = output<void>();

  onAddTransactionClick(): void {
    this.openAddTransaction.emit();
  };

  openEditTransaction = output<void>();

  onEditTransactionClick(): void {
    this.openEditTransaction.emit();
  };
}
