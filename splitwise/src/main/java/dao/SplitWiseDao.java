package dao;

import model.expense.Expense;
import model.user.User;

import java.util.Map;

public interface SplitWiseDao {
    void addUserToDb(User user);
    void addExpenseToDb(Expense expense);

    Map<String, Map<String, Double>> getBalanceSheet();
}
