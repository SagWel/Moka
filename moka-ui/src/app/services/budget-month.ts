import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BudgetMonth as BudgetMonthModel } from '../models/models';

@Injectable({
  providedIn: 'root',
})
export class BudgetMonth {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/budgetMonths';

  getAllBudgetMonths(): Observable<BudgetMonthModel[]> {
    return this.http.get<BudgetMonthModel[]>(this.apiUrl);
  }

  createBudgetMonth(budgetMonth: BudgetMonthModel): Observable<BudgetMonthModel> {
    return this.http.post<BudgetMonthModel>(this.apiUrl, budgetMonth);
  }

  deleteBudgetMonth(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
