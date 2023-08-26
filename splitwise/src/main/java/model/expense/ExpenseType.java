package model.expense;

import model.enums.EXPENSE_TYPE;
import service.ExpenseBuilder;

import java.util.Map;

public abstract class ExpenseType {
    private final EXPENSE_TYPE expenseType;
    public ExpenseType(EXPENSE_TYPE expenseType) {
        this.expenseType = expenseType;
    }
    public abstract Map<String, Double> getOweAmount(ExpenseBuilder expenseBuilder);
}
