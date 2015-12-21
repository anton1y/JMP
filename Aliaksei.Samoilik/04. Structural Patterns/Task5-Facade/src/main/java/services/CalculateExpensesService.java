package services;

import java.util.List;

import jmp.creationalPatterns.facade.models.Expense;

public class CalculateExpensesService {
    public double calcExpenses(List<Expense> expenses) {
        return expenses.stream().mapToDouble(Expense::getExpense).sum();
    }
}
