package dao;

import model.expense.Expense;
import model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseDaoImpl implements SplitWiseDao{
    private static SplitWiseDao splitWiseDao;
    private final Map<String, List<Expense>> userToExpensesMap;
    private final Map<String, Map<String, Double>> balanceSheet;

    private final List<User> users;

    private SplitWiseDaoImpl() {
        userToExpensesMap = new HashMap<>();
        balanceSheet = new HashMap<>();
        users = new ArrayList<>();
    }
     public static SplitWiseDao getInstance() {
        if(splitWiseDao == null) {
            splitWiseDao = new SplitWiseDaoImpl();
        }
        return splitWiseDao;
    }
    @Override
    public void addUserToDb(User user) {
        users.add(user);
        System.out.println(users);
    }

    @Override
    public void addExpenseToDb(Expense expense) {
        userToExpensesMap.getOrDefault(expense.getPayer(), new ArrayList<>()).add(expense);
        addOweAmount(expense.getPayer(), expense.getOwerAmountMap());
        System.out.println(balanceSheet);
    }

    @Override
    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }

    private void addOweAmount(String payerUserId, Map<String, Double> oweAmountMap) {
        for (String userId : oweAmountMap.keySet()) {
            Map<String, Double> balanceForPaidBy = balanceSheet.getOrDefault(payerUserId, new HashMap<>());
            if (!balanceForPaidBy.containsKey(userId)) {
                balanceForPaidBy.put(userId, (double) 0);
            }
            balanceForPaidBy.put(userId, balanceForPaidBy.get(userId) + oweAmountMap.get(userId));
            balanceSheet.put(payerUserId, balanceForPaidBy);

            Map<String, Double> balanceForPaidTo = balanceSheet.getOrDefault(userId, new HashMap<>());
            if (!balanceForPaidTo.containsKey(payerUserId)) {
                balanceForPaidTo.put(payerUserId, (double) 0);
            }
            balanceForPaidTo.put(payerUserId, balanceForPaidTo.get(payerUserId) - oweAmountMap.get(userId));
            balanceSheet.put(userId, balanceForPaidTo);
        }
    }
}
