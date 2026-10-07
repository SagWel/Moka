import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction as TransactionModel } from '../models/models';

@Injectable({
  providedIn: 'root',
})
export class Transaction {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/transactions';

  getAllTransactions(): Observable<TransactionModel[]> {
    return this.http.get<TransactionModel[]>(this.apiUrl);
  }

  createTransaction(transaction: TransactionModel): Observable<TransactionModel> {
    return this.http.post<TransactionModel>(this.apiUrl, transaction)
  }

  deleteTranscation(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
