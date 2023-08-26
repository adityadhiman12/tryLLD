package service;

import dao.SplitWiseDao;
import model.expense.Expense;
import model.expense.ExpenseType;
import model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    public final SplitWiseDao splitWiseDao;

    public ExpenseManager(SplitWiseDao splitWiseDao) {
        this.splitWiseDao = splitWiseDao;
    }

    public void addUser(User user) {
        splitWiseDao.addUserToDb(user);

    }
    public void addExpense(String payer, String label, double amount, List<String> participants, ExpenseType expenseType) {
        ExpenseBuilder expensebuilder = new ExpenseBuilder(amount, participants);
        Map<String, Double> owerAmountMap = expenseType.getOweAmount(expensebuilder);
        Expense expense = new Expense(label, expenseType, amount, payer, owerAmountMap);
        splitWiseDao.addExpenseToDb(expense);
    }

    public void addExpense(String payer, String label, double amount, List<String> participants, ExpenseType expenseType, List<Double> expenseDivisonVars) {
        ExpenseBuilder expensebuilder = new ExpenseBuilder(amount, participants, expenseDivisonVars);
        Map<String, Double> owerAmountMap = expenseType.getOweAmount(expensebuilder);
        Expense expense = new Expense(label, expenseType, amount, payer, owerAmountMap);
        splitWiseDao.addExpenseToDb(expense);
    }

    public void showBalances() {
        Map<String, Map<String, Double>> balanceSheet = splitWiseDao.getBalanceSheet();
        for (String userId : balanceSheet.keySet()) {
            Map<String, Double> balances = balanceSheet.get(userId);
            for (String userId2 : balances.keySet()) {
                if (balances.get(userId2) > 0) {
                    printBalanceInfo(userId, userId2, balances.get(userId2));
                }
            }
        }
        System.out.println();
    }

    public void showBalances(String userId) {
        Map<String, Double> balanceSheet = splitWiseDao.getBalanceSheet().getOrDefault(userId, new HashMap<>());

        for (String userId2 : balanceSheet.keySet()) {
            if (balanceSheet.get(userId2) != 0) {
                printBalanceInfo(userId, userId2, balanceSheet.get(userId2));
            }
        }
        System.out.println();
    }

    private void printBalanceInfo(String userId1, String userId2, Double amount) {
        if (amount > 0) {
            System.out.println("User " + userId2 + " owes to " + userId1 + " : " + amount);
        } else {
            System.out.println("User " + userId1 + " owes to " + userId2 + " : " + Math.abs(amount));
        }
    }
}
