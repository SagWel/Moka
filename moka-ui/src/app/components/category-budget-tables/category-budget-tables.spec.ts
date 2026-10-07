import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryBudgetTables } from './category-budget-tables';

describe('CategoryBudgetTables', () => {
  let component: CategoryBudgetTables;
  let fixture: ComponentFixture<CategoryBudgetTables>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CategoryBudgetTables],
    }).compileComponents();

    fixture = TestBed.createComponent(CategoryBudgetTables);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
