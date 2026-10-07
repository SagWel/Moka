import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account as AccountModel } from '../models/models';

@Injectable({
  providedIn: 'root',
})
export class Account {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/accounts';

  getAllAccounts(): Observable<AccountModel[]> {
    return this.http.get<AccountModel[]>(this.apiUrl);
  }

  createAccount(account: AccountModel): Observable<AccountModel> {
    return this.http.post<AccountModel>(this.apiUrl, account);
  }
}
