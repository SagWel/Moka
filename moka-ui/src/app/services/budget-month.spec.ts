import { TestBed } from '@angular/core/testing';

import { BudgetMonth } from './budget-month';

describe('BudgetMonth', () => {
  let service: BudgetMonth;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BudgetMonth);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
