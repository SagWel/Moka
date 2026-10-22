export enum CategoryType {
    INCOME = 'INCOME',
    EXPENSE = 'EXPENSE'
}

export enum TransactionStatus {
    PENDING = 'PENDING',
    CHECKED = 'CHECKED',
    REJECTED = 'REJECTED'
}

export enum Months {
    JANUARY = 'Janvier',
    FEBRUARY = 'Fevrier',
    MARCH = 'Mars',
    APRIL = 'Avril',
    MAY = 'Mai',
    JUNE = 'Juin',
    JULY = 'Juillet',
    AUGUST = 'Aout',
    SEPTEMBER = 'Septembre',
    OCTOBER = 'Octobre',
    NOVEMBER = 'Novembre',
    DECEMBER = 'Decembre'
}

export interface Category {
    id?: string,
    name: string,
    type: CategoryType,
    color: string,
    icon: string
}

export interface Account {
    id?: string,
    name: string,
    initialBalance: number,
    currentBalance: number,
    cashReserve: number,
    apiSyncEnabled: boolean,
    syncDayOfMonth: number
}

export interface Project {
    id?: string,
    name: string,
    targetAmount: number,
    currentAmount: number,
    targetDate: string,
    priority: number
}

export interface CategoryBudget {
    categoryId: string,
    allocatedAmount: number
}

export interface BudgetMonth {
    id?: string,
    month: number,
    year: number,
    targetIncome: number,
    categoryBudget : CategoryBudget[]
}

export interface Transaction {
    id?: string,
    acountId: string,
    categoryId: string,
    label: string,
    description: string,
    amount: number,
    date: string,
    status: TransactionStatus,
    isRecurring: boolean
}